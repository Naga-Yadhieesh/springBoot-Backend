package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepoImpl;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl 
{
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeRepoImpl employeeRepoImpl;
    
//    @Query(" FROM Employee where delete_switch=0")
//    public List<Employee> getAllEmployee() {
//        List<Employee> list = this.employeeRepository.findAll();
//        return list;
//    }
    
    
    public List<Employee> getAllEmployee(){
    	List<Employee> list1 = this.employeeRepoImpl.getAllEmployee();
    	List<Employee> empList = new ArrayList<Employee>();
    	for(Employee employee:list1) {
    		if(employee.getisdeleted() == false) { 
    			empList.add(employee);
    		}
    	} 
    	return empList;
    }
    
    public List<Employee> getOneEmployee(int id){
    	List<Employee> list1 = this.employeeRepoImpl.getOneEmployee(id);
    	List<Employee> empList = new ArrayList<Employee>();
    	for(Employee employee:list1) {
    	if(employee.getisdeleted()==false) {
    		empList.add(employee);
    	}
      }
    	return empList;
    }
     
//    public String getOneEmployee( int employeeId) {
//         Employee c = this.employeeRepository.findById(employeeId); //Refer Repository
//        if (!c.getisdeleted()) {
//            return c.toString();
//        }
//        return "EMPLOYEE ID does not exist";
//    }
    
//    public String addEmployee( Employee addEmployee) {
//        this.employeeRepository.save(addEmployee);
//         String s1 = "New Employee with Id '" + Integer.toString(addEmployee.getId()) + "' created";
//        return s1;
//    }
    
    
    public String addEmployee(Employee addEmployee) {
    	int id =this.employeeRepoImpl.addEmployee(addEmployee);
    	String s = "New Employee with ID " + id + " created";
    	return s;
    }
    
    public String updateEmployee( int employeeId, Employee updateEmployee) {
    	updateEmployee.setId(employeeId);
        Employee c = this.employeeRepository.findById(employeeId);
        if (!c.getisdeleted()) {
            this.employeeRepository.save(updateEmployee);
            return"Successfully Updated" + updateEmployee.toString();
        }else {
        return "EMPLOYEE ID does not exist";
        }
    }
    
    public String updateEmployeeWithJpql(int id , String firstName,Employee updateEmployee) {
//    	int update = employeeRepository.UpdateFirstName(id, firstName);
//    	if(update==0) {
//    		return "Unsuccessfully updated";
//    	}
//    	return "successfully updated";
    	int update = employeeRepository.UpdateFirstName(id, firstName);
    	updateEmployee.setId(id);
        Employee c = this.employeeRepository.findById(id);
        if (!c.getisdeleted() && (update==1)) {
            this.employeeRepository.save(updateEmployee);
            return "Successfully updated!!!\n"  /*updateEmployee.toString()*/  ;
        }else {
        return "EMPLOYEE ID does not exist";
        }
    }   
    
    public String deleteEmployee(int id) {
    	this.employeeRepoImpl.deleteEmployee(id);
    	String msg = "Succesfully deleted Employee with id " + id;
    	return msg;
    }
    
    
//    public String deleteEmployee(int employeeId) {
//         Employee c = this.employeeRepository.findById(employeeId);
//        if (!c.getisdeleted()) {
//            c.setisdeleted(true);
//            this.employeeRepository.save(c);
//             String s = "Succesfully deleted Employee with id " + Integer.toString(c.getId());
//            return s;
//        }
//        return "EMPLOYEE ID does not exist";
//    }
    
    
}