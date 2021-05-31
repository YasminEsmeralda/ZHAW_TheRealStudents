package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
