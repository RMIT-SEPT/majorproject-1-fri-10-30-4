package app.service;

import app.entity.user.Employee;
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
    	Collection<Employee> output = new HashSet<Employee>();
    	for(Employee employee : businessEmployees) {
    		if(employee.getServices().contains(serviceID)) {
    			output.add(employee);
    		}
    	}
    	return output;
    }
    
    public Iterable<Date> getUpcomingBookingDates(int businessID, int serviceID, int employeeID){
    	ArrayList<Date> validDates = new ArrayList<Date>();
    	Employee employee = employeeRepository.findById(employeeID).get();
    	Calendar calendar = Calendar.getInstance();
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	//0, 2
    	//1, 1
    	//2, 7
    	//3, 6
    	//4, 5
    	//5, 4
    	//6, 3
    	
    	if(employee.getSundayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7 - dayOfWeek);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getMondayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 0 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getTuesdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = Calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 1 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getWednesdayTime()() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 2 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getThursdayTime()() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 3 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getFridayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 4 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	if(employee.getSaturdayTime() != "NO_SCHEDULE") {
    		Calendar dateToAdd = calendar.getInstance();
    		dateToAdd.add(Calendar.DAY_OF_YEAR, Math.floorMod(7, 5 - dayOfWeek) + 1);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    		dateToAdd.add(Calendar.DAY_OF_YEAR, 7);
    		validDates.add(new Date(dateToAdd.getTimeInMillis()));
    	}
    	return null;
    }
    
}
