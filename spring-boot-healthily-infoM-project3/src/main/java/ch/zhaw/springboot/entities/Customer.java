package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer extends User {
	
	private String goal;
	private String insurance;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_id")
	private Application application;
	
	public Customer() {
		super();
	}

	public Customer(String name, int age, String gender, String goal, String insurance) {
		super(name, age, gender);
		this.goal = goal;
		this.insurance = insurance;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
