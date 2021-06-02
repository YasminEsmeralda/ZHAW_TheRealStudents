package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
//	@Query("SELECT pe FROM Person pe WHERE pe.birthdate = ?1")
//	public List<User> findPersonsByBirthdate(long birthdate);	
//	@Query("SELECT t FROM Training t, Workout w, Customer c,  WHERE c.id = ?1 AND ")
	
//	@Query("SELECT t "
//		 + "FROM Training t "
//		 + "JOIN ON Workout w ON t.fk_workout_id = w.id"
//		 + "JOIN ON Customer c ON w.fk_customer_id = c.id"
//		 + "WHERE c.id = ?1"
//		 + "AND t.level = ?2")
//	@Query("SELECT t from Customer c, Workout w, Training t "
//			+ "WHERE t.fk_workout_id = w.id"
//			+ "AND w.fk_customer_id = c.id"
//			+ "AND t.level = ?2"
//			+ "AND c.id = ?1")	
//	@Query("SELECT t FROM Customer c, Training t WHERE c.id = ?1 AND t.level = ?2") 
	
//	"SELECT ph FROM Employee e
//    JOIN e.department d
//    JOIN e.phones ph
//    WHERE d.name IS NOT NULL""
//    		+ "
//	
//    @Query("SELECT t FROM Training t, Workout w, Customer c WHERE t.level = ?2 AND t.fk_workout_id = w AND w.fk_customer_id = c AND c.id = ?1")

	@Query("SELECT ts FROM Workout w JOIN w.customer c JOIN w.trainings ts WHERE c.id = ?1 AND ts.level = ?2")
	public List<Training> getTrainingsByCustomerLevel(long id, int level);
	
	@Query("SELECT t FROM Training t WHERE t.level = ?1") 
	public List<Training> getTrainingsByLevel(int level);
	
	
}