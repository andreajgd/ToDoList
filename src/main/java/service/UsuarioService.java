package service;

import entities.Usuario;
import repository.impl.UsuarioImpl;

import java.util.List;

public class UsuarioService {

    private UsuarioImpl usuarioRepo;

    public UsuarioService(UsuarioImpl usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return null;
        }
        return usuarioRepo.guardar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.listar();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepo.buscarPorId(id);
    }

    public boolean eliminarUsuario(Long id) {
        return usuarioRepo.eliminar(id);
    }
}
