package ru.adedit.cron.model;


import javax.persistence.*;
import java.util.Set;
/**
 * The persistent class for the smart_channels database table.
 * 
 */

@Entity
@Table(name="smart_channels")
@NamedQueries({
@NamedQuery(name = "SmartChannel.findAll", query = "SELECT s FROM SmartChannel s"),
@NamedQuery(name = "SmartChannel.getAll", query = "SELECT s FROM SmartChannel s WHERE s.smartPublication IN(SELECT s FROM SmartPublication s WHERE  s.code<:code)"),
@NamedQuery(name = "SmartChannel.findById", query = "SELECT s FROM SmartChannel s WHERE s.id = :id"),
@NamedQuery(name = "SmartChannel.findByName", query = "SELECT s FROM SmartChannel s WHERE s.name = :name"),
@NamedQuery(name = "SmartChannel.findByPublication", query = "SELECT s FROM SmartChannel s WHERE s.name like '%Print%' and s.smartPublication = :publication"),
@NamedQuery(name = "SmartChannel.findByType", query = "SELECT s FROM SmartChannel s WHERE s.type = :type"),
@NamedQuery(name = "SmartChannel.findByDescription", query = "SELECT s FROM SmartChannel s WHERE s.description = :description"),
@NamedQuery(name = "SmartChannel.findByCode", query = "SELECT s FROM SmartChannel s WHERE s.code = :code"),
@NamedQuery(name = "SmartChannel.findByDeadlinerelative", query = "SELECT s FROM SmartChannel s WHERE s.deadlinerelative = :deadlinerelative"),
@NamedQuery(name = "SmartChannel.findByCurrentissueid", query = "SELECT s FROM SmartChannel s WHERE s.currentissueid = :currentissueid"),
@NamedQuery(name = "SmartChannel.findByPublishsystem", query = "SELECT s FROM SmartChannel s WHERE s.publishsystem = :publishsystem")})

public class SmartChannel extends DomainObject {
	
	private static final long serialVersionUID = 1L;

	//	@Id
//	private int id;

	private int code;
	private int currentissueid;
	private int deadlinerelative;
	private String description;
	private String name;
	private String publishsystem;
	private String type;

	//bi-directional many-to-one association to SmartPublication
    @ManyToOne
	@JoinColumn(name="publicationid")
	private SmartPublication smartPublication;

	//bi-directional many-to-one association to SmartIssue
	@OneToMany(mappedBy="smartChannel")
	private Set<SmartIssue> smartIssues;

    public SmartChannel() {
    }

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCurrentissueid() {
		return this.currentissueid;
	}

	public void setCurrentissueid(int currentissueid) {
		this.currentissueid = currentissueid;
	}

	public int getDeadlinerelative() {
		return this.deadlinerelative;
	}

	public void setDeadlinerelative(int deadlinerelative) {
		this.deadlinerelative = deadlinerelative;
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

	public String getPublishsystem() {
		return this.publishsystem;
	}

	public void setPublishsystem(String publishsystem) {
		this.publishsystem = publishsystem;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SmartPublication getSmartPublication() {
		return this.smartPublication;
	}

	public void setSmartPublication(SmartPublication smartPublication) {
		this.smartPublication = smartPublication;
	}
	
	public Set<SmartIssue> getSmartIssues() {
		return this.smartIssues;
	}

	public void setSmartIssues(Set<SmartIssue> smartIssues) {
		this.smartIssues = smartIssues;
	}


	    @Override
	    public String toString() {
	        return "ru.adedit.cron.model.SmartChannel[id=" + this.getId() + "]";
	    }
	
}