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

/*
 * @Entity
@Table(name = "USERS")
@SecondaryTable(
name = "BILLING_ADDRESS",
pkJoinColumns = {
@PrimaryKeyJoinColumn(name="USER_ID")
}
)
public class User {
...
}
 * */

@Entity
@Table(name = "smart_groups")
@NamedQueries({@NamedQuery(name = "SmartGroups.findAll", query = "SELECT s FROM SmartGroups s ORDER BY s.name"),
@NamedQuery(name = "SmartGroups.getCount", query = "SELECT COUNT(s) FROM SmartGroups s"),
@NamedQuery(name = "SmartGroups.findById", query = "SELECT s FROM SmartGroups s WHERE s.id = :id"),
@NamedQuery(name = "SmartGroups.findByUserId", query = "SELECT s FROM SmartGroups s WHERE s.id IN (SELECT s.grpid FROM SmartUsrgrp s WHERE s.usrid = :id)"),
@NamedQuery(name = "SmartGroups.findByName", query = "SELECT s FROM SmartGroups s WHERE s.name LIKE :name"),
@NamedQuery(name = "SmartGroups.findByDescr", query = "SELECT s FROM SmartGroups s WHERE s.descr = :descr"),
@NamedQuery(name = "SmartGroups.findByAdmin", query = "SELECT s FROM SmartGroups s WHERE s.admin = :admin"),
@NamedQuery(name = "SmartGroups.findByGroupsFromUser", query = "SELECT s FROM SmartGroups s WHERE s.id " +
		"IN(SELECT g.grpid FROM SmartUsrgrp g WHERE g.usrid=:id) ORDER BY s.name"),
@NamedQuery(name = "SmartGroups.getCountGroups", query = "SELECT COUNT(s) FROM SmartGroups s WHERE s.name LIKE :name"),
@NamedQuery(name = "SmartGroups.findByRouting", query = "SELECT s FROM SmartGroups s WHERE s.routing = :routing")})
public class SmartGroups extends DomainObject{


	
	@Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "descr")
    private String descr;
    @Basic(optional = false)
    @Column(name = "admin")
    private String admin;
    @Basic(optional = false)
    @Column(name = "routing")
    private String routing;

    @OneToMany
    @JoinTable(name = "smart_usrgrp", joinColumns = @JoinColumn(name = "grpid"), inverseJoinColumns = @JoinColumn(name = "usrid"))
    private Collection<SmartUsers> smartUsers;

    public Collection<SmartUsers> getUsers(){
        return smartUsers;
    }

    public SmartGroups() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }



    public String getUrl() {
    return "group?id=" + this.getId();
}

    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + this.getId() + "]";
    }

}
