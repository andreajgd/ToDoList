package repository.impl;

import entities.Tarea;
import repository.interfaces.ITarea;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TareaImpl implements ITarea {

    private final EntityManager em;
    public TareaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Tarea guardar(Tarea tarea){
        //funcion dentro de EM
        em.getTransaction().begin();
        if(tarea.getId() == null){
            em.persist(tarea);
        }
        else{
            em.merge(tarea);
        }
        em.getTransaction().commit();
        return tarea;
    }

    @Override
    public List<Tarea> listar() {
        return em.createQuery("SELECT t FROM Tarea t", Tarea.class).getResultList();
    }

    @Override
    public Tarea buscarPorId(Long id){
        return em.find(Tarea.class, id);
    }

    @Override
    public boolean eliminar(Long id) {
        Tarea tarea = em.find(Tarea.class, id);
        if (tarea != null) {
            em.getTransaction().begin();
            em.remove(tarea);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }


}
