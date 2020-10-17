package app.service;

import app.entity.user.Employee;
import app.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Jasper Huang s3423585
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    private List<Employee> employees;

    @BeforeEach
    void init() {
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employees = new ArrayList<>();
        employees.add(employee1);
    }

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void removeEmployee_True_IfEmployeeIdExists() {
        when(mockEmployeeRepository.findAll()).thenReturn(employees);
        assertTrue(employeeService.removeEmployee(1));
    }

    @Test
    public void removeEmployee_False_IfEmployeeIdDoesNotExist() {
        when(mockEmployeeRepository.findAll()).thenReturn(employees);
        assertFalse(employeeService.removeEmployee(2));
    }
}
