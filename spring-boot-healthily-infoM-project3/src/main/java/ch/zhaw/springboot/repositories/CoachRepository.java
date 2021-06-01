package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {
	
//	@Query("SELECT pe FROM Person pe WHERE pe.birthdate = ?1")
//	public List<User> findPersonsByBirthdate(long birthdate);

}
