package app.service;

import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.user.Employee;
import app.model.user.EmployeeImpl;
import app.model.user.UserImpl;
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

    public boolean removeEmployee(Integer userID){
        for(UserImpl employee : getAll()){
            if(employee.getUserId() == userID) {
                employeeRepository.deleteById(userID);
                return true;
            }
        }
        return false;

    }




}
