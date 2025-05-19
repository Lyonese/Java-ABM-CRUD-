package Integrador;

import Persistencias.ControladoraPersistencia;
import Clases.Asignatura;
import Clases.CargoDocente;
import Clases.Docente;
import Clases.Instituto;

public class Controladora {
    ControladoraPersistencia persistencia = new ControladoraPersistencia();
    
    public void crearInstituto(Instituto inst) {
        persistencia.crearInstitutoDB(inst);
    }

    public Instituto buscarInstituto(int codigoInstituto) {
        return persistencia.buscarInstitutoDB(codigoInstituto);
    }

    public void eliminarInstituto(Instituto instituto) {
        persistencia.eliminarInstitutoDB(instituto);  
    }
    
    public void modificarInstituto(Instituto instituto) {
        persistencia.modificarInstitutoDB(instituto);
    }

    public void crearAsignatura(Asignatura asig) {
        persistencia.crearAsignaturaDB(asig);
    }

    public Asignatura buscarAsignatura(int codigoAsignatura) {
        return persistencia.buscarAsignaturaDB(codigoAsignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        persistencia.eliminarAsignaturaDB(asignatura);
    }

    public void modificarAsignatura(Asignatura asignatura) {
        persistencia.modificarAsignaturaDB(asignatura);
    }

    public void crearDocente(Docente doc) {
        persistencia.crearDocenteDB(doc);
    }

    public Docente buscarDocente(int legajoDocente) {
        return persistencia.buscarDocenteDB(legajoDocente); 
    }

    public void eliminarDocente(Docente docente) {
        persistencia.eliminarDocenteDB(docente); 
    }

    public void modificarDocente(Docente docente) {
        persistencia.modificarDocenteDB(docente);
    }

    public void crearCargoDocente(CargoDocente cargoDoc) {
        persistencia.crearCargoDocenteDB(cargoDoc);
    }

    public CargoDocente buscarCargoDocente(int numeroCargoDocente) {
        return persistencia.buscarCargoDocenteDB(numeroCargoDocente);
    }

    public void eliminarCargoDocente(CargoDocente cargoDocente) {
        persistencia.eliminarCargoDocenteDB(cargoDocente);
    }

    public void modificarCargoDocente(CargoDocente cargoDocente) {
        persistencia.modificarCargoDocenteDB(cargoDocente);
    }
}
