package com.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.boot.jackson.JsonObjectDeserializer;

@Entity
@Table(name="dzialkowicz"
    ,schema="public"
)
@JsonIdentityInfo(scope = Wlasciciel.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nrDzialkowicza") 
public class Wlasciciel  implements java.io.Serializable {


     private Long nrDzialkowicza;
     private String imie;
     private String nazwisko;
     private String ulica;
     private String nrDomu;
     private String nrLokalu;
     private String kodPocztowy;
     private String miasto;
     private String adresDoKorespondencji;
     private Integer telefon;
     private String email;
  
  

    private  Set<Dzialki> dzialkis = new HashSet<Dzialki>(0);
 
     private KontoUzytkownika dostep;

    public Wlasciciel() {
    }

	
    public Wlasciciel(Long nrDzialkowicza) {
        this.nrDzialkowicza = nrDzialkowicza;
    }
    
 
    
      public Wlasciciel(Long nrDzialkowicza, String imie, String nazwisko, String ulica, String nrDomu, String nrLokalu, String kodPocztowy, String miasto, String adresDoKorespondencji, Integer telefon, String email, Set<Dzialki> dzialkis, KontoUzytkownika dostep) {
       this.nrDzialkowicza = nrDzialkowicza;
       this.imie = imie;
       this.nazwisko = nazwisko;
       this.ulica = ulica;
       this.nrDomu = nrDomu;
       this.nrLokalu = nrLokalu;
       this.kodPocztowy = kodPocztowy;
       this.miasto = miasto;
       this.adresDoKorespondencji = adresDoKorespondencji;
       this.telefon = telefon;
       this.email = email; 
       this.dzialkis = dzialkis;
       this.dostep = dostep;
    }
    
    
     @Id 
    @Column(name="nr_dzialkowicza", unique=true, nullable=false)
    public Long getNrDzialkowicza() {
        return this.nrDzialkowicza;
    }
    
    public void setNrDzialkowicza(Long nrDzialkowicza) {
        this.nrDzialkowicza = nrDzialkowicza;
    }

    
    @Column(name="imie")
    public String getImie() {
        return this.imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }

    
    @Column(name="nazwisko")
    public String getNazwisko() {
        return this.nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    
    @Column(name="ulica")
    public String getUlica() {
        return this.ulica;
    }
    
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    
    @Column(name="nr_domu")
    public String getNrDomu() {
        return this.nrDomu;
    }
    
    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    
    @Column(name="nr_lokalu")
    public String getNrLokalu() {
        return this.nrLokalu;
    }
    
    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    
    @Column(name="kod_pocztowy")
    public String getKodPocztowy() {
        return this.kodPocztowy;
    }
    
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    
    @Column(name="miasto")
    public String getMiasto() {
        return this.miasto;
    }
    
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    
    @Column(name="adres_do_korespondencji")
    public String getAdresDoKorespondencji() {
        return this.adresDoKorespondencji;
    }
    
    public void setAdresDoKorespondencji(String adresDoKorespondencji) {
        this.adresDoKorespondencji = adresDoKorespondencji;
    }

    
    @Column(name="telefon")
    public Integer getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    
    @Column(name="email", length=40)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dzialkowicz")
    public Set<Dzialki> getDzialkis() {
        return this.dzialkis;
    }
    
   public void setDzialkis(Set<Dzialki> dzialkis) {
       this.dzialkis = dzialkis;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="dzialkowicz")
   public KontoUzytkownika getDostep() {
        return this.dostep;
   }
    
    public void setDostep(KontoUzytkownika dostep) {
        this.dostep = dostep;
    }




}




