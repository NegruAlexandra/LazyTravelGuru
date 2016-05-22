package com.lta.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lta.user.entity.Tag;
import com.lta.user.entity.User;
import com.lta.user.entity.UserProfile;

@Dependent
public class UsersController {

	@PersistenceContext
	private EntityManager em;

	public void createTestData() {
		String tags = "seaside,sunny,beach,sand,summer,winter,spring,autumn,nature,sports,food,culture,museum,love,holiday,snow,tourism,cold,cruiseship,monuments,rainy,hot,cars,relax,roadtrip,ocean,island,zoo,tropical,safari,park,country_side,architecture,lake,river,vulcano,swimming,shopping,history,clubbing,music,motorbike,games,forest,jungle,camping,luxury,water_activities,chill,adventure,romance,bicycle,festival,traditions,city_break,europe,asia,africa,north_america,south_america,oceania,mountains,church,drinks,aurora_borealis,coffee,theme_park,monarchy,science,bussines,casino,mythology,wild";
		String[] splitTags = tags.split(",");

		for (String t : splitTags) {
			Tag tag = new Tag();
			tag.setName(t);
			em.persist(tag);
		}
		em.flush();
		User user = new User();
		user.setEmail("test@email.com");
		user.setUsername("Lee M. Cardholder");
		UserProfile profile = new UserProfile();
		profile.setAge(25);
		profile.setGender("Male");
		profile.setPriceRange(200d);
		user.setProfile(profile);
		List<Tag> tagList = new ArrayList<>();
		tagList.add((Tag) em.createNamedQuery(Tag.BY_NAME).setParameter("tName", "culture").getSingleResult());
		tagList.add((Tag) em.createNamedQuery(Tag.BY_NAME).setParameter("tName", "food").getSingleResult());
		tagList.add((Tag) em.createNamedQuery(Tag.BY_NAME).setParameter("tName", "love").getSingleResult());
		tagList.add((Tag) em.createNamedQuery(Tag.BY_NAME).setParameter("tName", "history").getSingleResult());
		profile.setTags(tagList);
		em.persist(user);
	}

	public UserProfile getProfile() {
		User user = (User) em.createNamedQuery(User.BY_ID).setParameter("uid", 1).getSingleResult();
		return user.getProfile();
	}

	public Response getTickets() {
		Client client = ClientBuilder.newClient();
		UserProfile profile = getProfile();
		Response getDestinations = client.target("http://localhost:8080/destinations/df")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(profile.getTags(), MediaType.APPLICATION_JSON), Response.class);
		
		return getDestinations;
	}
}
