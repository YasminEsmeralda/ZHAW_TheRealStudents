package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}
