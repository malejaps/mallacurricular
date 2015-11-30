
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
@Table(name = "semestres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestres.findAll", query = "SELECT s FROM Semestres s"),
    @NamedQuery(name = "Semestres.findBySemestre", query = "SELECT s FROM Semestres s WHERE s.semestre = :semestre")})
public class Semestres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "semestre")
    private String semestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestre")
    private Collection<Malla> mallaCollection;

    public Semestres() {
    }

    public Semestres(String semestre) {
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
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
        hash += (semestre != null ? semestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestres)) {
            return false;
        }
        Semestres other = (Semestres) object;
        if ((this.semestre == null && other.semestre != null) || (this.semestre != null && !this.semestre.equals(other.semestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return semestre ;
    }
    
}
