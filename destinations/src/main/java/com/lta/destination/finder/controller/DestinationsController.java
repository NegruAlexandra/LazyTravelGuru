package com.lta.destination.finder.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lta.destination.finder.entity.Destination;
import com.lta.destination.finder.entity.Tag;

@Dependent
public class DestinationsController {

	@PersistenceContext
	private EntityManager em;

	public List<Destination> findDestinationsForTags(List<Tag> tags) {
		List<Long> x = new ArrayList<>();
		for (Tag t : tags) {
			x.add(t.getId());
		}
		Query q = em.createNamedQuery(Destination.BY_TAGS).setParameter("preferredTags", x);
		List resultList = q.getResultList();
		return resultList;
	}

	public void addTestData() {
		List<Tag> tags = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Tag tag = new Tag();
			tag.setName("Tag " + i);
			tags.add(tag);
			em.persist(tag);
		}

		em.flush();
		{
			List<Tag> t = new ArrayList<>();
			t.add(tags.get(1));
			t.add(tags.get(5));
			Destination d1 = new Destination();
			d1.setName("Destination 1");
			d1.setTags(t);
			em.persist(d1);
		}
		{
			List<Tag> t = new ArrayList<>();
			t.add(tags.get(1));
			t.add(tags.get(5));
			t.add(tags.get(8));
			t.add(tags.get(3));
			Destination d1 = new Destination();
			d1.setName("Destination 2");
			d1.setTags(t);
			em.persist(d1);
		}
		{
			List<Tag> t = new ArrayList<>();
			t.add(tags.get(2));
			t.add(tags.get(7));
			t.add(tags.get(9));
			t.add(tags.get(4));
			Destination d1 = new Destination();
			d1.setName("Destination 3");
			d1.setTags(t);
			em.persist(d1);
		}
		{
			List<Tag> t = new ArrayList<>();
			t.add(tags.get(1));
			t.add(tags.get(5));
			t.add(tags.get(7));
			t.add(tags.get(9));
			Destination d1 = new Destination();
			d1.setName("Destination 4");
			d1.setTags(t);
			em.persist(d1);
		}
		{
			List<Tag> t = new ArrayList<>();
			t.add(tags.get(6));
			t.add(tags.get(7));
			Destination d1 = new Destination();
			d1.setName("Destination 5");
			d1.setTags(t);
			em.persist(d1);
		}
	}

}
