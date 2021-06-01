package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Workout")
@Table(name = "workout")
public class Workout extends Application{
	
	public Workout() {
		super();
	}

	public Workout(String name, String sponsor) {
		super(name, sponsor);
	}
}
