package by.it_academy.jd2.hw.example.crm.model;

public class EmployeeSearchFilter extends PageableFilter {
    private EPredicateOperator predicateOperator;
    private String name;
    private ESalaryOperator salaryOperator;
    private String salary;

    public EmployeeSearchFilter(EPredicateOperator predicateOperator, String name, ESalaryOperator salaryOperator,
                                String salary, Integer page, Integer size,
                                ESortDirection sortDirection) {
        super(page, size, sortDirection);
        this.predicateOperator = predicateOperator;
        this.name = name;
        this.salaryOperator = salaryOperator;
        this.salary = salary;
    }

    public EPredicateOperator getPredicateOperator() {
        return predicateOperator;
    }

    public String getName() {
        return name;
    }

    public ESalaryOperator getSalaryOperator() {
        return salaryOperator;
    }

    public String getSalary() {
        return salary;
    }
}
