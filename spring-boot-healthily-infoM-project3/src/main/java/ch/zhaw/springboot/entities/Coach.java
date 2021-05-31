package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Coach")
@Table(name = "coach")
public class Coach extends User{
	
	private String subjectArea;
	private int experience;
	
    @ManyToMany(targetEntity=LiveSession.class)  
    private List<LiveSession> liveSessions = new ArrayList<LiveSession>();  
	
	public Coach() {
		super();
	}
	
	public Coach(String name, int age, String gender, String subjectArea, int experience, List<LiveSession> liveSessions) {
		super(name, age, gender);
		this.subjectArea = subjectArea;
		this.experience = experience;
		this.liveSessions = liveSessions;
	}

	public String getSubjectArea() {
		return this.subjectArea;
	}
	
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<LiveSession> getLiveSession() {
		return this.liveSessions;
	}

	public void setLiveSession(List<LiveSession> liveSessions) {
		this.liveSessions = liveSessions;
	}
}
