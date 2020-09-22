package app.service;

import app.entity.user.Employee;
import app.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

/**
 * @author Jasper Huang s3423585
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    private AutoCloseable closeable;
    private List<Employee> employees;

    @BeforeEach
    void init() {
        closeable = MockitoAnnotations.openMocks(this);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setEmployeeId(1);
        employee2.setEmployeeId(2);

        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
    }

    @AfterEach
    void finalise() throws Exception {
        closeable.close();
    }

    @Mock
    private EmployeeRepository mockedEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void removeEmployee_True_IfEmployeeIdExists() {
        doReturn(employees).when(mockedEmployeeRepository).findAll();
        assertTrue(employeeService.removeEmployee(2));
    }

    @Test
    public void removeEmployee_False_IfEmployeeIdDoesNotExist() {
        doReturn(employees).when(mockedEmployeeRepository).findAll();
        assertFalse(employeeService.removeEmployee(3));
    }
}
