package com.swamy.documents;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Job-Hire")
public class JobPost {
	@Id
	private String id;
	private String role;
	private String companyName;
	private String skills[];
	private long salary;
	private Integer experience;
	public JobPost() {
		super();
	}
	public JobPost(String id, String role, String companyName, String[] skills, long salary,Integer experience) {
		super();
		this.id = id;
		this.role = role;
		this.companyName = companyName;
		this.skills = skills;
		this.salary = salary;
		this.experience=experience;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "JobPost [id=" + id + ", role=" + role + ", companyName=" + companyName + ", skills="
				+ Arrays.toString(skills) + ", salary=" + salary + ", experience=" + experience + "]";
	}
	

}
