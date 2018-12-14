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
@Table(name="pack_facility")
public class Pack_facility {
    
      @Id
   @GeneratedValue
   int id;
    
    String name;
    
    @ManyToOne
    @JoinColumn(name="packageid")
     private Gympackage gympack;

    public Pack_facility(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pack_facility() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
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

    public Gympackage getGympack() {
        return gympack;
    }

    public void setGympack(Gympackage gympack) {
        this.gympack = gympack;
    }
    
    
}
