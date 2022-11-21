package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.hw.one_to_one.Employee;
import org.hibernate.Session;

import java.util.concurrent.TimeUnit;

public class SqlTest5 {

    public static void main(String[] args) throws InterruptedException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();


        Employee employee = new Employee();
        employee.setName("test");
        employee.setSalary("78964");

        sessionOne.save(employee);

        System.out.println(employee);

        TimeUnit.DAYS.sleep(1);

        sessionOne.getTransaction().commit();


        HibernateUtil.shutdown();
    }
}
