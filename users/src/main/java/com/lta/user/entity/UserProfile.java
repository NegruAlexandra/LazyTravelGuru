package com.lta.user.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserProfile {

	@Id
	private Long id;
	private String name;
	
	@ManyToMany
	List<Tag> tags;
	
	private String gender;
	private String interests;
	private int age;
	private double priceRange;
	private String timeYear; // spring,summer,autumn,winter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(double priceRange) {
		this.priceRange = priceRange;
	}

	public String getTimeYear() {
		return timeYear;
	}

	public void setTimeYear(String timeYear) {
		this.timeYear = timeYear;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
