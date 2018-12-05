/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.loginmodule;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="addpackage", uniqueConstraints = {
                @UniqueConstraint(columnNames ={ "name","amount"})})
public class Addpackage {
    @Id
    @GeneratedValue
    int id;

    public Addpackage() {
        
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    int amount;
  
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    int no_of_branches;

    public int getNo_of_branches() {
        return no_of_branches;
    }

    public void setNo_of_branches(int no_of_branches) {
        this.no_of_branches = no_of_branches;
    }

    public Addpackage(int id, String name, String time, int amount, int no_of_branches) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.no_of_branches = no_of_branches;
    }

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "adpack")
       // @JoinColumn(name="cart_id")
	private Set<Addgym> adgym;

    public Set<Addgym> getAdgym() {
        return adgym;
    }

    public void setAdgym(Set<Addgym> adgym) {
        this.adgym = adgym;
    }
    
}
