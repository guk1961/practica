package ru.adedit.cron.model;

import javax.persistence.*;

/**
 * The persistent class for the smart_issues database table.
 * 
 */
@Entity
@Table(name="smart_issues")
@NamedQueries({@NamedQuery(name = "SmartIssue.findAll", query = "SELECT s FROM SmartIssue s WHERE s.name like '%портф%'"),
@NamedQuery(name = "SmartIssue.findById", query = "SELECT s FROM SmartIssue s WHERE s.id = :id"),
@NamedQuery(name = "SmartIssue.findByName", query = "SELECT s FROM SmartIssue s WHERE s.name like :name"),
@NamedQuery(name = "SmartIssue.findByNameChannel", query = "SELECT s FROM SmartIssue s WHERE s.smartChannel=:smartChannel and s.name like :name"),
@NamedQuery(name = "SmartIssue.findByOverrulepub", query = "SELECT s FROM SmartIssue s WHERE s.overrulepub = :overrulepub"),
@NamedQuery(name = "SmartIssue.findByCode", query = "SELECT s FROM SmartIssue s WHERE s.code = :code"),
@NamedQuery(name = "SmartIssue.findByPubldate", query = "SELECT s FROM SmartIssue s WHERE s.publdate = :publdate"),
@NamedQuery(name = "SmartIssue.findByDeadline", query = "SELECT s FROM SmartIssue s WHERE s.deadline like :deadline"),
@NamedQuery(name = "SmartIssue.findByDeadlinePub", query = "SELECT s FROM SmartIssue s WHERE s.deadline like :deadline AND s.smartChannel = :sch"),
@NamedQuery(name = "SmartIssue.getIssueNextPub", query = "SELECT s FROM SmartIssue s WHERE s.deadline > :curdate AND s.smartChannel = :sch  ORDER BY s.deadline"),
@NamedQuery(name = "SmartIssue.findIssueDeadlinePub", query = "SELECT s FROM SmartIssue s WHERE s.deadline like :deadline AND s.smartChannel = :sch AND s.deadline<=:date ORDER BY s.deadline DESC"),
@NamedQuery(name = "SmartIssue.findByPages", query = "SELECT s FROM SmartIssue s WHERE s.pages = :pages"),
@NamedQuery(name = "SmartIssue.findByActive", query = "SELECT s FROM SmartIssue s WHERE s.active = :active"),
@NamedQuery(name = "SmartIssue.findByReadingorderrev", query = "SELECT s FROM SmartIssue s WHERE s.readingorderrev = :readingorderrev")})
public class SmartIssue extends DomainObject {
	private static final long serialVersionUID = 1L;

	private String active;
	private int code;
	private String deadline;
    @Lob()
	private String description;
	private String name;
	private byte noarchive;
	private String overrulepub;
	private int pages;
	private String publdate;
	private String readingorderrev;
	@Transient
	private int smartObjects_id;
    @Lob()
	private String subject;
//    private String channelid;
//bi-directional many-to-one association to SmartChannel

    @ManyToOne
	@JoinColumn(name="channelid")
	private SmartChannel smartChannel;

    public SmartIssue() {
    }

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getNoarchive() {
		return this.noarchive;
	}

	public void setNoarchive(byte noarchive) {
		this.noarchive = noarchive;
	}

	public String getOverrulepub() {
		return this.overrulepub;
	}

	public void setOverrulepub(String overrulepub) {
		this.overrulepub = overrulepub;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPubldate() {
		return this.publdate;
	}

	public void setPubldate(String publdate) {
		this.publdate = publdate;
	}

	public String getReadingorderrev() {
		return this.readingorderrev;
	}

	public void setReadingorderrev(String readingorderrev) {
		this.readingorderrev = readingorderrev;
	}

	public int getSmartObjects_id() {
		return this.smartObjects_id;
	}

	public void setSmartObjects_id(int smartObjects_id) {
		this.smartObjects_id = smartObjects_id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public SmartChannel getSmartChannel() {
		return this.smartChannel;
	}

	public void setSmartChannel(SmartChannel smartChannel) {
		this.smartChannel = smartChannel;
	}
	

	    @Override
	    public String toString() {
	        return this.getClass().getName()+"[id=" + this.getId() + "]";
	    }

	
}