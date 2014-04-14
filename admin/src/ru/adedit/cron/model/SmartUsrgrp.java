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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Yuri_Zhlz
 */
@Entity
@Table(name = "smart_usrgrp")
@NamedQueries({@NamedQuery(name = "SmartUsrgrp.findAll", query = "SELECT s FROM SmartUsrgrp s"),
@NamedQuery(name = "SmartUsrgrp.findById", query = "SELECT s FROM SmartUsrgrp s WHERE s.id = :id"),
@NamedQuery(name = "SmartUsrgrp.findByUsrid", query = "SELECT s FROM SmartUsrgrp s WHERE s.usrid = :usrid"),
@NamedQuery(name = "SmartUsrgrp.findByGrpid", query = "SELECT s FROM SmartUsrgrp s WHERE s.grpid = :grpid")})
public class SmartUsrgrp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usrid")
    private int usrid;
    @Basic(optional = false)
    @Column(name = "grpid")
    private int grpid;

    public SmartUsrgrp() {
    }

    public SmartUsrgrp(Integer id) {
        this.id = id;
    }

    public SmartUsrgrp(Integer id, int usrid, int grpid) {
        this.id = id;
        this.usrid = usrid;
        this.grpid = grpid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public int getGrpid() {
        return grpid;
    }

    public void setGrpid(int grpid) {
        this.grpid = grpid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmartUsrgrp)) {
            return false;
        }
        SmartUsrgrp other = (SmartUsrgrp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"[id=" + id + "]";
    }

}
