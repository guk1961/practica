package ru.adedit.cron.job;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;

import ru.adedit.cron.model.Log;
import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartChannelService;
import ru.adedit.cron.service.ISmartIssueService;
import ru.adedit.cron.service.ISmartPublicationService;
import ru.adedit.cron.service.mail.IssueMailManager;
import ru.adedit.cron.service.mail.IssueManager;


public class CurrentIssue {

public final static String DATEFORMAT_FULL = "yyyy-MM-dd HH:mm:ss:SSS";
	
//private static Logger _log = LoggerFactory.getLogger(CurrentIssue.class);
	SmartPublication publication;// = new SmartPublication();
	SmartIssue issue;
	SmartChannel channel;
	@Autowired
	ISmartChannelService channelService;
	@Autowired
	ISmartPublicationService publicationService;
	@Autowired
	ISmartIssueService issueService;
	
	@Autowired
	IssueManager issueManager;
	@Autowired
	IssueMailManager issueMailManager;
	
	protected EntityManager entityManager;
	protected EntityManagerFactory emf;
	
	private TaskExecutor taskExecutor;
	
	Console con = System.console();

	public CurrentIssue(TaskExecutor taskExecutor) {

		this.taskExecutor = taskExecutor;

	}
	
	
	@PersistenceUnit(unitName="cron")
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManagerFactory getEmf() {
	return emf;
	}
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public static String dateToString(Date a_date, String a_dateFormat) {
	    SimpleDateFormat sdf = new SimpleDateFormat(a_dateFormat);
	    return sdf.format(a_date);
	 }

	@Scheduled(cron = "0 0/33 * * * *")
	public void setCurrentIssue() throws ParseException {
		boolean flagnext=false;
		String curDate = dateToString(new Date(), DATEFORMAT_FULL );
    	String date = curDate.substring(0,10)+"T00:00:00";

    	entityManager	=	emf.createEntityManager();
       	EntityTransaction tx = entityManager.getTransaction(); 
    	tx.begin();
    	SmartIssue sid = null;
    	try {
	    	List<SmartChannel> channels = (List<SmartChannel>)channelService.getChannels(100); 
	    	
	    	for(SmartChannel sch:channels){
	    		Log log= new Log();
	        	log.setStartDate(curDate);
	    		SmartIssue si=issueService.getEntityById(sch.getCurrentissueid());
	        	if (date.compareTo(si.getDeadline())>=0){
		    		flagnext=true;
	        		publication = sch.getSmartPublication();
	        		channel	= entityManager.find(SmartChannel.class, sch.getId());
		    		sid=issueService.getIssueNextPub(date, sch);
		    		channel.setCurrentissueid(sid.getId());
	        		entityManager.persist(channel);
	        		String result= curDate+" "+publication.getPublication()+" установлен тек. № "+sid.getName();//+" id="+sch.getCurrentissueid();
//	        		con.printf(result+"\n");
	        		System.out.println(result);
		        	log.setJobname(this.toString());
		        	log.setResult(result);
		        	log.setEndDate(curDate);
		        	entityManager.persist(log);
	        		issueManager.setIssue(result);
	        	}
	    	}
//	    	if (flagnext){
//	    		
//	    		List<SmartPublication> pubs=(List<SmartPublication>) publicationService.getPublications();
//	    		Map model = new HashMap();
//	    		model.put("schs", channelService);
//	    		model.put("channel", channel);
//	    		model.put("issue", sid);
//	    		model.put("sis", issueService);
//	    		model.put("pubs", pubs);
//	    		model.put("pub", publication);
//	    		model.put("curDate", curDate);
//	    		model.put("date", date);
//	    		
//	    		issueMailManager.sendMail(model);
//	    	}
//	    	else {
//	        	System.out.println( dateToString(new Date(), DATEFORMAT_FULL )+" Net nomerov dlya perevoda : " + curDate);
////        		con.printf(curDate+" Нет номеров для перевода"+"\n");
//	    	}
	    	tx.commit();
	    	}
	    	catch(Exception e){
    			if (tx.isActive())	
    			tx.rollback();
    			e.printStackTrace();
    		}
    		finally{
    			entityManager.flush();
    			entityManager.clear();
    			entityManager.close();
    		}
	}

	public static void main(String[] args){
		Logger _log = LoggerFactory.getLogger(CurrentIssue.class);		
		String test="2013-02-04T00:00:00";
    	_log.debug(test);
    	System.out.println((test.compareTo("2013-02-05")>0)+""+_log.getName());
    	System.out.println(test.compareTo("111")>0);
    	System.out.println(test.compareTo("002")<0);
    	
	}
	
}
