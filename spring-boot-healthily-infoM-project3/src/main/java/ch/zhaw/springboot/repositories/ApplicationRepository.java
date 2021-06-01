package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	
	@Query("SELECT a FROM Application a WHERE TYPE(a) = LiveSession")
	public List<Application> getLiveSessions();
	
	@Query("SELECT a FROM Application a WHERE TYPE(a) = Diary")
	public List<Application> getDiaries();
	
	@Query("SELECT a FROM Application a WHERE TYPE(a) = Workout")
	public List<Application> getWorkouts();
}
