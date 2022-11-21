package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.hw.one_to_one.Employee;
import by.it_academy.jd2.hw.example.crm.model.EmployeeSearchFilter;
import by.it_academy.jd2.hw.example.crm.model.PageableFilter;
import by.it_academy.jd2.hw.example.crm.storage.EmployeeStorage;

import java.util.List;

public class EmployeeService {

    private final static EmployeeService instance = new EmployeeService();
    private final EmployeeStorage storage;

    public EmployeeService() {
        this.storage = EmployeeStorage.getInstance();
    }

    public List<Employee> page(EmployeeSearchFilter filter){
        return this.storage.page(filter);
    }

    public static EmployeeService getInstance() {
        return instance;
    }
}
