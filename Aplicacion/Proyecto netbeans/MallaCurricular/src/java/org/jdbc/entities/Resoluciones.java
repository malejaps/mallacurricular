/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdbc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maleja
 */
@Entity
@Table(name = "resoluciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resoluciones.findAll", query = "SELECT r FROM Resoluciones r"),
    @NamedQuery(name = "Resoluciones.findByCodResol", query = "SELECT r FROM Resoluciones r WHERE r.codResol = :codResol"),
    @NamedQuery(name = "Resoluciones.findByNomResol", query = "SELECT r FROM Resoluciones r WHERE r.nomResol = :nomResol"),
    @NamedQuery(name = "Resoluciones.findByFechaResol", query = "SELECT r FROM Resoluciones r WHERE r.fechaResol = :fechaResol")})
public class Resoluciones implements Serializable {
    @Basic(optional =     false)
    @NotNull
    @Column(name = "fecha_resol")
    @Temporal(TemporalType.DATE)
    private Date fechaResol;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cod_resol")
    private String codResol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_resol")
    private String nomResol;
    @JoinColumn(name = "cod_prog", referencedColumnName = "cod_prog")
    @ManyToOne(optional = false)
    private Programas codProg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResol")
    private Collection<Malla> mallaCollection;

    public Resoluciones() {
    }

    public Resoluciones(String codResol) {
        this.codResol = codResol;
    }

    public Resoluciones(String codResol, String nomResol, Date fechaResol) {
        this.codResol = codResol;
        this.nomResol = nomResol;
        this.fechaResol = fechaResol;
    }

    public String getCodResol() {
        return codResol;
    }

    public void setCodResol(String codResol) {
        this.codResol = codResol;
    }

    public String getNomResol() {
        return nomResol;
    }

    public void setNomResol(String nomResol) {
        this.nomResol = nomResol;
    }

    public Date getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(Date fechaResol) {
        this.fechaResol = fechaResol;
    }

    public Programas getCodProg() {
        return codProg;
    }

    public void setCodProg(Programas codProg) {
        this.codProg = codProg;
    }

    @XmlTransient
    public Collection<Malla> getMallaCollection() {
        return mallaCollection;
    }

    public void setMallaCollection(Collection<Malla> mallaCollection) {
        this.mallaCollection = mallaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codResol != null ? codResol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resoluciones)) {
            return false;
        }
        Resoluciones other = (Resoluciones) object;
        if ((this.codResol == null && other.codResol != null) || (this.codResol != null && !this.codResol.equals(other.codResol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codResol ;
    }


    
}
