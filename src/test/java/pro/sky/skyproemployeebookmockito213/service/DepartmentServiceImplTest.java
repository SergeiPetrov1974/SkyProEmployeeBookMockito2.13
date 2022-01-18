package pro.sky.skyproemployeebookmockito213.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproemployeebookmockito213.serviceimpl.DepartmentServiceImpl;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.skyproemployeebookmockito213.constants.EmployeeBookConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnAllEmployeesByOneDepartment () {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);

        assertIterableEquals(CORRECT_COLLECTION_DEP1, out.getAllEmployeesByDepartmentId(1));
    }

    @Test
    public void shouldReturnAllEmployeesSortedByDepartment () {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertIterableEquals(CORRECT_COLLECTION, out.getAllEmployeesByDepartmentId(null));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenDepartmentAbsent () {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertIterableEquals(EMPTY_COLLECTION, out.getAllEmployeesByDepartmentId(3));
    }

    @Test
    public void shouldReturnMinSalaryEmployeeByDepartment() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(TEST_EMPLOYEE, out.getMinSalaryEmployeeByDepartment(1));
    }

    @Test
    public void shouldReturnMaxSalaryEmployeeByDepartment() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(TEST_EMPLOYEE2, out.getMinSalaryEmployeeByDepartment(2));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForMinSalaryEmployeeFindingWhenDepartmentAbsent () {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertThrows(NoSuchElementException.class,
                () -> out.getMinSalaryEmployeeByDepartment(3));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForMaxSalaryEmployeeFindingWhenDepartmentAbsent () {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(CORRECT_COLLECTION);
        assertThrows(NoSuchElementException.class,
                () -> out.getMaxSalaryEmployeeByDepartment(3));
    }
}
