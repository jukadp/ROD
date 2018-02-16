package com.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dzialki"
    ,schema="public"
)
@JsonIdentityInfo(scope = Dzialki.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nrDzialki") 
public class Dzialki  implements java.io.Serializable {

     private Long nrDzialki;
   
     private Dzialkowicz dzialkowicz;
   

     private Integer powierzchnia;
@JsonProperty(access = Access.WRITE_ONLY)
     private Set<OdczytLicznika> odczytLicznikas = new HashSet<OdczytLicznika>(0);
  
     private Set<Informacja> informacjas = new HashSet<Informacja>(0);
       
     private Iban iban;
  @JsonProperty(access = Access.WRITE_ONLY)
     private Set<WyciagiJs> wyciagiJses = new HashSet<WyciagiJs>(0);
 
     private Set<AktualizacjaDanych> aktualizacjaDanyches = new HashSet<AktualizacjaDanych>(0);
      
     private Set<Zobowiazania> zobowiazanias = new HashSet<Zobowiazania>(0);

    public Dzialki() {
    }

	
    public Dzialki(Long nrDzialki) {
        this.nrDzialki = nrDzialki;
    }
    public Dzialki(Long nrDzialki, Dzialkowicz dzialkowicz, Integer powierzchnia, Set<OdczytLicznika> odczytLicznikas, Set<Informacja> informacjas, Iban iban, Set<WyciagiJs> wyciagiJses, Set<AktualizacjaDanych> aktualizacjaDanyches, Set<Zobowiazania> zobowiazanias) {
       this.nrDzialki = nrDzialki;
       this.dzialkowicz = dzialkowicz;
       this.powierzchnia = powierzchnia;
       this.odczytLicznikas = odczytLicznikas;
       this.informacjas = informacjas;
       this.iban = iban;
       this.wyciagiJses = wyciagiJses;
       this.aktualizacjaDanyches = aktualizacjaDanyches;
       this.zobowiazanias = zobowiazanias;
    }
   
     @Id 

    
    @Column(name="nr_dzialki", unique=true, nullable=false)
    public Long getNrDzialki() {
        return this.nrDzialki;
    }
    
    public void setNrDzialki(Long nrDzialki) {
        this.nrDzialki = nrDzialki;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nr_czlonkowski")
    public Dzialkowicz getDzialkowicz() {
        return this.dzialkowicz;
    }
    
    public void setDzialkowicz(Dzialkowicz dzialkowicz) {
        this.dzialkowicz = dzialkowicz;
    }

    
    @Column(name="powierzchnia")
    public Integer getPowierzchnia() {
        return this.powierzchnia;
    }
    
    public void setPowierzchnia(Integer powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Set<OdczytLicznika> getOdczytLicznikas() {
        return this.odczytLicznikas;
    }
    
    public void setOdczytLicznikas(Set<OdczytLicznika> odczytLicznikas) {
        this.odczytLicznikas = odczytLicznikas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Set<Informacja> getInformacjas() {
        return this.informacjas;
    }
    
    public void setInformacjas(Set<Informacja> informacjas) {
        this.informacjas = informacjas;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Iban getIban() {
        return this.iban;
    }
    
    public void setIban(Iban iban) {
        this.iban = iban;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Set<WyciagiJs> getWyciagiJses() {
        return this.wyciagiJses;
    }
    
    public void setWyciagiJses(Set<WyciagiJs> wyciagiJses) {
        this.wyciagiJses = wyciagiJses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Set<AktualizacjaDanych> getAktualizacjaDanyches() {
        return this.aktualizacjaDanyches;
    }
    
    public void setAktualizacjaDanyches(Set<AktualizacjaDanych> aktualizacjaDanyches) {
        this.aktualizacjaDanyches = aktualizacjaDanyches;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialki")
    public Set<Zobowiazania> getZobowiazanias() {
        return this.zobowiazanias;
    }
    
    public void setZobowiazanias(Set<Zobowiazania> zobowiazanias) {
        this.zobowiazanias = zobowiazanias;
    }




}


