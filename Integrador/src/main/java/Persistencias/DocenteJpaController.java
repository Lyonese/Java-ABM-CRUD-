package Persistencias;

import Clases.CargoDocente;
import Clases.Docente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DocenteJpaController {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DocenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
        this.em = emf.createEntityManager();
    }

    public DocenteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("JPAPU");
        this.em = emf.createEntityManager();
    }

    public void create(Docente docente) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(docente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void edit(Docente docente) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(docente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void destroy(int docenteLegajo) {
    EntityTransaction transaction = em.getTransaction();
    try {
        transaction.begin();

        List<CargoDocente> cargosDocentes = em.createQuery(
            "SELECT c FROM CargoDocente c WHERE c.docente_nro_legajo.docente_nro_legajo = :docenteLegajo", CargoDocente.class)
            .setParameter("docenteLegajo", docenteLegajo)
            .getResultList();


        for (CargoDocente cargo : cargosDocentes) {
            em.remove(cargo);
        }

        Docente docente = em.find(Docente.class, docenteLegajo);
        if (docente != null) {
            em.remove(docente);
        }

        transaction.commit();
    } catch (RuntimeException e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        throw e;
        }
    }
    
    public Docente find(int docenteLegajo) {
        return em.find(Docente.class, docenteLegajo); 
    }

    public List<Docente> findAll() {
        return em.createQuery("SELECT d FROM Docente d", Docente.class).getResultList();
    }
}