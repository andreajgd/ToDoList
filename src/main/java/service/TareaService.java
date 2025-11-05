package service;

import entities.Tarea;
import repository.impl.TareaImpl;

import java.util.List;

public class TareaService {

    private TareaImpl tareaRepo;

    public TareaService(TareaImpl tareaRepo) {
        this.tareaRepo = tareaRepo;
    }

    public Tarea guardarTarea(Tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isEmpty()) {
            System.out.println("El título de la tarea no puede estar vacío.");
            return null;
        }
        return tareaRepo.guardar(tarea);
    }

    public List<Tarea> listarTareas() {
        return tareaRepo.listar();
    }

    public Tarea buscarTareaPorId(Long id) {
        return tareaRepo.buscarPorId(id);
    }

    public boolean eliminarTarea(Long id) {
        return tareaRepo.eliminar(id);
    }
}
