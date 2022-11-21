package by.it_academy.jd2.hw.example.crm.controller;

import by.it_academy.jd2.hw.example.crm.hw.one_to_one.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class EmployeeServletParam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");

        Employee employee = new Employee(name, salary);



    }
}
