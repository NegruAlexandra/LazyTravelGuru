package com.lta.destination.finder.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Table
@NamedQueries({
		@NamedQuery(name = Destination.BY_TAGS, query = "SELECT DISTINCT d FROM Destination d, (SELECT COUNT(t.id) cnt, dst.id FROM Destination dst, Tag t WHERE t IN (dst.tags) and t.id IN :preferredTags GROUP BY dst.id) c WHERE c.id = d.id ORDER BY c.cnt DESC") })
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Destination {

	public transient static final String BY_TAGS = "byTags";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany
	private List<Tag> tags;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
