package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.EmployeeRowMapper;

@Repository
public class EmployeeRepoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addEmployee(Employee addEmployee) {
		String query = "insert into employee(first_name,last_name,email,isdeleted) values(?,?,?,?) ";
		String getId = "SELECT LAST_INSERT_ID()";
	 int saveEmployees =  this.jdbcTemplate.update(query,new Object[] {addEmployee.getFirstName(),
				addEmployee.getLastName(),addEmployee.getEmail(),addEmployee.getisdeleted()});
		if(saveEmployees>0) {
			int id = jdbcTemplate.queryForObject(getId, Integer.class);
			return id;
		}
	  System.out.println("id " + saveEmployees);
	  return 0;	
	}
	
	public int deleteEmployee(int id) {
		String query = "update employee set isdeleted =1 where id="+id+";";
		return this.jdbcTemplate.update(query);
	}
	
	public List<Employee> getAllEmployee(){
		return this.jdbcTemplate.query("select * from employee where isdeleted=0", new EmployeeRowMapper());
	}
	
	public List<Employee> getOneEmployee(int id){
//		String query = "select * from employee where id " + id + " and isdeleted = 0;";
		String query = "select * from employee where id="+id+";";
		return this.jdbcTemplate.query(query, new EmployeeRowMapper()); 
		
	}
	  
}
 