package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Entry;
import ch.zhaw.springboot.repositories.EntryRepository;

@RestController
public class EntryRestController {
	
	@Autowired
	private EntryRepository repository;

	@RequestMapping(value = "healthily/entry", method = RequestMethod.GET)
	public ResponseEntity<List<Entry>> getUsers() {
		List<Entry> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Entry>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Entry>>(HttpStatus.NOT_FOUND);
		}
	}
}
