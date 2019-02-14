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
import javax.persistence.Table;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="members")

public class Members {
    
    @Id
    @GeneratedValue
    int id;
    
    String firstname;
    String middlename;
    String lastname;
    Long phoneno;
    String area;
    String street;
    String postalcode;
    String email;
    String password;
    String packagee;
    float height;
    float weight;
    String blood;
    String dob;
    String health;
    String date;
    
     @ManyToOne
    @JoinColumn(name="branchid")
     private Addbranch adbranch;

       @OneToMany(cascade=CascadeType.ALL,mappedBy ="memb",fetch = FetchType.LAZY)
	private Set<Batch_member> batches;

    public Set<Batch_member> getBatches() {
        return batches;
    }

    public void setBatches(Set<Batch_member> batches) {
        this.batches = batches;
    }
       
    public Members(int id, String firstname, String middlename, String lastname, Long phoneno, String packagee, String date) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.phoneno = phoneno;
       this.packagee=packagee;
       this.date=date;
    }

     
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPackagee() {
        return packagee;
    }

    public void setPackagee(String packagee) {
        this.packagee = packagee;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Addbranch getAdbranch() {
        return adbranch;
    }

    public void setAdbranch(Addbranch adbranch) {
        this.adbranch = adbranch;
    }

    

    public Members() {
    }

    public Members(int id, String firstname, String middlename, String lastname, Long phoneno, String area, String street, String postalcode, String email, String packagee, float height, float weight, String blood, String dob, String health) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.phoneno = phoneno;
        this.area = area;
        this.street = street;
        this.postalcode = postalcode;
        this.email = email;
        this.packagee = packagee;
        this.height = height;
        this.weight = weight;
        this.blood = blood;
        this.dob = dob;
        this.health = health;
    }
      @ManyToOne
    @JoinColumn(name="member_pack_id")
     private Gympackage gympack;

    public Gympackage getGympack() {
        return gympack;
    }

    public void setGympack(Gympackage gympack) {
        this.gympack = gympack;
    }
     
     @OneToOne(mappedBy = "a", cascade = CascadeType.ALL)
    Dietplan dp;

    public Dietplan getDp() {
        return dp;
    }

    public void setDp(Dietplan dp) {
        this.dp = dp;
    }
     
     
    
}
