package by.it_academy.jd2.hw.example.crm.model;

public class EmployeeWithOutDepartment {
    private String name;
    private String salary;
    private Long departmentId;

    public EmployeeWithOutDepartment() {
    }

    public EmployeeWithOutDepartment(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "EmployeeWithOutDepartment{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
