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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Shravan
 */
@Entity
@Table(name="addgym")
public class Addgym {
   
    @Id
    @GeneratedValue
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    String gymname;

    public String getGymname() {
        return gymname;
    }

    public void setGymname(String gymname) {
        this.gymname = gymname;
    }
    
    
    String ownername;

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
    
    
    String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    
    String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
    String postcode;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    
    String phoneno;

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    String packagee;

    public String getPackagee() {
        return packagee;
    }

    public void setPackagee(String packagee) {
        this.packagee = packagee;
    }

    public Addgym(int id, String gymname, String ownername, String street, String area, String postcode, String phoneno, String username, String password, String packagee) {
        this.id = id;
        this.gymname = gymname;
        this.ownername = ownername;
        this.street = street;
        this.area = area;
        this.postcode = postcode;
        this.phoneno = phoneno;
        this.username = username;
        this.password = password;
        this.packagee = packagee;
    }
    
    public Addgym()
    {
        
    }
  
    @OneToOne(mappedBy = "a", cascade = CascadeType.ALL)
    Logingym l;

    public Logingym getL() {
        return l;
    }

    public void setL(Logingym l) {
        this.l = l;
    }
    
    
}
