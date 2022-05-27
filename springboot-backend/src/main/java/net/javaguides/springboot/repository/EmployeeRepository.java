package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import net.javaguides.springboot.model.Employee;
import java.util.List;



//import org.springframework.beans.factory.annotation.Autowired;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Employee findById(int employeeId);
	
   @Query(" FROM Employee where isdeleted=0")
    List<Employee> findAll();

//    //UPDATE Employee SET first_name='nnn' WHERE id=3 and isdeleted=0;
////	@Query("UPDATE Employee SET first_name= :firstName, last_name= :lastName, email= :email WHERE id=6 and isdeleted=0")
////	public void updateEmployee(@Param("id")String id,@Param("firstName") String first_name,@Param("lastName") String last_name,@Param("email") String email,
////			@Param("isdeleted") String isdeleted);
//    
    @Transactional
    @Modifying
    @Query("Update Employee Set firstName= :firstName where id = :id and isdeleted=0")
    int UpdateFirstName(int id , String firstName);
} 

