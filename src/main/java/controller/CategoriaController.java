package controller;

import entities.Categoria;
import service.CategoriaService;

import java.util.List;

public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Crear o guardar categoría
    public void crearCategoria(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        System.out.println("Categoría guardada: " + categoria.getNombre());
    }

    // Listar todas las categorías
    public void listarCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            System.out.println("Lista de categorías:");
            for (Categoria c : categorias) {
                System.out.println(c.getId() + " | " + c.getNombre());
            }
        }
    }

    // Buscar categoría por ID
    public void buscarCategoria(Long id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        if (categoria != null) {
            System.out.println("Categoría encontrada: " + categoria.getNombre());
        } else {
            System.out.println("Categoría no encontrada con ID: " + id);
        }
    }

    // Eliminar categoría
    public void eliminarCategoria(Long id) {
        boolean eliminado = categoriaService.eliminarCategoria(id);
        if (eliminado) {
            System.out.println("Categoría eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar. Verifica el ID.");
        }
    }
}
