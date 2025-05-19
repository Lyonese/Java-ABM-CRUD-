package Persistencias;

import Clases.Asignatura;
import Clases.CargoDocente;
import Clases.Instituto;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class InstitutoJpaController {

    private EntityManager emf; 
    
    public InstitutoJpaController(EntityManagerFactory emf) {
        this.emf = emf.createEntityManager();
    }

    public InstitutoJpaController() {
        emf = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
    }

    public void create(Instituto instituto) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.persist(instituto);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void edit(Instituto instituto) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.merge(instituto);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void destroy(int institutoCodigo) {
    EntityTransaction transaction = emf.getTransaction();
    try {
        transaction.begin();

       List<CargoDocente> cargosDocentes = emf.createQuery(
            "SELECT c FROM CargoDocente c WHERE c.instituto.instituto_codigo = :institutoCodigo", CargoDocente.class)
            .setParameter("institutoCodigo", institutoCodigo)
            .getResultList();


        for (CargoDocente cargo : cargosDocentes) {
            emf.remove(cargo);
        }

        List<Asignatura> asignaturas = emf.createQuery(
            "SELECT a FROM Asignatura a WHERE a.instituto.instituto_codigo = :institutoCodigo", Asignatura.class)
            .setParameter("institutoCodigo", institutoCodigo)
            .getResultList();


        for (Asignatura asignatura : asignaturas) {
            emf.remove(asignatura);
        }

        Instituto instituto = emf.find(Instituto.class, institutoCodigo);
        if (instituto != null) {
            emf.remove(instituto);
        }

        transaction.commit();
    } catch (RuntimeException e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        throw e;
        }
    }

    public Instituto find(int institutoCodigo) {
        return emf.find(Instituto.class, institutoCodigo); 
    }

    public List<Instituto> findAll() {
        return emf.createQuery("SELECT i FROM Instituto i", Instituto.class).getResultList();
    }
}
