package Persistencias;

import Clases.Asignatura;
import Clases.CargoDocente;
import Clases.Docente;
import Clases.Instituto;

public class ControladoraPersistencia {
    AsignaturaJpaController AsigJpa = new AsignaturaJpaController();
    CargoDocenteJpaController CargDocJpa = new CargoDocenteJpaController();
    DocenteJpaController DocJpa = new DocenteJpaController(); 
    InstitutoJpaController InstJpa = new InstitutoJpaController();

    public void crearInstitutoDB(Instituto inst) {
        InstJpa.create(inst);
    }

    public Instituto buscarInstitutoDB(int codigoInstituto) {
        return InstJpa.find(codigoInstituto); 
    }

    public void eliminarInstitutoDB(Instituto instituto) {
        try {
            InstJpa.destroy(instituto.getInstituto_codigo());
        } catch (Exception e) {
            System.out.println("Error al eliminar el instituto: " + e.getMessage());
        }
    }
    
    public void modificarInstitutoDB(Instituto instituto) {
        try {
            InstJpa.edit(instituto);
        } catch (Exception e) {
            System.out.println("Error al modificar el instituto: " + e.getMessage());
        }
    }

    public void crearAsignaturaDB(Asignatura asig) {
        AsigJpa.create(asig);
    }

    public Asignatura buscarAsignaturaDB(int codigoAsignatura) {
        return AsigJpa.find(codigoAsignatura); 
    }

    public void eliminarAsignaturaDB(Asignatura asignatura) {
        try {
            AsigJpa.destroy(asignatura.getAsignatura_codigo());
        } catch (Exception e) {
            System.out.println("Error al eliminar la asignatura: " + e.getMessage());
        }
    }

    public void modificarAsignaturaDB(Asignatura asignatura) {
        try {
            AsigJpa.edit(asignatura);
        } catch (Exception e) {
            System.out.println("Error al modificar la asignatura: " + e.getMessage());
        }
    }

    public void crearDocenteDB(Docente doc) {
        DocJpa.create(doc);
    }

    public Docente buscarDocenteDB(int legajoDocente) {
        return DocJpa.find(legajoDocente);
    }

    public void eliminarDocenteDB(Docente docente) {
        try {
            DocJpa.destroy(docente.getDocente_nro_legajo());
        } catch (Exception e) {
            System.out.println("Error al eliminar el docente: " + e.getMessage());
        }
    }

    public void modificarDocenteDB(Docente docente) {
        try {
            DocJpa.edit(docente);
        } catch (Exception e) {
            System.out.println("Error al modificar el docente: " + e.getMessage());
        }
    }

    public void crearCargoDocenteDB(CargoDocente cargoDoc) {
        CargDocJpa.create(cargoDoc);
    }

    public CargoDocente buscarCargoDocenteDB(int numeroCargoDocente) {
        return CargDocJpa.find(numeroCargoDocente);
    }

    public void eliminarCargoDocenteDB(CargoDocente cargoDocente) {
        try {
            CargDocJpa.destroy(cargoDocente.getCargo_docente_nro());
        } catch (Exception e) {
            System.out.println("Error al eliminar el cargo docente: " + e.getMessage());
        }
    }

    public void modificarCargoDocenteDB(CargoDocente cargoDocente) {
        try {
            CargDocJpa.edit(cargoDocente);
        } catch (Exception e) {
            System.out.println("Error al modificar el cargo docente: " + e.getMessage());
        }
    }
}
