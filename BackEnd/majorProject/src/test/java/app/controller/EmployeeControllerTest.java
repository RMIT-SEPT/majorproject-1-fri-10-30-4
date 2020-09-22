package app.controller;
/*
    Author: Nikita Phung s3783287
 */
import app.entity.user.Employee;
import app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    List<Employee> employees;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private EmployeeService employeeService;

    @BeforeEach
    void createEmployees() {
        employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setBusinessId(1);
        employee1.setFirstName("Jon");
        employee1.setLastName("Snow");
        employee1.setEmail("jon@ecorp.com");
        employee1.setPasswordHash("password");
        employee1.setPhoneNumber("123123");
        employee1.setService(null);
        employee1.setMondayTime("");
        employee1.setThursdayTime("");
        employee1.setTuesdayTime("");
        employee1.setWednesdayTime("");
        employee1.setFridayTime("");
        employee1.setSaturdayTime("");
        employee1.setSundayTime("");
        employees.add(employee1);
    }

    @Test
    public void getAllEmployees() throws Exception
    {
        when(employeeService.getAll()).thenReturn(employees);
        mvc.perform( MockMvcRequestBuilders
                .get("/employee/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void getEmployeeById_Ok() throws Exception
    {
        Employee employee = employees.get(0);
        when(employeeService.getEmployee(employee.getEmployeeId())).thenReturn(java.util.Optional.of(employee));
        mvc.perform( MockMvcRequestBuilders
                .get("/employee/{id}", employee.getEmployeeId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getEmployeeById_BadRequest_IdNotFound() throws Exception
    {
        Integer id = 12;
        when(employeeService.getEmployee(id)).thenReturn(null);
        mvc.perform( MockMvcRequestBuilders
                .get("/employee/{id}", id))
                .andExpect(content().string("Error: Employee #"+ id +" not found."))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getEmployeeById_BadRequest_IdRequired() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/employee/{id}", " "))
                .andExpect(content().string("Error: Employee ID required in path parameter."))
                .andExpect(status().isBadRequest());
    }





}
