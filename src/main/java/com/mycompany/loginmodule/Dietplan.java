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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Administrator
 */
@Entity
@Table
public class Dietplan {
    
    @Id
    @GeneratedValue(generator = "x")
    @GenericGenerator(name = "x",strategy = "foreign",parameters = @Parameter(name = "property",value = "a"))
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
     private Batches batchhh;

    public Batches getBatchhh() {
        return batchhh;
    }

    public void setBatchhh(Batches batchhh) {
        this.batchhh = batchhh;
    }

   
   
    @OneToOne
    @PrimaryKeyJoinColumn
    Members a;

    public Members getA() {
        return a;
    }

    public void setA(Members a) {
        this.a = a;
    }
    
    
    
}
