package net.javaguides.springboot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{
	
	@Override
	public Employee mapRow(ResultSet rs,int rowNum) throws SQLException{
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setFirstName(rs.getNString("first_name"));
		emp.setLastName(rs.getNString("last_name"));
		emp.setEmail(rs.getNString("email"));
		return emp;
	}
}
