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
@Table(name="gallery")
public class Gallery {
    
   @Id
   @GeneratedValue
   int id;
   
   
   String photo;
   
   String description;
   
    @ManyToOne
    @JoinColumn(name="gymid")
     private Addgym adgym;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Addgym getAdgym() {
        return adgym;
    }

    public void setAdgym(Addgym adgym) {
        this.adgym = adgym;
    }
   
    
    
}
