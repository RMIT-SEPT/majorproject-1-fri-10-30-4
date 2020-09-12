package app.service;

import app.entity.user.Employee;
import app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getAll() {

        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){

        return this.employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Integer employeeId){
        for(Employee employee : getAll()){
            if(employee.getEmployeeId() == employeeId) {
                return employeeRepository.findById(employeeId);
            }
        }
        return null;
    }

    public boolean removeEmployee(Integer employeeId){
        for(Employee employee : getAll()){
            if(employee.getEmployeeId() == employeeId) {
                employeeRepository.deleteById(employeeId);
                return true;
            }
        }
        return false;
    }

    public void removeAll() {
            employeeRepository.deleteAll();
    }




}
