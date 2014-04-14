package ru.adedit.cron.service.impl;

import java.util.ArrayList;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartTickets;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ISmartTicketService;

public class SmartTicketServiceImpl extends GenericServiceImpl<SmartTickets> implements ISmartTicketService{

	public SmartTicketServiceImpl() {
		super(SmartTickets.class);
	}
	
	
	 public ArrayList<SmartTickets> getTickets() {
	        Query query = getEmf().createEntityManager().createNamedQuery("SmartTickets.findAll");
	        return (ArrayList <SmartTickets>) query.getResultList();
	    }

	    public ArrayList<SmartTickets> getTickets(int first, int total) {
	        Query query = getEmf().createEntityManager().createNamedQuery("SmartTickets.findAll");
	        query.setFirstResult(first);
	        query.setMaxResults(total);
	        return (ArrayList <SmartTickets>) query.getResultList();
	    }

	    public SmartTickets getTicket(int id) {
	        return entityManager.find(SmartTickets.class, id);
	    }


	    public ArrayList<SmartTickets> getTicketsUser(String usr) {
	        Query query = getEmf().createEntityManager().createNamedQuery("SmartTickets.findByUsr");
	        query.setParameter("usr", usr);
	        return (ArrayList <SmartTickets>) query.getResultList();
	    }

	       public SmartUsers getUser(String user) {
	        return getEmf().createEntityManager().find(SmartUsers.class, user);
	    }
	
	       public long getCount() {
		        Query query = getEmf().createEntityManager().createNamedQuery("SmartTickets.getCount");
		        return (Long)query.getSingleResult();
		    }

	@Override
	protected void beforeEntityAddUpdate(SmartTickets entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	protected void beforeEntityDelete(SmartTickets entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}
}
