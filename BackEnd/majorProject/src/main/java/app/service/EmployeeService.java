package app.service;

import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.user.Employee;
import app.model.user.EmployeeImpl;
import app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /* UserRepo might needed to be added here - if an employee is
    removed from the EmpRepo then it should be removed from the
    entire data base.*/

    public Iterable<EmployeeImpl> getAll() {
        return employeeRepository.findAll();
    }

    public EmployeeImpl createEmployee(EmployeeImpl employee){
        return employeeRepository.save(employee);
    }

    public boolean removeEmployee(Integer employeeID){
        for(EmployeeImpl employee : getAll()){
            if(employee.getUserID() == employeeID) {
                employeeRepository.deleteById(employeeID);
                return true;
            }
        }
        return false;

    }




}
