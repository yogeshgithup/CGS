/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.loginmodule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Shravan
 */
@Entity
@Table(name="gyminfo")
public class Gyminfo {

   @Id
    @GeneratedValue(generator = "x")
    @GenericGenerator(name = "x",strategy = "foreign",parameters = @Parameter(name = "property",value = "a"))
    int id;
    
    String logo_url;
    
    String quality_msg;
    
    String about_us_title;
    
    String about_us_desc;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    Addgym a;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
    
    public String getQuality_msg() {
        return quality_msg;
    }

    public void setQuality_msg(String quality_msg) {
        this.quality_msg = quality_msg;
    }

    public String getAbout_us_title() {
        return about_us_title;
    }

    public void setAbout_us_title(String about_us_title) {
        this.about_us_title = about_us_title;
    }

    public String getAbout_us_desc() {
        return about_us_desc;
    }

    public void setAbout_us_desc(String about_us_desc) {
        this.about_us_desc = about_us_desc;
    }

    public Addgym getA() {
        return a;
    }

    public void setA(Addgym a) {
        this.a = a;
    }
    
}
