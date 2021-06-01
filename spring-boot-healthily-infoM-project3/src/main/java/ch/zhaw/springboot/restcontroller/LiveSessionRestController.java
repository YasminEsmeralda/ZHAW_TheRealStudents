package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.LiveSession;
import ch.zhaw.springboot.repositories.LiveSessionRepository;

@RestController
public class LiveSessionRestController {
	
	@Autowired
	private LiveSessionRepository repository;

	@RequestMapping(value = "healthily/liveSessions", method = RequestMethod.GET)
	public ResponseEntity<List<LiveSession>> getAllLiveSessions() {
		List<LiveSession> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<LiveSession>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<LiveSession>>(HttpStatus.NOT_FOUND);
		}
	}
}
