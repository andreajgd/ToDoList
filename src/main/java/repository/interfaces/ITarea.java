package repository.interfaces;
import entities.*;
import java.util.List;

public interface ITarea {
    Tarea guardar(Tarea tarea);
    List<Tarea> listar();
    Tarea buscarPorId(Long id);
    //Tarea modificar(Long id);
    boolean eliminar(Long id);

}
