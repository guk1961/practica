package ru.adedit.cron.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the smart_targets database table.
 * 
 */
@Entity
@Table(name="smart_targets")
public class SmartTarget extends DomainObject {
	
	private static final long serialVersionUID = 1L;

//	@Id
//	private int id;

	private int channelid;
	private String externalid;
	private int issueid;
	private int objectid;
	private int objectrelationid;
	private String publisheddate;
	private int publishedmajorversion;
	private int publishedminorversion;
	private int smartObjects_id;

    public SmartTarget() {
    }

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getChannelid() {
		return this.channelid;
	}

	public void setChannelid(int channelid) {
		this.channelid = channelid;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public int getIssueid() {
		return this.issueid;
	}

	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	public int getObjectid() {
		return this.objectid;
	}

	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}

	public int getObjectrelationid() {
		return this.objectrelationid;
	}

	public void setObjectrelationid(int objectrelationid) {
		this.objectrelationid = objectrelationid;
	}

	public String getPublisheddate() {
		return this.publisheddate;
	}

	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}

	public int getPublishedmajorversion() {
		return this.publishedmajorversion;
	}

	public void setPublishedmajorversion(int publishedmajorversion) {
		this.publishedmajorversion = publishedmajorversion;
	}

	public int getPublishedminorversion() {
		return this.publishedminorversion;
	}

	public void setPublishedminorversion(int publishedminorversion) {
		this.publishedminorversion = publishedminorversion;
	}

	public int getSmartObjects_id() {
		return this.smartObjects_id;
	}

	public void setSmartObjects_id(int smartObjects_id) {
		this.smartObjects_id = smartObjects_id;
	}

    @Override
    public String toString() {
	        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}