package by.it_academy.jd2.hw.example.crm.hw.one_to_one;

import org.hibernate.Session;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        Department department = new Department("Колхоз 777");

        sessionOne.save(department);

        Employee employee = new Employee();

        employee.setName("9999");
        employee.setDepartment(department);

        sessionOne.update(employee);


        sessionOne.getTransaction().commit();


        HibernateUtil.shutdown();
    }
}
