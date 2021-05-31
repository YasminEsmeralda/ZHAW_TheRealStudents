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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_id")
	private Application application;
	
    @ManyToMany(targetEntity=Coach.class)  
    private List<Coach> coachs = new ArrayList<Coach>(); 
	
	public LiveSession() {
		super();
	}

	public LiveSession(String name, Application application, List<Coach> coachs) {
		super(name);
		this.application = application;
		this.coachs = coachs;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<Coach> getCoach() {
		return this.coachs;
	}

	public void setCoach(List<Coach> coachs) {
		this.coachs = coachs;
	}
}
