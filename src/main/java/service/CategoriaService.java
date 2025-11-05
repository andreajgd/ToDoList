package service;

import entities.Categoria;
import repository.impl.CategoriaImpl;
import java.util.List;

public class CategoriaService {
    private CategoriaImpl categoriaRepo;

    public CategoriaService(CategoriaImpl categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    public Categoria guardarCategoria(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío.");
            return null;
        }
        return categoriaRepo.guardar(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepo.listar();
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepo.buscarPorId(id);
    }

    public boolean eliminarCategoria(Long id) {
        return categoriaRepo.eliminar(id);
    }
}
