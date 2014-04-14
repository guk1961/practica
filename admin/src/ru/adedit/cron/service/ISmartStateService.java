package ru.adedit.cron.service;

import java.util.List;

import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.model.SmartStates;

public interface ISmartStateService extends IGenericService<SmartStates> {
	
	public List<SmartStates> getStatesByPub(int publication);
//	public SmartStates getStateBy(int publication);

}
