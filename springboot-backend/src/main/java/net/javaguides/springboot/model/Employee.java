package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(name = "first_name", nullable = false)
	private String firstName;
	
//	@Column(name = "last_name")
	private String lastName;

//	@Column(name = "email")
	private String email;
	
	private Boolean isdeleted;
	
	public Employee() {
		this.isdeleted = false;
	}
	
	public Employee(final int id,final String firstName,final String lastName,final String email) {
		this.isdeleted = false;
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Boolean getisdeleted() {
		return isdeleted;
	}

	public void setisdeleted(final Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Override
	public String toString() {
		return "Employee id : " + id + ",\nfirstName : " + firstName + ",\nlastName : " + lastName + ",\nemail : " + email ;
	}
	

	
}