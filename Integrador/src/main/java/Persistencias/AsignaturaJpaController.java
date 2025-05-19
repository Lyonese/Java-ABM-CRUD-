package Persistencias;

import Clases.Asignatura;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class AsignaturaJpaController {

    private EntityManager emf;

    public AsignaturaJpaController(EntityManagerFactory emf) {
        this.emf = (EntityManager) emf;
    }

    public AsignaturaJpaController() {
        emf = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
    }

    public void create(Asignatura asignatura) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.persist(asignatura);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void edit(Asignatura asignatura) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.merge(asignatura);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void destroy(int asignaturaCodigo) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            Asignatura asignatura = emf.find(Asignatura.class, asignaturaCodigo);
            if (asignatura != null) {
                emf.remove(asignatura);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Asignatura find(int asignaturaCodigo) {
        return emf.find(Asignatura.class, asignaturaCodigo);
    }

    public List<Asignatura> findAll() {
        return emf.createQuery("SELECT a FROM Asignatura a", Asignatura.class).getResultList();
    }
}
