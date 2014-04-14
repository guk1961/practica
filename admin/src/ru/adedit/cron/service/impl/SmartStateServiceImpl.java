package ru.adedit.cron.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.model.SmartStates;
import ru.adedit.cron.service.ISmartStateService;

public class SmartStateServiceImpl extends GenericServiceImpl<SmartStates> implements
		ISmartStateService {

	public SmartStateServiceImpl() {
		super(SmartStates.class);
	}

	@Override
	protected void beforeEntityAddUpdate(SmartStates entity)
			throws GeneralServiceException {
	}

	@Override
	protected void beforeEntityDelete(SmartStates entity)
			throws GeneralServiceException {
	}

	@Override
	public List<SmartStates> getStatesByPub(int publication) {
		 Query query = getEmf().createEntityManager().createNamedQuery("SmartStates.findByPublication");
	        query.setParameter("publication", publication);
	        return (ArrayList <SmartStates>) query.getResultList();
	}


}
