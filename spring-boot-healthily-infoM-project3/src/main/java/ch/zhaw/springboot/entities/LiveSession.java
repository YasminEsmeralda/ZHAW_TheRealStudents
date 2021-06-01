package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "LiveSession")
@Table(name = "liveSession")
public class LiveSession extends Application{
	
    @ManyToMany(targetEntity=Coach.class)  
    private List<Coach> coaches;
	
	public LiveSession() {
		super();
		this.coaches = new ArrayList<Coach>(); 
	}

	public LiveSession(String name, List<Coach> coaches) {
		super(name);
		this.coaches = coaches;
		this.coaches = new ArrayList<Coach>(); 
	}

	public List<Coach> getCoach() {
		return this.coaches;
	}

	public void setCoach(List<Coach> coaches) {
		this.coaches = coaches;
	}
}
