package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Session;
import ch.zhaw.springboot.repositories.SessionRepository;

@RestController
public class SessionRestController {
	
	@Autowired
	private SessionRepository repository;

	@RequestMapping(value = "healthily/sessions", method = RequestMethod.GET)
	public ResponseEntity<List<Session>> getUsers() {
		List<Session> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Session>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Session>>(HttpStatus.NOT_FOUND);
		}
	}

}
