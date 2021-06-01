package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Session;

public interface SessionRepository  extends JpaRepository<Session, Long>{

}
