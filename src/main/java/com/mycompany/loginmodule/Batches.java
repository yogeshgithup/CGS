/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.loginmodule;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="batches")
public class Batches {
     @Id
    @GeneratedValue
    int id;
     
     String batch_name;
     String time_from;
     String time_to;
     String role;
     
        @ManyToOne
    @JoinColumn(name="branchid")
   private Addbranch adbranch;
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getTime_from() {
        return time_from;
    }

    public void setTime_from(String time_from) {
        this.time_from = time_from;
    }

    public String getTime_to() {
        return time_to;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

      @OneToMany(cascade=CascadeType.ALL,mappedBy ="batch_mem",fetch = FetchType.LAZY)
	private Set<Batch_member> batche_member;
    public Set<Batch_member> getBatche_member() {
        return batche_member;
    }

    public void setBatche_member(Set<Batch_member> batche_member) {
        this.batche_member = batche_member;
    }

    public Addbranch getAdbranch() {
        return adbranch;
    }

    public void setAdbranch(Addbranch adbranch) {
        this.adbranch = adbranch;
    }

     @ManyToOne
    @JoinColumn(name="facility_id")
   private Facility facility_batches;

    public Facility getFacility_batches() {
        return facility_batches;
    }

    public void setFacility_batches(Facility facility_batches) {
        this.facility_batches = facility_batches;
    }
     @OneToMany(cascade=CascadeType.ALL,mappedBy ="fact",fetch = FetchType.LAZY)
	private Set<Dietplan> diet;

    public Set<Dietplan> getDiet() {
        return diet;
    }

    public void setDiet(Set<Dietplan> diet) {
        this.diet = diet;
    }
     

}
