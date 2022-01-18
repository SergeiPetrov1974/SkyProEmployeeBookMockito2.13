package pro.sky.skyproemployeebookmockito213.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployeebookmockito213.data.Employee;
import pro.sky.skyproemployeebookmockito213.serviceimpl.EmployeeServiceImpl;
import pro.sky.skyproemployeebookmockito213.serviceimpl.UserMessageServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final UserMessageServiceImpl userMessageService;

    public EmployeeController(EmployeeServiceImpl employeeService, UserMessageServiceImpl userMessageService) {
        this.employeeService = employeeService;
        this.userMessageService = userMessageService;
    }

    @GetMapping
    public String showWelcomeMessage() {
        return userMessageService.showGreeting();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
