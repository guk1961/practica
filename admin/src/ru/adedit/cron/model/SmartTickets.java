/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.adedit.cron.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "smart_tickets")
@NamedQueries({@NamedQuery(name = "SmartTickets.findAll", query = "SELECT s FROM SmartTickets s ORDER BY s.usr"),
@NamedQuery(name = "SmartTickets.findById", query = "SELECT s FROM SmartTickets s WHERE s.id = :id"),
@NamedQuery(name = "SmartTickets.findByTicketid", query = "SELECT s FROM SmartTickets s WHERE s.ticketid = :ticketid"),
@NamedQuery(name = "SmartTickets.findByUsr", query = "SELECT s FROM SmartTickets s WHERE s.usr = :usr"),
@NamedQuery(name = "SmartTickets.findByDb", query = "SELECT s FROM SmartTickets s WHERE s.db = :db"),
@NamedQuery(name = "SmartTickets.findByClientname", query = "SELECT s FROM SmartTickets s WHERE s.clientname = :clientname"),
@NamedQuery(name = "SmartTickets.findByClientip", query = "SELECT s FROM SmartTickets s WHERE s.clientip = :clientip"),
@NamedQuery(name = "SmartTickets.findByAppname", query = "SELECT s FROM SmartTickets s WHERE s.appname = :appname"),
@NamedQuery(name = "SmartTickets.findByAppversion", query = "SELECT s FROM SmartTickets s WHERE s.appversion = :appversion"),
@NamedQuery(name = "SmartTickets.findByAppserial", query = "SELECT s FROM SmartTickets s WHERE s.appserial = :appserial"),
@NamedQuery(name = "SmartTickets.findByLogon", query = "SELECT s FROM SmartTickets s WHERE s.logon = :logon"),
@NamedQuery(name = "SmartTickets.findByExpire", query = "SELECT s FROM SmartTickets s WHERE s.expire = :expire"),
@NamedQuery(name = "SmartTickets.getUserForLogin", query = "SELECT s FROM SmartUsers s WHERE s.user = :usr"),
@NamedQuery(name = "SmartTickets.getCount", query = "SELECT COUNT(s) FROM SmartTickets s"),
@NamedQuery(name = "SmartTickets.findByAppproductcode", query = "SELECT s FROM SmartTickets s WHERE s.appproductcode = :appproductcode")})

public class SmartTickets extends DomainObject{
    
	private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "ticketid")
    private String ticketid;
    @Basic(optional = false)
    @Column(name = "usr")
    private String usr;
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    SmartUsers user;
    @Basic(optional = false)
    @Column(name = "db")
    private String db;
    @Basic(optional = false)
    @Column(name = "clientname")
    private String clientname;
    @Basic(optional = false)
    @Column(name = "clientip")
    private String clientip;
    @Basic(optional = false)
    @Column(name = "appname")
    private String appname;
    @Basic(optional = false)
    @Column(name = "appversion")
    private String appversion;
    @Basic(optional = false)
    @Column(name = "appserial")
    private String appserial;
    @Column(name = "logon")
    private String logon;
    @Basic(optional = false)
    @Column(name = "expire")
    private String expire;
    @Basic(optional = false)
    @Column(name = "appproductcode")
    private String appproductcode;

//    @ManyToOne
////    @JoinColumn(name="user")
//    @JoinColumns({
//        @JoinColumn(name="user", referencedColumnName="usr")})
//    private SmartUsers smartUsers;
//
//    public SmartUsers getSmartUsers(){
//            return this.user;
//    }
//    public void setSmartUsers(SmartUsers users){
//        this.user=users;
//    }

    public SmartTickets() {
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getAppserial() {
        return appserial;
    }

    public void setAppserial(String appserial) {
        this.appserial = appserial;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getAppproductcode() {
        return appproductcode;
    }

    public void setAppproductcode(String appproductcode) {
        this.appproductcode = appproductcode;
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
        if (!(object instanceof SmartTickets)) {
            return false;
        }
        SmartTickets other = (SmartTickets) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
    public String getUrl() {
    return "ticket?id=" + this.getId();
}

    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}
