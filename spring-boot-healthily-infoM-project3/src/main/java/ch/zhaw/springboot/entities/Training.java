package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Training")
@Table(name = "training")
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String duration;
	private int level;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	public Training() {
	}

	public Training(String duration, int level, Workout workout) {
		this.duration = duration;
		this.level = level;
		this.workout = workout;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Workout getWorkout() {
		return this.workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

}
