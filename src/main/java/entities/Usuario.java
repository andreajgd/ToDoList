package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;

    public Usuario() {
    }
}
