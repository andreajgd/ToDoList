package repository.interfaces;
import java.util.List;
import entities.*;

    public interface IUsuario {
        Usuario guardar(Usuario usuario);
        List<Usuario> listar();
        Usuario buscarPorId(Long id);
        boolean eliminar(Long id);

    }
