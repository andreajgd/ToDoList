package controller;

import entities.Tarea;
import service.TareaService;

import java.util.List;

public class TareaController {

    private TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // Crear o guardar tarea
    public void crearTarea(Tarea tarea) {
        tareaService.guardarTarea(tarea);
        System.out.println("Tarea guardada: " + tarea.getTitulo());
    }

    // Listar todas las tareas
    public void listarTareas() {
        List<Tarea> tareas = tareaService.listarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            System.out.println("Lista de tareas:");
            for (Tarea t : tareas) {
                System.out.println(t.getId() + " | " + t.getTitulo());
            }
        }
    }

    // Buscar tarea por ID
    public void buscarTarea(Long id) {
        Tarea tarea = tareaService.buscarTareaPorId(id);
        if (tarea != null) {
            System.out.println("Tarea encontrada: " + tarea.getTitulo());
        } else {
            System.out.println("Tarea no encontrada con ID: " + id);
        }
    }

    // Eliminar tarea
    public void eliminarTarea(Long id) {
        boolean eliminado = tareaService.eliminarTarea(id);
        if (eliminado) {
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar. Verifica el ID.");
        }
    }
}
