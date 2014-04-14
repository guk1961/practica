package ru.adedit.cron.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartIssueService;



public class SmartIssueServiceImpl extends GenericServiceImpl<SmartIssue> implements
		ISmartIssueService {
	/**
	 * Constructor
	 */
	public SmartIssueServiceImpl() {
		super(SmartIssue.class);
	}



	@Override
	public List<SmartIssue> getAllSorted(String propertySortBy, boolean asc)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SmartIssue> getIssues(int cannelId) {
//		 Query query = entityManager.createNamedQuery("SmartIssue.findByChannelid");
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.findByChannelid");
	        query.setParameter("channelid", cannelId);
	        return (ArrayList <SmartIssue>) query.getResultList();
	}

	public List<SmartIssue> getIssuesByDeadline(String deadline) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.findByDeadline");
	        query.setParameter("deadline", deadline);
	        return (ArrayList <SmartIssue>) query.getResultList();
	}
	@Override
	public List<SmartIssue> getIssuesByDeadlinePub(String deadline, SmartChannel sch) {
		 Query query = entityManager.createNamedQuery("SmartIssue.findByDeadlinePub");
	        query.setParameter("deadline", deadline);
	        query.setParameter("sch", sch);
	        return (ArrayList <SmartIssue>) query.getResultList();
	}

	public SmartIssue getIssueNext(String name, SmartChannel smartChannel) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.findByNameChannel");
	        query.setParameter("name", name);
	        query.setParameter("smartChannel", smartChannel);
	        return (SmartIssue) query.getSingleResult();
	}

	@Override
	public SmartIssue getIssueNextPub(String curdate, SmartChannel sch) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.getIssueNextPub");
	        query.setParameter("curdate", curdate);
	        query.setParameter("sch", sch);
	        query.setMaxResults(1);
	        return (SmartIssue) query.getSingleResult();
	}

	
	@Override
	public SmartIssue getIssue(int issueId) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.findById");
	        query.setParameter("id", issueId);
	        return (SmartIssue) query.getSingleResult();
	}

	@Override
	public SmartIssue getIssueDeadlinePub(String date, String deadline, SmartChannel sch) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartIssue.findIssueDeadlinePub");
	        query.setParameter("deadline", deadline);
	        query.setParameter("sch", sch);
	        query.setParameter("date", date);
	        query.setMaxResults(1);
	        return (SmartIssue)query.getSingleResult(); 
	}

	
	
	public static String dateToString(Date a_date, String a_dateFormat) {
	    SimpleDateFormat sdf = new SimpleDateFormat(a_dateFormat);
	    return sdf.format(a_date);
	 }


	@Override
	protected void beforeEntityAddUpdate(SmartIssue entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void beforeEntityDelete(SmartIssue entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getIssuePubDate(SmartIssue issue) {
		String date=issue.getPubldate().substring(0, 10);
		date=date.substring(8)+"."+date.substring(5,7)+"."+date.substring(0,4);
		return date;
	}






}
