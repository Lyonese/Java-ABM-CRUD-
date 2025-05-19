package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Asignatura implements Serializable {

    @Id
    private int asignatura_codigo;

    private String asignatura_nombre;
    private String asignatura_descripcion;

    @ManyToOne
    @JoinColumn(name = "instituto_codigo", referencedColumnName = "instituto_codigo")
    private Instituto instituto;

    @ManyToOne
    @JoinColumn(name = "docente_codigo", referencedColumnName = "docente_nro_legajo")
    private Docente docente;

    public Asignatura() {
    }

    public Asignatura(int asignatura_codigo, String asignatura_nombre, String asignatura_descripcion, Instituto instituto, Docente docenteResponsable) {
        this.asignatura_codigo = asignatura_codigo;
        this.asignatura_nombre = asignatura_nombre;
        this.asignatura_descripcion = asignatura_descripcion;
        this.instituto = instituto;
        this.docente = docenteResponsable;
    }

    public int getAsignatura_codigo() {
        return asignatura_codigo;
    }

    public void setAsignatura_codigo(int asignatura_codigo) {
        this.asignatura_codigo = asignatura_codigo;
    }

    public String getAsignatura_nombre() {
        return asignatura_nombre;
    }

    public void setAsignatura_nombre(String asignatura_nombre) {
        this.asignatura_nombre = asignatura_nombre;
    }

    public String getAsignatura_descripcion() {
        return asignatura_descripcion;
    }

    public void setAsignatura_descripcion(String asignatura_descripcion) {
        this.asignatura_descripcion = asignatura_descripcion;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public Docente getDocenteResponsable() {
        return docente;
    }

    public void setDocenteResponsable(Docente docenteResponsable) {
        this.docente = docenteResponsable;
    }
}