package com.model;
// Generated 2018-02-14 00:36:07 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="dostep"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames={"login", "role"}) 
)
@JsonIdentityInfo(scope = Dostep.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nrDzialkowicza") 

public class Dostep  implements java.io.Serializable {


     private Long nrDzialkowicza;
        
     private Dzialkowicz dzialkowicz;
     private String login;
     private String password;
     private boolean enabled = true;
     private String role = "ROLE_USER";

    public Dostep() {
    }

    public Dostep(Dzialkowicz dzialkowicz, String login, String password, boolean enabled, String role) {
       this.dzialkowicz = dzialkowicz;
       this.login = login;
       this.password = password;
       this.enabled = enabled;
       this.role = role;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="dzialkowicz"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="nr_dzialkowicza", unique=true, nullable=false)
    public Long getNrDzialkowicza() {
        return this.nrDzialkowicza;
    }
    
    public void setNrDzialkowicza(Long nrDzialkowicza) {
        this.nrDzialkowicza = nrDzialkowicza;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Dzialkowicz getDzialkowicz() {
        return this.dzialkowicz;
    }
    
    public void setDzialkowicz(Dzialkowicz dzialkowicz) {
        this.dzialkowicz = dzialkowicz;
    }

    
    @Column(name="login", nullable=false, length=40)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", nullable=false, length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="enabled", nullable=false)
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    
    @Column(name="role", nullable=false, length=15)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}

