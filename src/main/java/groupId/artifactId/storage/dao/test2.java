package groupId.artifactId.storage.dao;

import groupId.artifactId.storage.dao.api.EntityManagerFactoryHibernate;
import groupId.artifactId.storage.dao.entity.Person;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class test2 {
    private static final String SELECT_PERSON = "SELECT person from Person person WHERE person.age>?1 ORDER BY person.id";
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerFactoryHibernate.getEntityManger();
        entityManager.getTransaction().begin();
        List<?> iPerson = entityManager.createQuery(SELECT_PERSON).setParameter(1, 35).getResultList();
        List<Person> output = iPerson.stream().filter((i) -> i instanceof Person)
                .map(Person.class::cast).collect(Collectors.toList());
        entityManager.getTransaction().commit();
        EntityManagerFactoryHibernate.close();
        System.out.println(output);
    }
}
