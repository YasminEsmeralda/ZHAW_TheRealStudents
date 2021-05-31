package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Diary")
@Table(name = "diary")
public class Diary extends Application{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_id")
	private Application application;
	
	public Diary() {
		super();
	}
	
	public Diary(String name, Application application) {
		super(name);
		this.application = application;
	}

}
