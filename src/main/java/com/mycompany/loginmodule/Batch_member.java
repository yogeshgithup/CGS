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
 * @author Shravan
 */
@Entity
@Table(name="batch_member")
public class Batch_member {
    
     @Id
    @GeneratedValue
    int id;
     
     String name;
     @ManyToOne
    @JoinColumn(name="batch_id")
     private Batches batch_mem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Batches getBatch_mem() {
        return batch_mem;
    }

    public void setBatch_mem(Batches batch_mem) {
        this.batch_mem = batch_mem;
    }
     
     
}
