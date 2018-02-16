package com.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="iban"
    ,schema="public"
)
@JsonIdentityInfo(scope = Iban.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nrDzialki") 

public class Iban  implements java.io.Serializable {


     private Long nrDzialki;
    
     private Dzialki dzialki;
     private String kodIban;
     private String nrKonta;

    public Iban() {
    }

	
    public Iban(Dzialki dzialki) {
        this.dzialki = dzialki;
    }
    public Iban(Dzialki dzialki, String kodIban, String nrKonta) {
       this.dzialki = dzialki;
       this.kodIban = kodIban;
       this.nrKonta = nrKonta;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="dzialki"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="nr_dzialki", unique=true, nullable=false)
    public Long getNrDzialki() {
        return this.nrDzialki;
    }
    
    public void setNrDzialki(Long nrDzialki) {
        this.nrDzialki = nrDzialki;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Dzialki getDzialki() {
        return this.dzialki;
    }
    
    public void setDzialki(Dzialki dzialki) {
        this.dzialki = dzialki;
    }

    
    @Column(name="kod_iban", length=100)
    public String getKodIban() {
        return this.kodIban;
    }
    
    public void setKodIban(String kodIban) {
        this.kodIban = kodIban;
    }

    
    @Column(name="nr_konta", length=100)
    public String getNrKonta() {
        return this.nrKonta;
    }
    
    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }




}


