package ru.adedit.cron.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartPublicationService;


@Service
public class SmartPublicationServiceImpl extends GenericServiceImpl<SmartPublication>
		implements ISmartPublicationService {

	/**
	 * Constructor
	 */
	public SmartPublicationServiceImpl() {
		super(SmartPublication.class);
		// TODO Auto-generated constructor stub
	}

	



	@Override
	protected void beforeEntityAddUpdate(SmartPublication entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeEntityDelete(SmartPublication entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<SmartPublication> getPublications() {
        Query query = emf.createEntityManager().createNamedQuery("SmartPublication.findAll");
       return (ArrayList <SmartPublication>) query.getResultList();

	}



	@Override
	public void delEntity(Integer id) throws IllegalArgumentException,
			GeneralServiceException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public SmartPublication getEntityById(Integer id)
			throws IllegalArgumentException {
			
		Query query = emf.createEntityManager().createNamedQuery("SmartPublication.findById");
		query.setParameter("id", id);
		return (SmartPublication) query.getSingleResult();
		
	}



	@Override
	public void delAllEntities(Collection<Integer> ids)
			throws IllegalArgumentException, GeneralServiceException {
		// TODO Auto-generated method stub
		
	}




}
