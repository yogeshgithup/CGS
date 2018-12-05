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
@Table(name="achievements")
public class Achievements {
    
    @Id
    @GeneratedValue        
    int id;
    
 String achievement;
    
    String achive_descr;
    
    @ManyToOne
        @JoinColumn(name="gymid")
	private Addgym adgym;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getAchive_descr() {
        return achive_descr;
    }

    public void setAchive_descr(String achive_descr) {
        this.achive_descr = achive_descr;
    }

    public Addgym getAdgym() {
        return adgym;
    }

    public void setAdgym(Addgym adgym) {
        this.adgym = adgym;
    }
    
    
}
