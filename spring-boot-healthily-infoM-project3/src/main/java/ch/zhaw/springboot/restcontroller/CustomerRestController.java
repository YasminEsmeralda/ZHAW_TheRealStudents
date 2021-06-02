package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Customer;
import ch.zhaw.springboot.entities.Training;
import ch.zhaw.springboot.entities.Workout;
import ch.zhaw.springboot.repositories.CustomerRepository;
import ch.zhaw.springboot.repositories.TrainingRepository;
import ch.zhaw.springboot.repositories.WorkoutRepository;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private TrainingRepository trainingRepository;

	@RequestMapping(value = "healthily/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "healthily/customers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getPersonById(@PathVariable("id")long id) {
		Optional<Customer> result = this.repository.findById(id);
		
		if (result.isEmpty()) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(result.get(), HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "healthily/customer/customer={id}/workouts/trainings/level={level}", method = RequestMethod.GET)
	public ResponseEntity<List<Training>> getTrainingsByCustomerLevel(@PathVariable("id") long id, @PathVariable("level") int level){		
		List<Training> result = this.trainingRepository.getTrainingsByCustomerLevel(id, level);
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Training>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Training>>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@RequestMapping(value = "expenses/persons/{id}/{category}", method = RequestMethod.GET)
//	public ResponseEntity<Double> getTotalExpenseByCategory(@PathVariable("id") long id, @PathVariable("category") String category) {
//		Optional<Person> person = this.repository.findById(id);
//		
//		if (person.isEmpty()) {
//			return new ResponseEntity<Double>(HttpStatus.NOT_FOUND);
//		}
//		
//		if (this.repositoryExpense.countByCategory(category) < 1) {
//			return new ResponseEntity<Double>(HttpStatus.NOT_FOUND);
//		}
//		
//		double result = person.get().getTotalExpensesPerCategory(category);
//		return new ResponseEntity<Double>(result, HttpStatus.OK);
//	}
	
}
