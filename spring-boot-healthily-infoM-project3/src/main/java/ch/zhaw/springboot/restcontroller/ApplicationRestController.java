package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Application;
import ch.zhaw.springboot.repositories.ApplicationRepository;

@RestController
public class ApplicationRestController {
	
	@Autowired
	private ApplicationRepository repository;

	@RequestMapping(value = "healthily/application", method = RequestMethod.GET)
	public ResponseEntity<List<Application>> getUsers() {
		List<Application> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Application>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Application>>(HttpStatus.NOT_FOUND);
		}
	}
}
