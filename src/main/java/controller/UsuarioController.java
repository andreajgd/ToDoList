package controller;

import entities.Usuario;
import service.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Crear o guardar un usuario
    public void crearUsuario(Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        System.out.println("Usuario guardado con éxito: " + usuario.getNombre());
    }

    // Listar todos los usuarios
    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getCorreo());
        }
    }

    // Buscar usuario por ID
    public void buscarUsuario(Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario != null) {
            System.out.println("Encontrado: " + usuario.getNombre());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        if (eliminado) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el usuario.");
        }
    }
}
