package Clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente implements Serializable {

    @Id
    private int docente_nro_legajo;

    private String docente_nombre;
    private String docente_apellido;
    private int docente_dni;
    private LocalDate docente_fecha_nacimiento;
    private String docente_contacto;

    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;

    public Docente() {
    }

    public Docente(int docente_nro_legajo, String docente_nombre, String docente_apellido, int docente_dni, LocalDate docente_fecha_nacimiento, String docente_contacto) {
        this.docente_nro_legajo = docente_nro_legajo;
        this.docente_nombre = docente_nombre;
        this.docente_apellido = docente_apellido;
        this.docente_dni = docente_dni;
        this.docente_fecha_nacimiento = docente_fecha_nacimiento;
        this.docente_contacto = docente_contacto;
    }

    public int getDocente_nro_legajo() {
        return docente_nro_legajo;
    }

    public void setDocente_nro_legajo(int docente_nro_legajo) {
        this.docente_nro_legajo = docente_nro_legajo;
    }

    public String getDocente_nombre() {
        return docente_nombre;
    }

    public void setDocente_nombre(String docente_nombre) {
        this.docente_nombre = docente_nombre;
    }

    public String getDocente_apellido() {
        return docente_apellido;
    }

    public void setDocente_apellido(String docente_apellido) {
        this.docente_apellido = docente_apellido;
    }

    public int getDocente_dni() {
        return docente_dni;
    }

    public void setDocente_dni(int docente_dni) {
        this.docente_dni = docente_dni;
    }

    public LocalDate getDocente_fecha_nacimiento() {
        return docente_fecha_nacimiento;
    }

    public void setDocente_fecha_nacimiento(LocalDate docente_fecha_nacimiento) {
        this.docente_fecha_nacimiento = docente_fecha_nacimiento;
    }

    public String getDocente_contacto() {
        return docente_contacto;
    }

    public void setDocente_contacto(String docente_contacto) {
        this.docente_contacto = docente_contacto;
    }
}