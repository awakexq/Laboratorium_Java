/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author awakexq
 */
@Entity
@Table(name = "wypozyczenie")
@NamedQueries({
    @NamedQuery(name = "Wypozyczenie.findAll", query = "SELECT w FROM Wypozyczenie w"),
    @NamedQuery(name = "Wypozyczenie.findByIdWypozyczenia", query = "SELECT w FROM Wypozyczenie w WHERE w.idWypozyczenia = :idWypozyczenia"),
    @NamedQuery(name = "Wypozyczenie.findByDataOd", query = "SELECT w FROM Wypozyczenie w WHERE w.dataOd = :dataOd"),
    @NamedQuery(name = "Wypozyczenie.findByDataDo", query = "SELECT w FROM Wypozyczenie w WHERE w.dataDo = :dataDo"),
    @NamedQuery(name = "Wypozyczenie.findByCenaCalkowita", query = "SELECT w FROM Wypozyczenie w WHERE w.cenaCalkowita = :cenaCalkowita")})
public class Wypozyczenie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wypozyczenia")
    private Integer idWypozyczenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_od")
    @Temporal(TemporalType.DATE)
    private Date dataOd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_do")
    @Temporal(TemporalType.DATE)
    private Date dataDo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena_calkowita")
    private BigDecimal cenaCalkowita;
    @JoinColumn(name = "id_osoby", referencedColumnName = "id_osoby")
    @ManyToOne(optional = false)
    private Osoba idOsoby;
    @JoinColumn(name = "id_samochodu", referencedColumnName = "id_samochodu")
    @ManyToOne(optional = false)
    private Samochod idSamochodu;

    public Wypozyczenie() {
    }

    public Wypozyczenie(Integer idWypozyczenia) {
        this.idWypozyczenia = idWypozyczenia;
    }

    public Wypozyczenie(Integer idWypozyczenia, Date dataOd, Date dataDo) {
        this.idWypozyczenia = idWypozyczenia;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
    }

    public Integer getIdWypozyczenia() {
        return idWypozyczenia;
    }

    public void setIdWypozyczenia(Integer idWypozyczenia) {
        this.idWypozyczenia = idWypozyczenia;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public BigDecimal getCenaCalkowita() {
        return cenaCalkowita;
    }

    public void setCenaCalkowita(BigDecimal cenaCalkowita) {
        this.cenaCalkowita = cenaCalkowita;
    }

    public Osoba getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(Osoba idOsoby) {
        this.idOsoby = idOsoby;
    }

    public Samochod getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(Samochod idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWypozyczenia != null ? idWypozyczenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wypozyczenie)) {
            return false;
        }
        Wypozyczenie other = (Wypozyczenie) object;
        if ((this.idWypozyczenia == null && other.idWypozyczenia != null) || (this.idWypozyczenia != null && !this.idWypozyczenia.equals(other.idWypozyczenia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Wypozyczenie[ idWypozyczenia=" + idWypozyczenia + " ]";
    }
    
}
