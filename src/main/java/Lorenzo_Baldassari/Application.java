package Lorenzo_Baldassari;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Project-Library");
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em =emf.createEntityManager();
    }
}
