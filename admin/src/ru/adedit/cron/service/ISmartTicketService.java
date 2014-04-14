package ru.adedit.cron.service;

import java.util.ArrayList;

import javax.persistence.Query;

import ru.adedit.cron.model.SmartTickets;
import ru.adedit.cron.model.SmartUsers;

public interface ISmartTicketService extends IGenericService<SmartTickets> {
	
	 public ArrayList<SmartTickets> getTickets();
	 public ArrayList<SmartTickets> getTickets(int first, int total);
	 public SmartTickets getTicket(int id);
	 public ArrayList<SmartTickets> getTicketsUser(String usr);
	 public SmartUsers getUser(String user);
	 public long getCount();
}
