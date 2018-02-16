package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity
@Table(name="zobowiazania"
    ,schema="public"
)
@JsonIdentityInfo(scope = Zobowiazania.class,generator = ObjectIdGenerators.PropertyGenerator.class , property = "nrZobowiazania") 

public class Zobowiazania  implements java.io.Serializable {


     private Long nrZobowiazania;
     
     private Dzialki dzialki;
     private int rokRozliczeniowy;
     private Double bilansOtwarcia;
     private Double skladka;
     private Double czynsz;
     private Double anr;
     private Double wpisowe;
     private Double energiaRozpocecieSezonu;
     private Double energiaZakonczeniaSeoznu;
     private Double dyzurZRokuPoprzedniegoNaBiezacy;
     private Double dyzurZRokuBiezacegoNaNastepny;
     private Double zadluzenieZRokuPoprzedniego;
     private Double zobowiazaniaRazemZBo;

    public Zobowiazania() {
    }

	
    public Zobowiazania(Long nrZobowiazania, Dzialki dzialki, int rokRozliczeniowy) {
        this.nrZobowiazania = nrZobowiazania;
        this.dzialki = dzialki;
        this.rokRozliczeniowy = rokRozliczeniowy;
    }
    public Zobowiazania(Long nrZobowiazania, Dzialki dzialki, int rokRozliczeniowy, Double bilansOtwarcia, Double skladka, Double czynsz, Double anr, Double wpisowe, Double energiaRozpocecieSezonu, Double energiaZakonczeniaSeoznu, Double dyzurZRokuPoprzedniegoNaBiezacy, Double dyzurZRokuBiezacegoNaNastepny, Double zadluzenieZRokuPoprzedniego, Double zobowiazaniaRazemZBo) {
       this.nrZobowiazania = nrZobowiazania;
       this.dzialki = dzialki;
       this.rokRozliczeniowy = rokRozliczeniowy;
       this.bilansOtwarcia = bilansOtwarcia;
       this.skladka = skladka;
       this.czynsz = czynsz;
       this.anr = anr;
       this.wpisowe = wpisowe;
       this.energiaRozpocecieSezonu = energiaRozpocecieSezonu;
       this.energiaZakonczeniaSeoznu = energiaZakonczeniaSeoznu;
       this.dyzurZRokuPoprzedniegoNaBiezacy = dyzurZRokuPoprzedniegoNaBiezacy;
       this.dyzurZRokuBiezacegoNaNastepny = dyzurZRokuBiezacegoNaNastepny;
       this.zadluzenieZRokuPoprzedniego = zadluzenieZRokuPoprzedniego;
       this.zobowiazaniaRazemZBo = zobowiazaniaRazemZBo;
    }
   
     @Id 

      @SequenceGenerator(name="Zobowiazania_id_seq",
                       sequenceName="Zobowiazania_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="Zobowiazania_id_seq")


    @Column(name="nr_zobowiazania", unique=true, nullable=false)
    public Long getNrZobowiazania() {
        return this.nrZobowiazania;
    }
    
    public void setNrZobowiazania(Long nrZobowiazania) {
        this.nrZobowiazania = nrZobowiazania;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nr_dzialki", nullable=false)
    public Dzialki getDzialki() {
        return this.dzialki;
    }
    
    public void setDzialki(Dzialki dzialki) {
        this.dzialki = dzialki;
    }

    
    @Column(name="rok_rozliczeniowy", nullable=false)
    public int getRokRozliczeniowy() {
        return this.rokRozliczeniowy;
    }
    
    public void setRokRozliczeniowy(int rokRozliczeniowy) {
        this.rokRozliczeniowy = rokRozliczeniowy;
    }

    
    @Column(name="bilans_otwarcia", precision=17, scale=17)
    public Double getBilansOtwarcia() {
        return this.bilansOtwarcia;
    }
    
    public void setBilansOtwarcia(Double bilansOtwarcia) {
        this.bilansOtwarcia = bilansOtwarcia;
    }

    
    @Column(name="skladka", precision=17, scale=17)
    public Double getSkladka() {
        return this.skladka;
    }
    
    public void setSkladka(Double skladka) {
        this.skladka = skladka;
    }

    
    @Column(name="czynsz", precision=17, scale=17)
    public Double getCzynsz() {
        return this.czynsz;
    }
    
    public void setCzynsz(Double czynsz) {
        this.czynsz = czynsz;
    }

    
    @Column(name="anr", precision=17, scale=17)
    public Double getAnr() {
        return this.anr;
    }
    
    public void setAnr(Double anr) {
        this.anr = anr;
    }

    
    @Column(name="wpisowe", precision=17, scale=17)
    public Double getWpisowe() {
        return this.wpisowe;
    }
    
    public void setWpisowe(Double wpisowe) {
        this.wpisowe = wpisowe;
    }

    
    @Column(name="energia_rozpocecie_sezonu", precision=17, scale=17)
    public Double getEnergiaRozpocecieSezonu() {
        return this.energiaRozpocecieSezonu;
    }
    
    public void setEnergiaRozpocecieSezonu(Double energiaRozpocecieSezonu) {
        this.energiaRozpocecieSezonu = energiaRozpocecieSezonu;
    }

    
    @Column(name="energia_zakonczenia_seoznu", precision=17, scale=17)
    public Double getEnergiaZakonczeniaSeoznu() {
        return this.energiaZakonczeniaSeoznu;
    }
    
    public void setEnergiaZakonczeniaSeoznu(Double energiaZakonczeniaSeoznu) {
        this.energiaZakonczeniaSeoznu = energiaZakonczeniaSeoznu;
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

    
    @Column(name="zobowiazania_razem_z_bo", precision=17, scale=17)
    public Double getZobowiazaniaRazemZBo() {
        return this.zobowiazaniaRazemZBo;
    }
    
    public void setZobowiazaniaRazemZBo(Double zobowiazaniaRazemZBo) {
        this.zobowiazaniaRazemZBo = zobowiazaniaRazemZBo;
    }




}


