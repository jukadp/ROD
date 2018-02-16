package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name="informacja"
    ,schema="public"
)
@JsonIdentityInfo(scope = Informacja.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "idInformacja") 

public class Informacja  implements java.io.Serializable {

     private Long idInformacja;
     private Dzialki dzialki;
     private Integer nrInformacji;
     private Integer rokRozliczeniowy;
     private Double stanRozliczenia;
     private String informacja;

    public Informacja() {
    }

	
    public Informacja(Long idInformacja) {
        this.idInformacja = idInformacja;
    }
    public Informacja(Long idInformacja, Dzialki dzialki, Integer nrInformacji, Integer rokRozliczeniowy, Double stanRozliczenia, String informacja) {
       this.idInformacja = idInformacja;
       this.dzialki = dzialki;
       this.nrInformacji = nrInformacji;
       this.rokRozliczeniowy = rokRozliczeniowy;
       this.stanRozliczenia = stanRozliczenia;
       this.informacja = informacja;
    }
   
     @Id 


 @SequenceGenerator(name="Informacja_id_seq",
                       sequenceName="Informacja_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="Informacja_id_seq")
    
    @Column(name="id_informacja", unique=true, nullable=false)
    public Long getIdInformacja() {
        return this.idInformacja;
    }
    
    public void setIdInformacja(Long idInformacja) {
        this.idInformacja = idInformacja;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nr_dzialki")
    public Dzialki getDzialki() {
        return this.dzialki;
    }
    
    public void setDzialki(Dzialki dzialki) {
        this.dzialki = dzialki;
    }

    
    @Column(name="nr_informacji")
    public Integer getNrInformacji() {
        return this.nrInformacji;
    }
    
    public void setNrInformacji(Integer nrInformacji) {
        this.nrInformacji = nrInformacji;
    }

    
    @Column(name="rok_rozliczeniowy")
    public Integer getRokRozliczeniowy() {
        return this.rokRozliczeniowy;
    }
    
    public void setRokRozliczeniowy(Integer rokRozliczeniowy) {
        this.rokRozliczeniowy = rokRozliczeniowy;
    }

    
    @Column(name="stan_rozliczenia", precision=17, scale=17)
    public Double getStanRozliczenia() {
        return this.stanRozliczenia;
    }
    
    public void setStanRozliczenia(Double stanRozliczenia) {
        this.stanRozliczenia = stanRozliczenia;
    }

    
    @Column(name="informacja", length=252)
    public String getInformacja() {
        return this.informacja;
    }
    
    public void setInformacja(String informacja) {
        this.informacja = informacja;
    }




}


