package ru.adedit.cron.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the smart_publications database table.
 * 
 */
@Entity
@Table(name="smart_publications")
@NamedQueries({@NamedQuery(name = "SmartPublication.findAll", query = "SELECT s FROM SmartPublication s ORDER by s.code"),
@NamedQuery(name = "SmartPublication.findById", query = "SELECT s FROM SmartPublication s WHERE s.id = :id"),
@NamedQuery(name = "SmartPublication.findByPublication", query = "SELECT s FROM SmartPublication s WHERE s.publication = :publication"),
@NamedQuery(name = "SmartPublication.findByCode", query = "SELECT s FROM SmartPublication s WHERE s.code = :code"),
@NamedQuery(name = "SmartPublication.findByEmail", query = "SELECT s FROM SmartPublication s WHERE s.email = :email"),
@NamedQuery(name = "SmartPublication.findByReadingorderrev", query = "SELECT s FROM SmartPublication s WHERE s.readingorderrev = :readingorderrev"),
@NamedQuery(name = "SmartPublication.findByDefaultchannelid", query = "SELECT s FROM SmartPublication s WHERE s.defaultchannelid = :defaultchannelid"),
@NamedQuery(name = "SmartPublication.findByGazetId", query = "SELECT s FROM SmartPublication s WHERE s.gazetId = :gazetId")})
public class SmartPublication extends DomainObject {
	private static final long serialVersionUID = 1L;

//	@Id
//	private int id;

	private int code;

	private int defaultchannelid;

   
	private String description;

	private String email;

	@Column(name="gazet_id")
	private int gazetId;

	private String publication;

	private String readingorderrev;

	//bi-directional many-to-one association to SmartChannel
	@OneToMany(mappedBy="smartPublication")
	private List<SmartChannel> smartChannels;

    public SmartPublication() {
    }
//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDefaultchannelid() {
		return this.defaultchannelid;
	}

	public void setDefaultchannelid(int defaultchannelid) {
		this.defaultchannelid = defaultchannelid;
	}
	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String string) {
		this.description = string;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGazetId() {
		return this.gazetId;
	}

	public void setGazetId(int gazetId) {
		this.gazetId = gazetId;
	}

	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getReadingorderrev() {
		return this.readingorderrev;
	}

	public void setReadingorderrev(String readingorderrev) {
		this.readingorderrev = readingorderrev;
	}

	public List<SmartChannel> getSmartChannels() {
		return this.smartChannels;
	}

	public void setSmartChannels(List<SmartChannel> smartChannels) {
		this.smartChannels = smartChannels;
	}

	public String getUrl() {
    	return "pub?id=" + this.getId();
    }
	    @Override
    public String toString() {
	        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}