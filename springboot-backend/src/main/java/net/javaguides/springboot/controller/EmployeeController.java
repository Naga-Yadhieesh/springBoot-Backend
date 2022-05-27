package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import net.javaguides.springboot.model.Employee;
//import net.javaguides.springboot.service.EmployeeService;
import net.javaguides.springboot.service.impl.EmployeeServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/start" })
public class EmployeeController
{
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    
    @GetMapping({ "/employees" })
    public List<Employee> getEmployee() {
        return this.employeeServiceImpl.getAllEmployee();
    }
    
    @GetMapping({ "/employees/{employeeId}" })
    public List<Employee> getOneEmployee(@PathVariable  String employeeId) {
        return this.employeeServiceImpl.getOneEmployee(Integer.parseInt(employeeId));
    }
    
    @PostMapping({ "/employees" })
    public String postEmployee(@RequestBody  Employee addEmployee) {
        return this.employeeServiceImpl.addEmployee(addEmployee);
    }
    
    @PutMapping({ "/employees/{employeeId}" })
    public void updateEmployee(@PathVariable  int employeeId, @RequestBody  Employee updateEmployee) {
         this.employeeServiceImpl.updateEmployee(employeeId, updateEmployee);
    }
    
    @PutMapping("updateFirstName/{id}")
    public String updateEmployeeWithJpql(@PathVariable int id, String firstName, @RequestBody  Employee updateEmployee) {
         return employeeServiceImpl.updateEmployeeWithJpql(id, firstName,updateEmployee);
    }  
     
    @DeleteMapping({ "/employees/{employeeId}" })
    public String deleteEmployee(@PathVariable  String employeeId) {
        return this.employeeServiceImpl.deleteEmployee(Integer.parseInt(employeeId));
    }
}
