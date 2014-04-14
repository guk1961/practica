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
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Yuri_Zhlz
 */
@Entity
@Table(name = "smart_users")
//@NamedNativeQuery(name = "SmartUsers.pageUsers", query = "SELECT s FROM SmartUsers s limit :page,:count", resultClass = SmartUsers.class);
@NamedQueries({@NamedQuery(name = "SmartUsers.findAll", query = "SELECT s FROM SmartUsers s ORDER BY s.fullname"),
@NamedQuery(name = "SmartUsers.getCount", query = "SELECT COUNT(s) FROM SmartUsers s"),
//@NamedQuery(name = "SmartUsers.pageUsers", query = "SELECT s FROM SmartUsers s limit :page,:count"),
@NamedQuery(name = "SmartUsers.loginUser", query = "SELECT s FROM SmartUsers s WHERE s.user = :name"),
@NamedQuery(name = "SmartUsers.findById", query = "SELECT s FROM SmartUsers s WHERE s.id = :id"),
@NamedQuery(name = "SmartUsers.findByUser", query = "SELECT s FROM SmartUsers s WHERE s.user = :user"),
@NamedQuery(name = "SmartUsers.findByFullname", query = "SELECT s FROM SmartUsers s WHERE s.fullname = :fullname"),
@NamedQuery(name = "SmartUsers.findByPass", query = "SELECT s FROM SmartUsers s WHERE s.pass = :pass"),
@NamedQuery(name = "SmartUsers.findByDisable", query = "SELECT s FROM SmartUsers s WHERE s.disable = :disable"),
@NamedQuery(name = "SmartUsers.findByFixedpass", query = "SELECT s FROM SmartUsers s WHERE s.fixedpass = :fixedpass"),
@NamedQuery(name = "SmartUsers.findByEmail", query = "SELECT s FROM SmartUsers s WHERE s.email = :email"),
@NamedQuery(name = "SmartUsers.findByEmailgrp", query = "SELECT s FROM SmartUsers s WHERE s.emailgrp = :emailgrp"),
@NamedQuery(name = "SmartUsers.findByEmailusr", query = "SELECT s FROM SmartUsers s WHERE s.emailusr = :emailusr"),
@NamedQuery(name = "SmartUsers.findByLanguage", query = "SELECT s FROM SmartUsers s WHERE s.language = :language"),
@NamedQuery(name = "SmartUsers.findByStartdate", query = "SELECT s FROM SmartUsers s WHERE s.startdate = :startdate"),
@NamedQuery(name = "SmartUsers.findByEnddate", query = "SELECT s FROM SmartUsers s WHERE s.enddate = :enddate"),
@NamedQuery(name = "SmartUsers.findByExpirepassdate", query = "SELECT s FROM SmartUsers s WHERE s.expirepassdate = :expirepassdate"),
@NamedQuery(name = "SmartUsers.findByExpiredays", query = "SELECT s FROM SmartUsers s WHERE s.expiredays = :expiredays"),
@NamedQuery(name = "SmartUsers.findByTrackchangescolor", query = "SELECT s FROM SmartUsers s WHERE s.trackchangescolor = :trackchangescolor"),
@NamedQuery(name = "SmartUsers.findByLastlogondate", query = "SELECT s FROM SmartUsers s WHERE s.lastlogondate = :lastlogondate"),
@NamedQuery(name = "SmartUsers.findByOrganization", query = "SELECT s FROM SmartUsers s WHERE s.organization = :organization"),
@NamedQuery(name = "SmartUsers.getCountUsers", query = "SELECT COUNT(s) FROM SmartUsers s WHERE s.fullname LIKE :name"),
@NamedQuery(name = "SmartUsers.findByName", query = "SELECT s FROM SmartUsers s WHERE s.fullname LIKE :name ORDER by s.fullname"),
@NamedQuery(name = "SmartUsers.findByUsersFromGroup", query = "SELECT s FROM SmartUsers s WHERE s.id " +
		"IN(SELECT g.usrid FROM SmartUsrgrp g WHERE g.grpid=:id) ORDER BY s.fullname"),//IN elements(SmartUsrgrp.usrid)"),
@NamedQuery(name = "SmartUsers.findByLocation", query = "SELECT s FROM SmartUsers s WHERE s.location = :location")})



public class SmartUsers extends DomainObject {
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @Column(name = "disable")
    private String disable;
    @Basic(optional = false)
    @Column(name = "fixedpass")
    private String fixedpass;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "emailgrp")
    private String emailgrp;
    @Basic(optional = false)
    @Column(name = "emailusr")
    private String emailusr;
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @Column(name = "startdate")
    private String startdate;
    @Basic(optional = false)
    @Column(name = "enddate")
    private String enddate;
    @Basic(optional = false)
    @Column(name = "expirepassdate")
    private String expirepassdate;
    @Basic(optional = false)
    @Column(name = "expiredays")
    private int expiredays;
    @Basic(optional = false)
    @Column(name = "trackchangescolor")
    private String trackchangescolor;
    @Basic(optional = false)
    @Column(name = "lastlogondate")
    private String lastlogondate;
    @Basic(optional = false)
    @Column(name = "organization")
    private String organization;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;


    @OneToMany
    @JoinTable(name = "smart_usrgrp", joinColumns = @JoinColumn(name = "usrid"), inverseJoinColumns = @JoinColumn(name = "grpid"))
    private Collection<SmartGroups> smartGroups;

    public Collection<SmartGroups> getGroups(){
        return smartGroups;
    }

        public SmartUsers() {
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public String getFixedpass() {
        return fixedpass;
    }

    public void setFixedpass(String fixedpass) {
        this.fixedpass = fixedpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailgrp() {
        return emailgrp;
    }

    public void setEmailgrp(String emailgrp) {
        this.emailgrp = emailgrp;
    }

    public String getEmailusr() {
        return emailusr;
    }

    public void setEmailusr(String emailusr) {
        this.emailusr = emailusr;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getExpirepassdate() {
        return expirepassdate;
    }

    public void setExpirepassdate(String expirepassdate) {
        this.expirepassdate = expirepassdate;
    }

    public int getExpiredays() {
        return expiredays;
    }

    public void setExpiredays(int expiredays) {
        this.expiredays = expiredays;
    }

    public String getTrackchangescolor() {
        return trackchangescolor;
    }

    public void setTrackchangescolor(String trackchangescolor) {
        this.trackchangescolor = trackchangescolor;
    }

    public String getLastlogondate() {
        return lastlogondate;
    }

    public void setLastlogondate(String lastlogondate) {
        this.lastlogondate = lastlogondate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getUrl() {
    	return "user?id=" + this.getId();
    }
//Boolean active;
//
//    public Boolean getActive() {
//        return active;
//    }

//    public void setActive(Boolean active) {
//        this.active = active;
//    }

    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}
