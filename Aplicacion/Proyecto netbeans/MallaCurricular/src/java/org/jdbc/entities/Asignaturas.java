
package org.jdbc.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a"),
    @NamedQuery(name = "Asignaturas.findByCodAsig", query = "SELECT a FROM Asignaturas a WHERE a.codAsig = :codAsig"),
    @NamedQuery(name = "Asignaturas.findByNomAsig", query = "SELECT a FROM Asignaturas a WHERE a.nomAsig = :nomAsig"),
    @NamedQuery(name = "Asignaturas.findByCreditos", query = "SELECT a FROM Asignaturas a WHERE a.creditos = :creditos"),
    @NamedQuery(name = "Asignaturas.findByIntensidadH", query = "SELECT a FROM Asignaturas a WHERE a.intensidadH = :intensidadH")})
public class Asignaturas implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsig")
    private Collection<Programacion> programacionCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cod_asig")
    private String codAsig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_asig")
    private String nomAsig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditos")
    private int creditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intensidad_h")
    private int intensidadH;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsig")
    private Collection<Malla> mallaCollection;

    public Asignaturas() {
    }

    public Asignaturas(String codAsig) {
        this.codAsig = codAsig;
    }

    public Asignaturas(String codAsig, String nomAsig, int creditos, int intensidadH) {
        this.codAsig = codAsig;
        this.nomAsig = nomAsig;
        this.creditos = creditos;
        this.intensidadH = intensidadH;
    }

    public String getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
    }

    public String getNomAsig() {
        return nomAsig;
    }

    public void setNomAsig(String nomAsig) {
        this.nomAsig = nomAsig;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getIntensidadH() {
        return intensidadH;
    }

    public void setIntensidadH(int intensidadH) {
        this.intensidadH = intensidadH;
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
        hash += (codAsig != null ? codAsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.codAsig == null && other.codAsig != null) || (this.codAsig != null && !this.codAsig.equals(other.codAsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomAsig;
    }

    @XmlTransient
    public Collection<Programacion> getProgramacionCollection() {
        return programacionCollection;
    }

    public void setProgramacionCollection(Collection<Programacion> programacionCollection) {
        this.programacionCollection = programacionCollection;
    }
    
}
