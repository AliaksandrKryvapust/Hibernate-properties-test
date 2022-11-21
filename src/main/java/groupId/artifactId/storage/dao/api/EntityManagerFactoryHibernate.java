package groupId.artifactId.storage.dao.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryHibernate {
    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("hibernate");
    }

    public static EntityManager getEntityManger() {
            return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        entityManagerFactory.close();
    }
}
