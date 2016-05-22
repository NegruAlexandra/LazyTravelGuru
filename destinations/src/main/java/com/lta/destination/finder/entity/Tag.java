package com.lta.destination.finder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Table
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	
	private String name;

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
