package groupId.artifactId.storage.dao;

import groupId.artifactId.storage.dao.api.EntityManagerFactoryHibernate;
import groupId.artifactId.storage.dao.entity.Person;
import jakarta.persistence.EntityManager;

public class test {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerFactoryHibernate.getEntityManger();
        entityManager.getTransaction().begin();
        Person person = Person.builder().age(32).name("test").surname("test2").build();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        EntityManagerFactoryHibernate.close();
    }
}
