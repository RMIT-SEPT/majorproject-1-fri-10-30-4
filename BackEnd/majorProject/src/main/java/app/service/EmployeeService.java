package app.service;

import app.entity.BusinessServiceJob;
import app.entity.user.Employee;
import app.repository.BusinessServiceRepository;
import app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BusinessServiceRepository businessServiceRepository;
    
    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
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

    public Iterable<Employee> getAllByBusinessAndService(int businessID, int serviceID){
    	Collection<Employee> businessEmployees = employeeRepository.getEmployeeByBusiness(businessID);
    	BusinessServiceJob service = businessServiceRepository.findById(serviceID).get();
    	Collection<Employee> output = new HashSet<Employee>();
    	for(Employee employee : businessEmployees) {
    		if(employee.getServices().contains(service)) {
    			output.add(employee);
    		}
    	}
    	return output;
    }
    
    public Iterable<Date> getUpcomingBookingDates(int businessID, int serviceID, int employeeID){
    	ArrayList<Date> validDates = new ArrayList<Date>();
    	Employee employee = employeeRepository.findById(employeeID).get();
    	Calendar calendar = Calendar.getInstance();
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    	if(employee.getSundayTime().isEmpty() != true && employee.getSundayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7 - dayOfWeek);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getMondayTime().isEmpty() != true && employee.getMondayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((0 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getTuesdayTime().isEmpty() != true && employee.getTuesdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((1 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getWednesdayTime().isEmpty() != true && employee.getWednesdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((2 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getThursdayTime().isEmpty() != true && employee.getThursdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((3 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getFridayTime().isEmpty() != true && employee.getFridayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((4 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getSaturdayTime().isEmpty() != true && employee.getSaturdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod((5 - dayOfWeek) + 1, 7) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	return validDates;
    }
    
}
