package pro.sky.skyproemployeebookmockito213.service;

import pro.sky.skyproemployeebookmockito213.data.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee getMaxSalaryEmployeeByDepartment(int departmentId);

    Employee getMinSalaryEmployeeByDepartment(int departmentId);

    Collection<Employee> getAllEmployeesByDepartmentId(Integer departmentId);
}