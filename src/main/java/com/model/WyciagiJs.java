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
@Table(name="wyciagi_js"
    ,schema="public"
)
@JsonIdentityInfo(scope = WyciagiJs.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "idWyciagu") 

public class WyciagiJs  implements java.io.Serializable {


     private Long idWyciagu;
     
     private Dzialki dzialki;
     private int nrWyciagu;
     private Double kwota;
     private String data;
     private String opis;
     private Double skladka;
     private Double cynsz;
     private Double awrbp;
     private Double wpisowe;
     private Double energiaRozpoczecieSezonu;
     private Double energiaZakonczenieSezonu;
     private Double dyzurZRokuPoprzedniegoNaBiezacy;
     private Double dyzurZRokuBiezacegoNaNastepny;
     private Double zadluzenieZRokuPoprzedniego;
     private Double licznik;

    public WyciagiJs() {
    }

	
    public WyciagiJs(Long idWyciagu, Dzialki dzialki, int nrWyciagu) {
        this.idWyciagu = idWyciagu;
        this.dzialki = dzialki;
        this.nrWyciagu = nrWyciagu;
    }
    public WyciagiJs(Long idWyciagu, Dzialki dzialki, int nrWyciagu, Double kwota, String data, String opis, Double skladka, Double cynsz, Double awrbp, Double wpisowe, Double energiaRozpoczecieSezonu, Double energiaZakonczenieSezonu, Double dyzurZRokuPoprzedniegoNaBiezacy, Double dyzurZRokuBiezacegoNaNastepny, Double zadluzenieZRokuPoprzedniego, Double licznik) {
       this.idWyciagu = idWyciagu;
       this.dzialki = dzialki;
       this.nrWyciagu = nrWyciagu;
       this.kwota = kwota;
       this.data = data;
       this.opis = opis;
       this.skladka = skladka;
       this.cynsz = cynsz;
       this.awrbp = awrbp;
       this.wpisowe = wpisowe;
       this.energiaRozpoczecieSezonu = energiaRozpoczecieSezonu;
       this.energiaZakonczenieSezonu = energiaZakonczenieSezonu;
       this.dyzurZRokuPoprzedniegoNaBiezacy = dyzurZRokuPoprzedniegoNaBiezacy;
       this.dyzurZRokuBiezacegoNaNastepny = dyzurZRokuBiezacegoNaNastepny;
       this.zadluzenieZRokuPoprzedniego = zadluzenieZRokuPoprzedniego;
       this.licznik = licznik;
    }
   
     @Id 

    
@SequenceGenerator(name="Wyciagi_JS_id_seq",
                       sequenceName="Wyciagi_JS_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="Wyciagi_JS_id_seq")
    @Column(name="id_wyciagu", unique=true, nullable=false)
    public Long getIdWyciagu() {
        return this.idWyciagu;
    }
    
    public void setIdWyciagu(Long idWyciagu) {
        this.idWyciagu = idWyciagu;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nr_dzialki", nullable=false)
    public Dzialki getDzialki() {
        return this.dzialki;
    }
    
    public void setDzialki(Dzialki dzialki) {
        this.dzialki = dzialki;
    }

    
    @Column(name="nr_wyciagu", nullable=false)
    public int getNrWyciagu() {
        return this.nrWyciagu;
    }
    
    public void setNrWyciagu(int nrWyciagu) {
        this.nrWyciagu = nrWyciagu;
    }

    
    @Column(name="kwota", precision=17, scale=17)
    public Double getKwota() {
        return this.kwota;
    }
    
    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    
    @Column(name="data")
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    
    @Column(name="opis")
    public String getOpis() {
        return this.opis;
    }
    
    public void setOpis(String opis) {
        this.opis = opis;
    }

    
    @Column(name="skladka", precision=17, scale=17)
    public Double getSkladka() {
        return this.skladka;
    }
    
    public void setSkladka(Double skladka) {
        this.skladka = skladka;
    }

    
    @Column(name="cynsz", precision=17, scale=17)
    public Double getCynsz() {
        return this.cynsz;
    }
    
    public void setCynsz(Double cynsz) {
        this.cynsz = cynsz;
    }

    
    @Column(name="awrbp", precision=17, scale=17)
    public Double getAwrbp() {
        return this.awrbp;
    }
    
    public void setAwrbp(Double awrbp) {
        this.awrbp = awrbp;
    }

    
    @Column(name="wpisowe", precision=17, scale=17)
    public Double getWpisowe() {
        return this.wpisowe;
    }
    
    public void setWpisowe(Double wpisowe) {
        this.wpisowe = wpisowe;
    }

    
    @Column(name="energia_rozpoczecie_sezonu", precision=17, scale=17)
    public Double getEnergiaRozpoczecieSezonu() {
        return this.energiaRozpoczecieSezonu;
    }
    
    public void setEnergiaRozpoczecieSezonu(Double energiaRozpoczecieSezonu) {
        this.energiaRozpoczecieSezonu = energiaRozpoczecieSezonu;
    }

    
    @Column(name="energia_zakonczenie_sezonu", precision=17, scale=17)
    public Double getEnergiaZakonczenieSezonu() {
        return this.energiaZakonczenieSezonu;
    }
    
    public void setEnergiaZakonczenieSezonu(Double energiaZakonczenieSezonu) {
        this.energiaZakonczenieSezonu = energiaZakonczenieSezonu;
    }

    
    @Column(name="dyzur_z_roku_poprzedniego_na_biezacy", precision=17, scale=17)
    public Double getDyzurZRokuPoprzedniegoNaBiezacy() {
        return this.dyzurZRokuPoprzedniegoNaBiezacy;
    }
    
    public void setDyzurZRokuPoprzedniegoNaBiezacy(Double dyzurZRokuPoprzedniegoNaBiezacy) {
        this.dyzurZRokuPoprzedniegoNaBiezacy = dyzurZRokuPoprzedniegoNaBiezacy;
    }

    
    @Column(name="dyzur_z_roku_biezacego_na_nastepny", precision=17, scale=17)
    public Double getDyzurZRokuBiezacegoNaNastepny() {
        return this.dyzurZRokuBiezacegoNaNastepny;
    }
    
    public void setDyzurZRokuBiezacegoNaNastepny(Double dyzurZRokuBiezacegoNaNastepny) {
        this.dyzurZRokuBiezacegoNaNastepny = dyzurZRokuBiezacegoNaNastepny;
    }

    
    @Column(name="zadluzenie_z_roku_poprzedniego", precision=17, scale=17)
    public Double getZadluzenieZRokuPoprzedniego() {
        return this.zadluzenieZRokuPoprzedniego;
    }
    
    public void setZadluzenieZRokuPoprzedniego(Double zadluzenieZRokuPoprzedniego) {
        this.zadluzenieZRokuPoprzedniego = zadluzenieZRokuPoprzedniego;
    }

    
    @Column(name="licznik", precision=17, scale=17)
    public Double getLicznik() {
        return this.licznik;
    }
    
    public void setLicznik(Double licznik) {
        this.licznik = licznik;
    }




}



