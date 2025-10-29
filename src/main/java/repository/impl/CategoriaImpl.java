package repository.impl;

import entities.Categoria;
import jakarta.persistence.EntityManager;
import repository.interfaces.ICategoria;

import java.util.List;

public class CategoriaImpl implements ICategoria {

    private EntityManager em;

    public CategoriaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        em.getTransaction().begin();
        if (categoria.getId() == null) {
            em.persist(categoria);
        } else {
            em.merge(categoria);
        }
        em.getTransaction().commit();
        return categoria;
    }

    @Override
    public List<Categoria> listar() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public boolean eliminar(Long id) {
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
}
