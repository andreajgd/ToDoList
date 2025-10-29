package repository.impl;

import entities.Usuario;
import jakarta.persistence.EntityManager;
import repository.interfaces.IUsuario;

import java.util.List;

public class UsuarioImpl implements IUsuario {

    private final EntityManager em;

    public UsuarioImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        em.getTransaction().begin();
        if (usuario.getId() == null) {
            em.persist(usuario);
        } else {
            em.merge(usuario);
        }
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public boolean eliminar(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
}
