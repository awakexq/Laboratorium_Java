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
import jakarta.persistence.Lob;
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
@Table(name = "rola")
@NamedQueries({
    @NamedQuery(name = "Rola.findAll", query = "SELECT r FROM Rola r"),
    @NamedQuery(name = "Rola.findByIdRoli", query = "SELECT r FROM Rola r WHERE r.idRoli = :idRoli"),
    @NamedQuery(name = "Rola.findByNazwa", query = "SELECT r FROM Rola r WHERE r.nazwa = :nazwa")})
public class Rola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roli")
    private Integer idRoli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa")
    private String nazwa;
    @Lob
    @Size(max = 65535)
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRoli")
    private Collection<Osoba> osobaCollection;

    public Rola() {
    }

    public Rola(Integer idRoli) {
        this.idRoli = idRoli;
    }

    public Rola(Integer idRoli, String nazwa) {
        this.idRoli = idRoli;
        this.nazwa = nazwa;
    }

    public Integer getIdRoli() {
        return idRoli;
    }

    public void setIdRoli(Integer idRoli) {
        this.idRoli = idRoli;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Collection<Osoba> getOsobaCollection() {
        return osobaCollection;
    }

    public void setOsobaCollection(Collection<Osoba> osobaCollection) {
        this.osobaCollection = osobaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoli != null ? idRoli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rola)) {
            return false;
        }
        Rola other = (Rola) object;
        if ((this.idRoli == null && other.idRoli != null) || (this.idRoli != null && !this.idRoli.equals(other.idRoli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Rola[ idRoli=" + idRoli + " ]";
    }
    
}
