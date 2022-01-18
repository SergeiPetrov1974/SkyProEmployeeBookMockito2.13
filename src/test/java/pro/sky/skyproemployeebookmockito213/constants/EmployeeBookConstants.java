package pro.sky.skyproemployeebookmockito213.constants;

import pro.sky.skyproemployeebookmockito213.data.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeBookConstants {
    public static final String TEST_FIRST_NAME = "Ivan";
    public static final String TEST_LAST_NAME = "Ivanov";
    public static final String TEST_FIRST_NAME2 = "Petr";
    public static final String TEST_LAST_NAME2 = "Petrov";
    public static final String TEST_FIRST_NAME_SMALL_LETTER = "ivan";
    public static final String TEST_LAST_NAME_SMALL_LETTER = "ivanov";
    public static final int TEST_DEPARTMENT1 = 1;
    public static final int TEST_DEPARTMENT2 = 2;
    public static final int TEST_SALARY = 10000;
    public static final int TEST_SALARY2 = 12000;
    public static final Employee TEST_EMPLOYEE = new Employee("Ivan", "Ivanov", 1, 10000);
    public static final Employee TEST_EMPLOYEE2 = new Employee("Petr", "Petrov", 2, 12000);
    public static final String INCORRECT_FIRST_NAME = "Ivan351";
    public static final String INCORRECT_LAST_NAME = "Ivanov!!!";
    public static final Collection<Employee> CORRECT_COLLECTION = List.of(
            TEST_EMPLOYEE,
            TEST_EMPLOYEE2
    );
    public static final Collection<Employee> CORRECT_COLLECTION_DEP1 = List.of(
            TEST_EMPLOYEE
    );
    public static final Collection<Employee> EMPTY_COLLECTION = new ArrayList<>();
}
