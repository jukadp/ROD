package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="odczyt_licznika"
    ,schema="public"
)
@JsonIdentityInfo(scope = OdczytLicznika.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nr_odczytu") 
public class OdczytLicznika  implements java.io.Serializable {


     private Long nr_odczytu;
     private Dzialki nr_dzialki;
     private int nrPomiaru;
     private String data;
     private Integer stanLicznika;
     private Double naleznosc;

    public OdczytLicznika() {
    }

	
    public OdczytLicznika(Long nr_odczytu, Dzialki nr_dzialki, int nrPomiaru) {
        this.nr_odczytu = nr_odczytu;
        this.nr_dzialki = nr_dzialki;
        this.nrPomiaru = nrPomiaru;
    }
    public OdczytLicznika(Long nr_odczytu, Dzialki nr_dzialki, int nrPomiaru, String data, Integer stanLicznika, Double naleznosc) {
       this.nr_odczytu = nr_odczytu;
       this.nr_dzialki = nr_dzialki;
       this.nrPomiaru = nrPomiaru;
       this.data = data;
       this.stanLicznika = stanLicznika;
       this.naleznosc = naleznosc;
    }
   
     @Id 
    @Column(name="nr_odczytu", unique=true, nullable=false)
    public Long getIdOdczytLicznika() {
        return this.nr_odczytu;
    }
    
    public void setNrOdczytu(Long nr_odczytu) {
        this.nr_odczytu = nr_odczytu;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nr_dzialki", nullable=false)
    public Dzialki getDzialki() {
        return this.nr_dzialki;
    }
    
    public void setDzialki(Dzialki dzialki) {
        this.nr_dzialki = dzialki;
    }

    
    @Column(name="nr_pomiaru", nullable=false)
    public int getNrPomiaru() {
        return this.nrPomiaru;
    }
    
    public void setNrPomiaru(int nrPomiaru) {
        this.nrPomiaru = nrPomiaru;
    }

    
    @Column(name="data")
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    
    @Column(name="stan_po_odczycie")
    public Integer getStanLicznika() {
        return this.stanLicznika;
    }
    
    public void setStanLicznika(Integer stanLicznika) {
        this.stanLicznika = stanLicznika;
    }

    
    @Column(name="naleznosc", precision=17, scale=17)
    public Double getNaleznosc() {
        return this.naleznosc;
    }
    
    public void setNaleznosc(Double naleznosc) {
        this.naleznosc = naleznosc;
    }




}


