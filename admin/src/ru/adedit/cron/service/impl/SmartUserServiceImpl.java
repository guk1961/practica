package ru.adedit.cron.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartGroups;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ISmartUserService;

public class SmartUserServiceImpl extends GenericServiceImpl<SmartUsers> implements ISmartUserService{

	public SmartUserServiceImpl() {
		super(SmartUsers.class);
	}
	
    public List<SmartUsers> getUsers() {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.findAll");
        return (ArrayList <SmartUsers>) query.getResultList();
    }

    public List<SmartUsers> getUsers(int first, int total, String name) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.findByName");
        query.setParameter("name", "%"+name+"%");
        query.setFirstResult(first);
        query.setMaxResults(total);
        return (ArrayList <SmartUsers>) query.getResultList();
    }

    public List <SmartUsers> getUsersFromGroup(int id) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.findByUsersFromGroup");
        query.setParameter("id", id);
        return (ArrayList <SmartUsers>) query.getResultList();
    }

    public SmartUsers getUser(int id) {
        return getEmf().createEntityManager().find(SmartUsers.class, id);
    }

    public long getCountUsers(String name) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.getCountUsers");
        query.setParameter("name", "%"+name+"%");
        return (Long)query.getSingleResult();
    }

    public long getCount() {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.getCount");
        return (Long)query.getSingleResult();
    }

	@Override
	protected void beforeEntityAddUpdate(SmartUsers entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeEntityDelete(SmartUsers entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SmartUsers getUser(String user) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartUsers.findByUser");
        query.setParameter("user", user);
        return (SmartUsers)query.getSingleResult();
	}


}
