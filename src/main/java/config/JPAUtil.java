package config;

//interfaz EntityManager,principal para interactuar con BD
import jakarta.persistence.EntityManager;
//para crear instancias de EM
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    //
    private static final String PERSISTENCE_UNIT_NAME = "ToDoList"; //nombre del persistence.xml
    private static EntityManagerFactory emf;

    //inicializa el EntityManagerFactory solo una vez
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            System.err.println("Error al inicializar EntityManagerFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //método para obtener un EntityManager
    public static EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory no está inicializado.");
        }
        return emf.createEntityManager();
    }

    //método para cerrar el EntityManagerFactory
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
