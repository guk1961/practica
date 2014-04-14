package ru.adedit.cron.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartGroups;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ISmartGroupService;

public class SmartGroupServiceImpl extends GenericServiceImpl<SmartGroups>	implements ISmartGroupService {

	public SmartGroupServiceImpl() {
		super(SmartGroups.class);
		// TODO Auto-generated constructor stub
	}
	
	
    public List<SmartGroups> getGroups() {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartGroups.findAll");
        return (ArrayList <SmartGroups>) query.getResultList();
    }

    public List<SmartGroups> getGroups(int first, int total, String name) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartGroups.findByName");
        query.setParameter("name", "%"+name+"%");
        query.setFirstResult(first);
        query.setMaxResults(total);
        return (ArrayList <SmartGroups>) query.getResultList();
    }

    public List <SmartGroups> getGroupsFromUser(int id) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartGroups.findByGroupsFromUser");
        query.setParameter("id", id);
        return (ArrayList <SmartGroups>) query.getResultList();
    }

    public SmartGroups getGroup(int id) {
        return getEmf().createEntityManager().find(SmartGroups.class, id);
    }

    public long getCountGroups(String name) {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartGroups.getCountGroups");
        query.setParameter("name", "%"+name+"%");
        return (Long)query.getSingleResult();
    }

    public long getCount() {
        Query query = getEmf().createEntityManager().createNamedQuery("SmartGroups.getCount");
        return (Long)query.getSingleResult();
    }


	@Override
	protected void beforeEntityAddUpdate(SmartGroups entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeEntityDelete(SmartGroups entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

}
