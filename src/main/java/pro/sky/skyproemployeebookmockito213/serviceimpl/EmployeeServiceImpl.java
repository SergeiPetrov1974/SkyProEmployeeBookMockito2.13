package pro.sky.skyproemployeebookmockito213.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.skyproemployeebookmockito213.data.Employee;
import pro.sky.skyproemployeebookmockito213.exception.EmployeeNotFoundException;
import pro.sky.skyproemployeebookmockito213.exception.IllegalNameException;
import pro.sky.skyproemployeebookmockito213.service.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.remove(firstName + lastName);
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        if (isAlpha(firstName) && isAlpha(lastName)) {
            Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), departmentId, salary);
            employees.put(firstName + lastName, employee);
            return employee;
        }
        throw new IllegalNameException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return employees.values()
                .stream()
                .filter(employee -> (employee.getFirstName() + employee.getLastName()).equals(firstName + lastName))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }
}
