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
@Table(name="logingym")
public class Logingym {
    
 
    @Id
    @GeneratedValue(generator = "x")
    @GenericGenerator(name = "x",strategy = "foreign",parameters = @Parameter(name = "property",value = "a"))
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @OneToOne
    @PrimaryKeyJoinColumn
    Addgym a;

    public Addgym getA() {
        return a;
    }

    public void setA(Addgym a) {
        this.a = a;
    }
    
}
