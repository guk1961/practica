package ru.adedit.cron.service.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartChannelService;
import ru.adedit.cron.service.ISmartPublicationService;

public class SmartChannelServiceImpl extends GenericServiceImpl<SmartChannel>
		implements ISmartChannelService {

	/**
	 * Constructor
	 */
	public SmartChannelServiceImpl() {
		super(SmartChannel.class);
	}
	
	protected ISmartPublicationService smartPublicationService; 
	protected ISmartChannelService smartChannelService; 

	
	public ISmartPublicationService getSmartPublicationService() {
		return smartPublicationService;
	}

	public void setSmartPublicationService(
			ISmartPublicationService smartPublicationService) {
		this.smartPublicationService = smartPublicationService;
	}

	public ISmartChannelService getSmartChannelService() {
		return smartChannelService;
	}

	public void setSmartChannelService(ISmartChannelService smartChannelService) {
		this.smartChannelService = smartChannelService;
	}


	@Override
	public void delEntity(SmartChannel entity) throws IllegalArgumentException,
			GeneralServiceException {
		// TODO Auto-generated method stub

	}


	@Override
	public SmartChannel getEntityById(Integer id)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartChannel getChannel(int publicationId) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartChannel.findByPublicationid");
	     query.setParameter("publicationid", publicationId);
	     return (SmartChannel) query.getSingleResult();
	}

	@Override
	public List<SmartChannel> getChannels(int code) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartChannel.getAll");
	     query.setParameter("code", code);
	     return (List<SmartChannel>) query.getResultList();
	}

	public SmartChannel getChannel(SmartPublication publication) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartChannel.findByPublication");
	     query.setParameter("publication", publication);
	     return (SmartChannel) query.getSingleResult();
	}

	@Override
	protected void beforeEntityAddUpdate(SmartChannel entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeEntityDelete(SmartChannel entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}
}
