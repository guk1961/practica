package ru.adedit.cron.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;

import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartChannelService;
import ru.adedit.cron.service.ISmartIssueService;
import ru.adedit.cron.service.ISmartPublicationService;



public class SetCurrentPubs {

	public final static String DATEFORMAT_FULL = "yyyy.MM.dd HH:mm:ss:SSS";
	
	SmartPublication publication;// = new SmartPublication();
	SmartIssue issue;
	SmartChannel channel;
	@Autowired
	ISmartChannelService channelService;
	@Autowired
	ISmartPublicationService publicationService;
	@Autowired
	ISmartIssueService issueService;
	
	protected EntityManager entityManager;
	protected EntityManagerFactory emf;
	
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
	
	private class MessagePrinterTask implements Runnable {

		private String message;

		public MessagePrinterTask(String message) {
			this.message = message;
		}
		public void run() {
			System.out.println(message);
		}
	}

	private TaskExecutor taskExecutor;

	public SetCurrentPubs(TaskExecutor taskExecutor) {

		this.taskExecutor = taskExecutor;

	}
	public static String dateToString(Date a_date, String a_dateFormat) {
	    SimpleDateFormat sdf = new SimpleDateFormat(a_dateFormat);
	    return sdf.format(a_date);
	 }

//	@Scheduled(fixedDelay=5000)
//	@Scheduled(cron = "0/10 * * * * *")
	public void printMessages() {

//		System.out.println("entityManagerFactory " + emf.toString());
//		getEmf.createEntityManager();
//		taskExecutor.execute(new MessagePrinterTask("Перевод номеров " + dateToString(new Date(),DATEFORMAT_FULL )));
/////////////////////////
//
//	    	DateUtils du = new DateUtils();
//			channel.setId(9);
	    	String curDate = dateToString(new Date(),DATEFORMAT_FULL );
	    	String deadline;
	    	deadline = curDate.substring(0,4)+"-"+curDate.substring(5,7)+"-"+curDate.substring(8,10);
	    		
        	List <SmartChannel> channeldeadline	= channelService.getChannels(100); 
	    	
//	        	List <SmartIssue> issuedeadline	= issueService.getIssuesByDeadline(deadline+"%"); 
//	        	List <SmartIssue> issuedeadline	= issueService.getIssuesByDeadlinePub(deadline, channel); 
	        	System.out.println("размер "+channeldeadline.size()+" channeldeadline="+channeldeadline+ " "+deadline); 

	        	for(SmartChannel sch:channeldeadline){
	        		SmartPublication sp = 	emf.createEntityManager().find(SmartPublication.class,sch.getSmartPublication().getId());
	        		System.out.println(sch.getName()+"  "+sch.getCurrentissueid()+"  "+sp.getPublication()+" "+ 
	        		issueService.getIssue(sch.getCurrentissueid()).getName()+" "+issueService.getIssue(sch.getCurrentissueid()).getDeadline());
	        	}

//	        	for(SmartIssue si:issuedeadline){
//	        		System.out.println(si.getDeadline()+"  "+si.getName()+"  "+deadline);
//	        	}

	        	
//	        	EntityTransaction tx = em.getTransaction(); 
//	    		tx.begin(); 
//	    		String nextday	=	"1";
//	    		String result;
//	    		String currentPubs="";
//	    		try {
//	        	if (issuedeadline!=null){
//	        		for(SmartIssue siss:issuedeadline){
//	        			nextday	=	siss.getName().substring(5,7);
//	        			int dd	=	Integer.parseInt(nextday)+1;
//	        			nextday	=	(String) ((dd<10)?"0"+dd:dd);
//	        			nextday	=	deadline.substring(0,5)+ nextday;
//
//	        			SmartChannel sch	=	em.find(SmartChannel.class, siss.getSmartChannel().getId());
//	        			SmartPublication sp = 	em.find(SmartPublication.class,sch.getSmartPublication().getId());
//	        			System.out.println("nextday="+nextday+" channel="+sch.getName()+" publication="+sp.getPublication()+" issuedeadline="+siss.getName());
//	                	SmartIssue issuenext	= issueService.getIssueNext(nextday+"%", sch); 
//	        			sch.setCurrentissueid(issuenext.getId());
//	        			currentPubs = sp.getPublication();
//	        			em.persist(sch);
//	        			result	= "oldId = "+ sch.getCurrentissueid()+"  "+
//	    	                	sp.getPublication()+" NewId = " + issuenext.getId()+"  "+issuenext.getName();
//
//	        			System.out.println(result);        			
//	        		}
//	        		tx.commit();
//	        		em.flush();
//	        	}
//	    		}
//	    		catch(Exception e){
//	    			if (tx.isActive())	
//	    			tx.rollback();
//	    			
//	    			e.printStackTrace();
//	    		}
//	    		finally{
//	        		em.clear();
//	    		}
	    		//////////////////////			
//	        	em.close();
	}
	
	
}
