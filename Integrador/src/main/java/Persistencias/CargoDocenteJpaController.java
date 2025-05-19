package Persistencias;

import Clases.CargoDocente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class CargoDocenteJpaController {

    private EntityManager emf;

    public CargoDocenteJpaController(EntityManagerFactory emf) {
        this.emf = (EntityManager) emf;
    }

    public CargoDocenteJpaController() {
        emf = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
    }

    public void create(CargoDocente cargoDocente) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.persist(cargoDocente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void edit(CargoDocente cargoDocente) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            emf.merge(cargoDocente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void destroy(int cargoDocenteNro) {
        EntityTransaction transaction = emf.getTransaction();
        try {
            transaction.begin();
            CargoDocente cargoDocente = emf.find(CargoDocente.class, cargoDocenteNro);
            if (cargoDocente != null) {
                emf.remove(cargoDocente); 
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public CargoDocente find(int cargoDocenteNro) {
        return emf.find(CargoDocente.class, cargoDocenteNro);
    }

    public List<CargoDocente> findAll() {
        return emf.createQuery("SELECT c FROM CargoDocente c", CargoDocente.class).getResultList();
    }
}
