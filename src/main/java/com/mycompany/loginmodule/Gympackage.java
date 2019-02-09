/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.loginmodule;

import java.util.HashSet;
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
@Table(name="gympackage")
public class Gympackage {
    
     @Id
   @GeneratedValue
   int id;
     
     String name;
     
     int amount;
     
     String time;
     
     @ManyToOne
    @JoinColumn(name="gymid")
     private Addgym adgym;

  

    public Gympackage(int id, String name, int amount, String time) {
          this.id = id;
        this.name = name;
        this.amount = amount;
        this.time = time;
        
    }

    public Gympackage() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Addgym getAdgym() {
        return adgym;
    }

    public void setAdgym(Addgym adgym) {
        this.adgym = adgym;
    }
     
      @OneToMany(cascade=CascadeType.ALL,mappedBy = "gympack",fetch = FetchType.LAZY)
	private Set<Pack_facility> packfac;

    public Set<Pack_facility> getPackfac() {
        return packfac;
    }

    public void setPackfac(Set<Pack_facility> packfac) {
        this.packfac = packfac;
    }
      @OneToMany(cascade=CascadeType.ALL,mappedBy = "gympack", fetch = FetchType.LAZY)
       // @JoinColumn(name="cart_id")
	private Set<Members> members_pack;

    public Set<Members> getMembers_pack() {
        return members_pack;
    }

    public void setMembers_pack(Set<Members> members_pack) {
        this.members_pack = members_pack;
    }
      
}
