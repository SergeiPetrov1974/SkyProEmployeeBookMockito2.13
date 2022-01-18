package pro.sky.skyproemployeebookmockito213.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookmockito213.data.Employee;
import pro.sky.skyproemployeebookmockito213.service.DepartmentService;
import pro.sky.skyproemployeebookmockito213.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getMinSalaryEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartmentId(Integer departmentId) {
        Stream<Employee> employeeStream = employeeService.getAllEmployees().stream();

        if (departmentId != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartmentId() == departmentId);
        }

        return employeeStream.sorted(
                Comparator.comparing(Employee::getDepartmentId)
                        .thenComparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName)
        ).collect(Collectors.toList());
    }
}
