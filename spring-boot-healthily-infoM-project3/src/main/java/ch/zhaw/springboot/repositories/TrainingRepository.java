package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
