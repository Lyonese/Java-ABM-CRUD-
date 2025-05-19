package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instituto implements Serializable {

    @Id
    private int instituto_codigo;

    private String instituto_denominacion;

    public Instituto() {
    }

    public Instituto(int instituto_codigo, String instituto_denominacion) {
        this.instituto_codigo = instituto_codigo;
        this.instituto_denominacion = instituto_denominacion;
    }

    public int getInstituto_codigo() {
        return instituto_codigo;
    }

    public void setInstituto_codigo(int instituto_codigo) {
        this.instituto_codigo = instituto_codigo;
    }

    public String getInstituto_denominacion() {
        return instituto_denominacion;
    }

    public void setInstituto_denominacion(String instituto_denominacion) {
        this.instituto_denominacion = instituto_denominacion;
    }
}
