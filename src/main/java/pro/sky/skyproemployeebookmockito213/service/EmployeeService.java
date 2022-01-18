package pro.sky.skyproemployeebookmockito213.service;

import pro.sky.skyproemployeebookmockito213.data.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee removeEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();

}
