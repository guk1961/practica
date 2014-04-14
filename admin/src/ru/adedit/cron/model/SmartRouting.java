/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.adedit.cron.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Yuri_Zhlz
 */
@Entity
@Table(name = "smart_routing")
@NamedQueries({@NamedQuery(name = "SmartRouting.findAll", query = "SELECT s FROM SmartRouting s"),
@NamedQuery(name = "SmartRouting.findById", query = "SELECT s FROM SmartRouting s WHERE s.id = :id"),
@NamedQuery(name = "SmartRouting.findByPublication", query = "SELECT s FROM SmartRouting s WHERE s.publication = :publication"),
@NamedQuery(name = "SmartRouting.findBySection", query = "SELECT s FROM SmartRouting s WHERE s.section = :section"),
@NamedQuery(name = "SmartRouting.findByState", query = "SELECT s FROM SmartRouting s WHERE s.state = :state"),
@NamedQuery(name = "SmartRouting.findByRouteto", query = "SELECT s FROM SmartRouting s WHERE s.routeto = :routeto"),
@NamedQuery(name = "SmartRouting.findByIssue", query = "SELECT s FROM SmartRouting s WHERE s.issue = :issue")})
public class SmartRouting extends DomainObject {
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "publication")
    private int publication;
    @Basic(optional = false)
    @Column(name = "section")
    private int section;
    @Basic(optional = false)
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @Column(name = "routeto")
    private String routeto;
    @Basic(optional = false)
    @Column(name = "issue")
    private int issue;

//    @JoinColumn(name = "state")
//    @ManyToOne(optional = false)
//    private SmartStates smartStates;
//
//    public SmartStates getStates(){
//        return smartStates;
//    }

    public SmartRouting() {
    }


    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRouteto() {
        return routeto;
    }

    public void setRouteto(String routeto) {
        this.routeto = routeto;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmartRouting)) {
            return false;
        }
        SmartRouting other = (SmartRouting) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}
