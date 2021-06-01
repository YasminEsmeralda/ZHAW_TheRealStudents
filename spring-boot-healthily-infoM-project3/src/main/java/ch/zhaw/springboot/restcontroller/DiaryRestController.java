package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Diary;
import ch.zhaw.springboot.repositories.DiaryRepository;

@RestController
public class DiaryRestController {
	
	@Autowired
	private DiaryRepository repository;

	@RequestMapping(value = "healthily/diaries", method = RequestMethod.GET)
	public ResponseEntity<List<Diary>> getAllDiaries() {
		List<Diary> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Diary>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Diary>>(HttpStatus.NOT_FOUND);
		}
	}
}
