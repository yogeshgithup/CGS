/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginmodule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table
public class Dietplan {
    @Id
    @GeneratedValue
            int id;
    String memstartdate;
    String memenddate;
    String description;
    String photo;

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMemstartdate() {
        return memstartdate;
    }

    public void setMemstartdate(String memstartdate) {
        this.memstartdate = memstartdate;
    }

    public String getMemenddate() {
        return memenddate;
    }

    public void setMemenddate(String memenddate) {
        this.memenddate = memenddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    @ManyToOne
    @JoinColumn(name="batch_faci_id")
     private Batches fact;

    public Batches getFact() {
        return fact;
    }

    public void setFact(Batches fact) {
        this.fact = fact;
    }

    
    @ManyToOne
    @JoinColumn(name="member_diet_id")
     private Members member_diet;

    public Members getMember_diet() {
        return member_diet;
    }

    public void setMember_diet(Members member_diet) {
        this.member_diet = member_diet;
    }

    
    
}
