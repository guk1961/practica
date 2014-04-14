package ru.adedit.cron.service;

import java.util.List;

import ru.adedit.cron.model.SmartUsers;

public interface ISmartUserService extends IGenericService<SmartUsers> {

	public List<SmartUsers> getUsers(int first, int total, String name);
	public List<SmartUsers> getUsers();
	public List <SmartUsers> getUsersFromGroup(int id);
	public SmartUsers getUser(int userId);
	public SmartUsers getUser(String user);
//	public List<SmartUsers> getUsersActived();
    public long getCountUsers(String name);
    public long getCount();
	
}
