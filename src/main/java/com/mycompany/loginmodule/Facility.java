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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="facility")
public class Facility {
    
    @Id
   @GeneratedValue
   int id;
    
    String name;

    public Facility() {
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
   
    @ManyToOne
    @JoinColumn(name="gymid")
     private Addgym adgym;

    public Addgym getAdgym() {
        return adgym;
    }

    public void setAdgym(Addgym adgym) {
        this.adgym = adgym;
    }

    public Facility(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "facc", fetch = FetchType.LAZY)
       // @JoinColumn(name="cart_id")
	private Set<Pack_facility> pack_fac;

    public Set<Pack_facility> getPack_fac() {
        return pack_fac;
    }

    public void setPack_fac(Set<Pack_facility> pack_fac) {
        this.pack_fac = pack_fac;
    }
     @OneToMany(cascade=CascadeType.ALL,mappedBy = "facility", fetch = FetchType.LAZY)
       // @JoinColumn(name="cart_id")
	private Set<Trainer> trainer_faci;

    public Set<Trainer> getTrainer_faci() {
        return trainer_faci;
    }

    public void setTrainer_faci(Set<Trainer> trainer_faci) {
        this.trainer_faci = trainer_faci;
    }
    
    
}
