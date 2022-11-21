package by.it_academy.jd2.hw.example.crm.hw.one_to_many_2;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) throws SQLException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        Department department = new Department("Колхоз 888");
        sessionOne.save(department);

        Employee employee1 = new Employee();
        employee1.setName("88888");
        sessionOne.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("88888");
        sessionOne.save(employee2);

        department.setEmployees(Arrays.asList(employee1, employee2));

        sessionOne.update(department);

        sessionOne.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
