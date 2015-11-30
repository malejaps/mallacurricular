

package org.jdbc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "malla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Malla.findAll", query = "SELECT m FROM Malla m"),
    @NamedQuery(name = "Malla.findByCodMalla", query = "SELECT m FROM Malla m WHERE m.codMalla = :codMalla")})
public class Malla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cod_malla")
    private String codMalla;
    @JoinColumn(name = "semestre", referencedColumnName = "semestre")
    @ManyToOne(optional = false)
    private Semestres semestre;
    @JoinColumn(name = "cod_asig", referencedColumnName = "cod_asig")
    @ManyToOne(optional = false)
    private Asignaturas codAsig;
    @JoinColumn(name = "cod_resol", referencedColumnName = "cod_resol")
    @ManyToOne(optional = false)
    private Resoluciones codResol;

    public Malla() {
    }

    public Malla(String codMalla) {
        this.codMalla = codMalla;
    }

    public String getCodMalla() {
        return codMalla;
    }

    public void setCodMalla(String codMalla) {
        this.codMalla = codMalla;
    }

    public Semestres getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestres semestre) {
        this.semestre = semestre;
    }

    public Asignaturas getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(Asignaturas codAsig) {
        this.codAsig = codAsig;
    }

    public Resoluciones getCodResol() {
        return codResol;
    }

    public void setCodResol(Resoluciones codResol) {
        this.codResol = codResol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMalla != null ? codMalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Malla)) {
            return false;
        }
        Malla other = (Malla) object;
        if ((this.codMalla == null && other.codMalla != null) || (this.codMalla != null && !this.codMalla.equals(other.codMalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codMalla ;
    }
    
}
