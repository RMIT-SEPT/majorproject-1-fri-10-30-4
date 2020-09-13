package app.service;

import app.model.user.EmployeeImpl;
import app.model.user.UserImpl;
import app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<EmployeeImpl> getAll() {
        return employeeRepository.findAll();
    }

    public EmployeeImpl createEmployee(EmployeeImpl employee){
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeImpl> getEmployee(Integer userId){
        for(EmployeeImpl employee : getAll()){
            if(employee.getUserId() == userId) {
                return employeeRepository.findById(userId);
            }
        }
        return null;
    }

    public boolean removeEmployee(Integer userId){
        for(UserImpl employee : getAll()){
            if(employee.getUserId() == userId) {
                employeeRepository.deleteById(userId);
                return true;
            }
        }
        return false;
    }

    public void removeAll() {
            employeeRepository.deleteAll();
    }

    public Iterable<EmployeeImpl> getAllByBusinessAndService(int businessID, int serviceID){
    	Collection<EmployeeImpl> businessEmployees = employeeRepository.getEmployeeByBusiness(businessID);
    	Collection<EmployeeImpl> output = new HashSet<EmployeeImpl>();
    	for(EmployeeImpl employee : businessEmployees) {
    		if(employee.getServices().contains(serviceID)) {
    			output.add(employee);
    		}
    	}
    	return output;
    }
    
    public void saveEmployee(EmployeeImpl employee) {
    	employeeRepository.save(employee);
    }
    
}
