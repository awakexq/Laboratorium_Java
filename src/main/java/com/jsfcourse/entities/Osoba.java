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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author awakexq
 */
@Entity
@Table(name = "osoba")
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o"),
    @NamedQuery(name = "Osoba.findByIdOsoby", query = "SELECT o FROM Osoba o WHERE o.idOsoby = :idOsoby"),
    @NamedQuery(name = "Osoba.findByImie", query = "SELECT o FROM Osoba o WHERE o.imie = :imie"),
    @NamedQuery(name = "Osoba.findByNazwisko", query = "SELECT o FROM Osoba o WHERE o.nazwisko = :nazwisko"),
    @NamedQuery(name = "Osoba.findByEmail", query = "SELECT o FROM Osoba o WHERE o.email = :email"),
    @NamedQuery(name = "Osoba.findByTelefon", query = "SELECT o FROM Osoba o WHERE o.telefon = :telefon"),
    @NamedQuery(name = "Osoba.findByHaslo", query = "SELECT o FROM Osoba o WHERE o.haslo = :haslo")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_osoby")
    private Integer idOsoby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko")
    private String nazwisko;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "haslo")
    private String haslo;
    @JoinColumn(name = "id_roli", referencedColumnName = "id_roli")
    @ManyToOne(optional = false)
    private Rola idRoli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOsoby")
    private Collection<Wypozyczenie> wypozyczenieCollection;

    public Osoba() {
    }

    public Osoba(Integer idOsoby) {
        this.idOsoby = idOsoby;
    }

    public Osoba(Integer idOsoby, String imie, String nazwisko, String email, String haslo) {
        this.idOsoby = idOsoby;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
    }

    public Integer getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(Integer idOsoby) {
        this.idOsoby = idOsoby;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Rola getIdRoli() {
        return idRoli;
    }

    public void setIdRoli(Rola idRoli) {
        this.idRoli = idRoli;
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
        hash += (idOsoby != null ? idOsoby.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.idOsoby == null && other.idOsoby != null) || (this.idOsoby != null && !this.idOsoby.equals(other.idOsoby))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Osoba[ idOsoby=" + idOsoby + " ]";
    }
    
}
