package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class CargoDocente implements Serializable {

    @Id
    private int cargo_docente_nro;

    @ManyToOne
    @JoinColumn(name = "docente_nro_legajo", referencedColumnName = "docente_nro_legajo")
    private Docente docente; 

    @ManyToOne
    @JoinColumn(name = "instituto_codigo", referencedColumnName = "instituto_codigo")
    private Instituto instituto;

    private int cargo_docente_dedicacion_horas;

    public CargoDocente() {
    }

    public CargoDocente(int cargo_docente_nro, Docente docente_nro_legajo, Instituto instituto_codigo, int cargo_docente_dedicacion_horas) {
        this.cargo_docente_nro = cargo_docente_nro;
        this.docente = docente_nro_legajo;
        this.instituto = instituto_codigo;
        this.cargo_docente_dedicacion_horas = cargo_docente_dedicacion_horas;
    }

    public int getCargo_docente_nro() {
        return cargo_docente_nro;
    }

    public void setCargo_docente_nro(int cargo_docente_nro) {
        this.cargo_docente_nro = cargo_docente_nro;
    }

    public Docente getDocente_nro_legajo() {
        return docente;
    }

    public void setDocente_nro_legajo(Docente docente_nro_legajo) {
        this.docente = docente_nro_legajo;
    }

    public Instituto getInstituto_codigo() {
        return instituto;
    }

    public void setInstituto_codigo(Instituto instituto_codigo) {
        this.instituto = instituto_codigo;
    }

    public int getCargo_docente_dedicacion_horas() {
        return cargo_docente_dedicacion_horas;
    }

    public void setCargo_docente_dedicacion_horas(int cargo_docente_dedicacion_horas) {
        this.cargo_docente_dedicacion_horas = cargo_docente_dedicacion_horas;
    }
}
