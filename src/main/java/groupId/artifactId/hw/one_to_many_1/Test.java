package by.it_academy.jd2.hw.example.crm.hw.one_to_many_1;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws SQLException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        Employee employee = new Employee();

        employee.setName("9999");

        sessionOne.save(employee);

        Department department = new Department("Колхоз 777");
        department.setEmployees(Arrays.asList(employee));

        sessionOne.save(department);

        sessionOne.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
