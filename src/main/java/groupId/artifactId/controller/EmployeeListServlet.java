package by.it_academy.jd2.hw.example.crm.controller;

import by.it_academy.jd2.hw.example.crm.model.EPredicateOperator;
import by.it_academy.jd2.hw.example.crm.model.ESalaryOperator;
import by.it_academy.jd2.hw.example.crm.model.ESortDirection;
import by.it_academy.jd2.hw.example.crm.model.EmployeeSearchFilter;
import by.it_academy.jd2.hw.example.crm.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee_filter")
public class EmployeeListServlet extends HttpServlet {

    private EmployeeService service;

    public EmployeeListServlet() {
        this.service = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String salaryOperator = req.getParameter("salary_operator");
        String salary = req.getParameter("salary");
        String page = req.getParameter("page");
        String size = req.getParameter("size");


        EmployeeSearchFilter filter = new EmployeeSearchFilter(
                EPredicateOperator.AND,
                name, ESalaryOperator.valueOf(salaryOperator), salary,
                page == null ? 0 : Integer.parseInt(page),
                size == null ? 0 : Integer.parseInt(size),
                ESortDirection.ASC
        );

        this.service.page(filter);
    }
}
