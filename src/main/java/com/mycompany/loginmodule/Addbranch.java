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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="addbranch")
public class Addbranch {
    
    @Id
    @GeneratedValue
    int id;
    
    String branchname;
    
    String street;
    
    String area;
    
    String postalcode;
    
    @ManyToOne
        @JoinColumn(name="gymid")
	private Addgym adgym;

    public Addbranch() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public Addgym getAdgym() {
        return adgym;
    }

    public void setAdgym(Addgym adgym) {
        this.adgym = adgym;
    }

    public Addbranch(int id, String branchname, String street, String area, String postalcode) {
        this.id = id;
        this.branchname = branchname;
        this.street = street;
        this.area = area;
        this.postalcode = postalcode;
    }
    
    @OneToOne(mappedBy = "a", cascade = CascadeType.ALL)
   addbranchoperator abo;

    public addbranchoperator getAbo() {
        return abo;
    }

    public void setAbo(addbranchoperator abo) {
        this.abo = abo;
    }
    
    
}
