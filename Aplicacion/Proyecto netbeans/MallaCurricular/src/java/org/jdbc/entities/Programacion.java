/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Maleja
 */
@Entity
@Table(name = "programacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacion.findAll", query = "SELECT p FROM Programacion p"),
    @NamedQuery(name = "Programacion.findByCodProgramacion", query = "SELECT p FROM Programacion p WHERE p.codProgramacion = :codProgramacion"),
    @NamedQuery(name = "Programacion.findByDia", query = "SELECT p FROM Programacion p WHERE p.dia = :dia"),
    @NamedQuery(name = "Programacion.findByHoraInicio", query = "SELECT p FROM Programacion p WHERE p.horaInicio = :horaInicio"),
    @NamedQuery(name = "Programacion.findByHoraFin", query = "SELECT p FROM Programacion p WHERE p.horaFin = :horaFin"),
    @NamedQuery(name = "Programacion.findByPeriodo", query = "SELECT p FROM Programacion p WHERE p.periodo = :periodo")})
public class Programacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_programacion")
    private String codProgramacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hora_fin")
    private String horaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "cod_prog", referencedColumnName = "cod_prog")
    @ManyToOne(optional = false)
    private Programas codProg;
    @JoinColumn(name = "cod_doc", referencedColumnName = "cod_doc")
    @ManyToOne(optional = false)
    private Docentes codDoc;
    @JoinColumn(name = "cod_asig", referencedColumnName = "cod_asig")
    @ManyToOne(optional = false)
    private Asignaturas codAsig;

    public Programacion() {
    }

    public Programacion(String codProgramacion) {
        this.codProgramacion = codProgramacion;
    }

    public Programacion(String codProgramacion, String dia, String horaInicio, String horaFin, String periodo) {
        this.codProgramacion = codProgramacion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.periodo = periodo;
    }

    public String getCodProgramacion() {
        return codProgramacion;
    }

    public void setCodProgramacion(String codProgramacion) {
        this.codProgramacion = codProgramacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Programas getCodProg() {
        return codProg;
    }

    public void setCodProg(Programas codProg) {
        this.codProg = codProg;
    }

    public Docentes getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(Docentes codDoc) {
        this.codDoc = codDoc;
    }

    public Asignaturas getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(Asignaturas codAsig) {
        this.codAsig = codAsig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProgramacion != null ? codProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacion)) {
            return false;
        }
        Programacion other = (Programacion) object;
        if ((this.codProgramacion == null && other.codProgramacion != null) || (this.codProgramacion != null && !this.codProgramacion.equals(other.codProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdbc.entities.Programacion[ codProgramacion=" + codProgramacion + " ]";
    }
    
}
