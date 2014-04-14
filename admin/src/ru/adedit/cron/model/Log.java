package ru.adedit.cron.model;

import javax.persistence.*;

import ru.adedit.cron.model.DomainObject;

/**
 * Entity implementation class for Entity: TestJpa
 *
 */

@Entity @Table(name = "log_cron") 
@NamedQueries({
	@NamedQuery(name = "Log.findAll", query = "SELECT s FROM Log s ORDER BY s.result DESC"),
	@NamedQuery(name = "Log.findByResult", query = "SELECT s FROM Log s WHERE s.result LIKE :result")
})

public class Log extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String jobname;
	String startDate;
	String endDate;
	String result;
	
	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Log() {
		super();
	}

	    @Override
	    public String toString() {
	        return "ru.dmir.cron.model.Log[id=" + this.getId() + "]";
	    }

}
