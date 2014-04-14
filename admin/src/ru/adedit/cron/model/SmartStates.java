/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.adedit.cron.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Yuri_Zhlz
 */
@Entity
@Table(name = "smart_states")
@NamedQueries({@NamedQuery(name = "SmartStates.findAll", query = "SELECT s FROM SmartStates s ORDER BY s.publication, s.state"),
//@NamedQuery(name = "SmartStates.findTop", query = "SELECT s FROM SmartStates s WHERE s.age 0; 20"),
@NamedQuery(name = "SmartStates.getCount", query = "select count(distinct s.id) from SmartStates s"),
@NamedQuery(name = "SmartStates.findById", query = "SELECT s FROM SmartStates s WHERE s.id = :id"),
@NamedQuery(name = "SmartStates.findByPublication", query = "SELECT s FROM SmartStates s WHERE s.publication = :publication"),
@NamedQuery(name = "SmartStates.findByType", query = "SELECT s FROM SmartStates s WHERE s.type = :type"),
@NamedQuery(name = "SmartStates.findByState", query = "SELECT s FROM SmartStates s WHERE s.state = :state"),
@NamedQuery(name = "SmartStates.findByProduce", query = "SELECT s FROM SmartStates s WHERE s.produce = :produce"),
@NamedQuery(name = "SmartStates.findByColor", query = "SELECT s FROM SmartStates s WHERE s.color = :color"),
@NamedQuery(name = "SmartStates.findByNextstate", query = "SELECT s FROM SmartStates s WHERE s.nextstate = :nextstate"),
@NamedQuery(name = "SmartStates.findByCode", query = "SELECT s FROM SmartStates s WHERE s.code = :code"),
@NamedQuery(name = "SmartStates.findByIssue", query = "SELECT s FROM SmartStates s WHERE s.issue = :issue"),
@NamedQuery(name = "SmartStates.findBySection", query = "SELECT s FROM SmartStates s WHERE s.section = :section"),
@NamedQuery(name = "SmartStates.findByDeadlinestate", query = "SELECT s FROM SmartStates s WHERE s.deadlinestate = :deadlinestate"),
@NamedQuery(name = "SmartStates.findByDeadlinerelative", query = "SELECT s FROM SmartStates s WHERE s.deadlinerelative = :deadlinerelative"),
@NamedQuery(name = "SmartStates.findByCreatepermanentversion", query = "SELECT s FROM SmartStates s WHERE s.createpermanentversion = :createpermanentversion"),
@NamedQuery(name = "SmartStates.findByRemoveintermediateversions", query = "SELECT s FROM SmartStates s WHERE s.removeintermediateversions = :removeintermediateversions"),
@NamedQuery(name = "SmartStates.findByAutomaticallysendtonext", query = "SELECT s FROM SmartStates s WHERE s.automaticallysendtonext = :automaticallysendtonext")})

public class SmartStates extends DomainObject {
	private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "publication")
    private int publication;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "produce")
    private String produce;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "nextstate")
    private int nextstate;
    @Basic(optional = false)
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @Column(name = "issue")
    private int issue;
    @Basic(optional = false)
    @Column(name = "section")
    private int section;
    @Basic(optional = false)
    @Column(name = "deadlinestate")
    private int deadlinestate;
    @Basic(optional = false)
    @Column(name = "deadlinerelative")
    private int deadlinerelative;
    @Basic(optional = false)
    @Column(name = "createpermanentversion")
    private String createpermanentversion;
    @Basic(optional = false)
    @Column(name = "removeintermediateversions")
    private String removeintermediateversions;
    @Basic(optional = false)
    @Column(name = "automaticallysendtonext")
    private String automaticallysendtonext;

    
    @OneToMany//(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<SmartRouting> smartRouting;


    public  Collection<SmartRouting> getRouting(){
        return smartRouting;
    }


//@OneToMany(mappedBy = "smartStates")
//private SmartRouting smartRouting;

//    @ManyToOne
//    @JoinColumn(name="id")
//    private SmartPublications smartPublications;
//
//    public void setSmartPublications(SmartPublications pubs){
//        this.smartPublications=pubs;
//    }
//    public  SmartPublications getSmartPublications(){
//        return this.smartPublications;
//    }

    public SmartStates() {
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNextstate() {
        return nextstate;
    }

    public void setNextstate(int nextstate) {
        this.nextstate = nextstate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getDeadlinestate() {
        return deadlinestate;
    }

    public void setDeadlinestate(int deadlinestate) {
        this.deadlinestate = deadlinestate;
    }

    public int getDeadlinerelative() {
        return deadlinerelative;
    }

    public void setDeadlinerelative(int deadlinerelative) {
        this.deadlinerelative = deadlinerelative;
    }

    public String getCreatepermanentversion() {
        return createpermanentversion;
    }

    public void setCreatepermanentversion(String createpermanentversion) {
        this.createpermanentversion = createpermanentversion;
    }

    public String getRemoveintermediateversions() {
        return removeintermediateversions;
    }

    public void setRemoveintermediateversions(String removeintermediateversions) {
        this.removeintermediateversions = removeintermediateversions;
    }

    public String getAutomaticallysendtonext() {
        return automaticallysendtonext;
    }

    public void setAutomaticallysendtonext(String automaticallysendtonext) {
        this.automaticallysendtonext = automaticallysendtonext;
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
        if (!(object instanceof SmartStates)) {
            return false;
        }
        SmartStates other = (SmartStates) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
    public String getUrl() {
    return "states?id=" + this.getId();
}


    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}
