package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	@Query("SELECT pe FROM Person pe WHERE pe.birthdate = ?1")
//	public List<User> findPersonsByBirthdate(long birthdate);
}
