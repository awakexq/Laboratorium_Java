/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author awakexq
 */
@Entity
@Table(name = "samochod")
@NamedQueries({
    @NamedQuery(name = "Samochod.findAll", query = "SELECT s FROM Samochod s"),
    @NamedQuery(name = "Samochod.findByIdSamochodu", query = "SELECT s FROM Samochod s WHERE s.idSamochodu = :idSamochodu"),
    @NamedQuery(name = "Samochod.findByZdjecie", query = "SELECT s FROM Samochod s WHERE s.zdjecie = :zdjecie"),
    @NamedQuery(name = "Samochod.findByMarka", query = "SELECT s FROM Samochod s WHERE s.marka = :marka"),
    @NamedQuery(name = "Samochod.findByModel", query = "SELECT s FROM Samochod s WHERE s.model = :model"),
    @NamedQuery(name = "Samochod.findByIloscKoni", query = "SELECT s FROM Samochod s WHERE s.iloscKoni = :iloscKoni"),
    @NamedQuery(name = "Samochod.findByRocznik", query = "SELECT s FROM Samochod s WHERE s.rocznik = :rocznik"),
    @NamedQuery(name = "Samochod.findByKolor", query = "SELECT s FROM Samochod s WHERE s.kolor = :kolor"),
    @NamedQuery(name = "Samochod.findByCenaZaDzien", query = "SELECT s FROM Samochod s WHERE s.cenaZaDzien = :cenaZaDzien"),
    @NamedQuery(name = "Samochod.findByDostepny", query = "SELECT s FROM Samochod s WHERE s.dostepny = :dostepny"),
    @NamedQuery(name = "Samochod.findByTypSilnika", query = "SELECT s FROM Samochod s WHERE s.typSilnika = :typSilnika")})
public class Samochod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_samochodu")
    private Integer idSamochodu;
    @Size(max = 255)
    @Column(name = "zdjecie")
    private String zdjecie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marka")
    private String marka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "model")
    private String model;
    @Column(name = "ilosc_koni")
    private Integer iloscKoni;
    @Column(name = "rocznik")
    private Integer rocznik;
    @Size(max = 30)
    @Column(name = "kolor")
    private String kolor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena_za_dzien")
    private BigDecimal cenaZaDzien;
    @Column(name = "dostepny")
    private Boolean dostepny;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "typ_silnika")
    private String typSilnika;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSamochodu")
    private Collection<Wypozyczenie> wypozyczenieCollection;

    public Samochod() {
    }

    public Samochod(Integer idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public Samochod(Integer idSamochodu, String marka, String model, BigDecimal cenaZaDzien, String typSilnika) {
        this.idSamochodu = idSamochodu;
        this.marka = marka;
        this.model = model;
        this.cenaZaDzien = cenaZaDzien;
        this.typSilnika = typSilnika;
    }

    public Integer getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(Integer idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getIloscKoni() {
        return iloscKoni;
    }

    public void setIloscKoni(Integer iloscKoni) {
        this.iloscKoni = iloscKoni;
    }

    public Integer getRocznik() {
        return rocznik;
    }

    public void setRocznik(Integer rocznik) {
        this.rocznik = rocznik;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public BigDecimal getCenaZaDzien() {
        return cenaZaDzien;
    }

    public void setCenaZaDzien(BigDecimal cenaZaDzien) {
        this.cenaZaDzien = cenaZaDzien;
    }

    public Boolean getDostepny() {
        return dostepny;
    }

    public void setDostepny(Boolean dostepny) {
        this.dostepny = dostepny;
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }

    public Collection<Wypozyczenie> getWypozyczenieCollection() {
        return wypozyczenieCollection;
    }

    public void setWypozyczenieCollection(Collection<Wypozyczenie> wypozyczenieCollection) {
        this.wypozyczenieCollection = wypozyczenieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSamochodu != null ? idSamochodu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samochod)) {
            return false;
        }
        Samochod other = (Samochod) object;
        if ((this.idSamochodu == null && other.idSamochodu != null) || (this.idSamochodu != null && !this.idSamochodu.equals(other.idSamochodu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Samochod[ idSamochodu=" + idSamochodu + " ]";
    }
    
}
