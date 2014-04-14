package ru.adedit.cron.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.exeption.GeneralServiceException;
import ru.adedit.cron.model.Log;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ILogService;

public class LogServiceImpl extends GenericServiceImpl<Log> implements
		ILogService {

	public LogServiceImpl() {
		super(Log.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void beforeEntityAddUpdate(Log entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeEntityDelete(Log entity)
			throws GeneralServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List <Log> getLog() {
        Query query = getEmf().createEntityManager().createNamedQuery("Log.findAll");
        return (ArrayList <Log>) query.getResultList();
	}

}
