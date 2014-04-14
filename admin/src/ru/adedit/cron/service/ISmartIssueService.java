package ru.adedit.cron.service;


import java.util.Collection;
import java.util.List;

import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;




public interface ISmartIssueService extends IGenericService<SmartIssue>{

	public Collection<SmartIssue> getIssues(int publicationId);
	public SmartIssue getIssue(int issueId);
	public String getIssuePubDate(SmartIssue issue);
	public List<SmartIssue> getIssuesByDeadline(String string);
	public SmartIssue getIssueNext(String string, SmartChannel sch);
	public List<SmartIssue> getIssuesByDeadlinePub(String deadline, SmartChannel spub);
	public SmartIssue getIssueDeadlinePub(String date, String deadline, SmartChannel sch);
	public SmartIssue getIssueNextPub(String curdate, SmartChannel sch);
	
}
