package by.it_academy.jd2.hw.example.crm.hw.many_to_one_one_to_many;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws SQLException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        sessionOne.getTransaction().commit();

        HibernateUtil.shutdown();
    }

    public void printEmployee(Employee employee){
        System.out.println(employee);
        Department department = employee.getDepartment();
        for (Employee departmentEmployee : department.getEmployees()) {
            if (!employee.equals(departmentEmployee)){
                printEmployee(departmentEmployee);
            }
        }
    }
}
