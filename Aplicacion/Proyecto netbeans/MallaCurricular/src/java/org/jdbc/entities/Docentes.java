/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Maleja
 */
@Entity
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByCodDoc", query = "SELECT d FROM Docentes d WHERE d.codDoc = :codDoc"),
    @NamedQuery(name = "Docentes.findByCedula", query = "SELECT d FROM Docentes d WHERE d.cedula = :cedula"),
    @NamedQuery(name = "Docentes.findByDocente", query = "SELECT d FROM Docentes d WHERE d.docente = :docente"),
    @NamedQuery(name = "Docentes.findByDia", query = "SELECT d FROM Docentes d WHERE d.dia = :dia"),
    @NamedQuery(name = "Docentes.findByHoraInicio", query = "SELECT d FROM Docentes d WHERE d.horaInicio = :horaInicio"),
    @NamedQuery(name = "Docentes.findByHoraFin", query = "SELECT d FROM Docentes d WHERE d.horaFin = :horaFin"),
    @NamedQuery(name = "Docentes.findByDisponibilidad", query = "SELECT d FROM Docentes d WHERE d.disponibilidad = :disponibilidad")})
public class Docentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_doc")
    private String codDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "docente")
    private String docente;
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
    @Size(min = 1, max = 5)
    @Column(name = "disponibilidad")
    private String disponibilidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDoc")
    private Collection<Programacion> programacionCollection;

    public Docentes() {
    }

    public Docentes(String codDoc) {
        this.codDoc = codDoc;
    }

    public Docentes(String codDoc, String cedula, String docente, String dia, String horaInicio, String horaFin, String disponibilidad) {
        this.codDoc = codDoc;
        this.cedula = cedula;
        this.docente = docente;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidad = disponibilidad;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
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

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @XmlTransient
    public Collection<Programacion> getProgramacionCollection() {
        return programacionCollection;
    }

    public void setProgramacionCollection(Collection<Programacion> programacionCollection) {
        this.programacionCollection = programacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDoc != null ? codDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.codDoc == null && other.codDoc != null) || (this.codDoc != null && !this.codDoc.equals(other.codDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return docente;
    }
    
}
