
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
@Table(name = "programas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programas.findAll", query = "SELECT p FROM Programas p"),
    @NamedQuery(name = "Programas.findByCodProg", query = "SELECT p FROM Programas p WHERE p.codProg = :codProg"),
    @NamedQuery(name = "Programas.findByNomProg", query = "SELECT p FROM Programas p WHERE p.nomProg = :nomProg")})
public class Programas implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProg")
    private Collection<Programacion> programacionCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cod_prog")
    private String codProg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_prog")
    private String nomProg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProg")
    private Collection<Resoluciones> resolucionesCollection;

    public Programas() {
    }

    public Programas(String codProg) {
        this.codProg = codProg;
    }

    public Programas(String codProg, String nomProg) {
        this.codProg = codProg;
        this.nomProg = nomProg;
    }

    public String getCodProg() {
        return codProg;
    }

    public void setCodProg(String codProg) {
        this.codProg = codProg;
    }

    public String getNomProg() {
        return nomProg;
    }

    public void setNomProg(String nomProg) {
        this.nomProg = nomProg;
    }

    @XmlTransient
    public Collection<Resoluciones> getResolucionesCollection() {
        return resolucionesCollection;
    }

    public void setResolucionesCollection(Collection<Resoluciones> resolucionesCollection) {
        this.resolucionesCollection = resolucionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProg != null ? codProg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programas)) {
            return false;
        }
        Programas other = (Programas) object;
        if ((this.codProg == null && other.codProg != null) || (this.codProg != null && !this.codProg.equals(other.codProg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codProg;
    }

    @XmlTransient
    public Collection<Programacion> getProgramacionCollection() {
        return programacionCollection;
    }

    public void setProgramacionCollection(Collection<Programacion> programacionCollection) {
        this.programacionCollection = programacionCollection;
    }
    
}
