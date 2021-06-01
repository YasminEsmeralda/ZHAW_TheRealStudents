package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Customer;
import ch.zhaw.springboot.repositories.CustomerRepository;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repository;

	@RequestMapping(value = "healthily/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
	}
}
