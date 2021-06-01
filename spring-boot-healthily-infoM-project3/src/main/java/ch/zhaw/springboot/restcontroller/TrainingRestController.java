package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Training;
import ch.zhaw.springboot.repositories.TrainingRepository;

@RestController
public class TrainingRestController {
	
	@Autowired
	private TrainingRepository repository;

	@RequestMapping(value = "healthily/workouts/trainings", method = RequestMethod.GET)
	public ResponseEntity<List<Training>> getAllTrainings() {
		List<Training> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Training>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Training>>(HttpStatus.NOT_FOUND);
		}
	}
}
