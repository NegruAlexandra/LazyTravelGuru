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
		List<String> x = new ArrayList<>();
		for (Tag t : tags) {
			x.add(t.getName());
		}
		Query q = em.createNamedQuery(Destination.BY_TAGS).setParameter("preferredTags", x);
		List<Destination> result = q.getResultList();
		return result;
	}

	public void addTestData() {
		//// UNCOMMENT ONLY WHEN USING IT
		String tags = "seaside,sunny,beach,sand,summer,winter,spring,autumn,nature,sports,food,culture,museum,love,holiday,snow,tourism,cold,cruiseship,monuments,rainy,hot,cars,relax,roadtrip,ocean,island,zoo,tropical,safari,park,country_side,architecture,lake,river,vulcano,swimming,shopping,history,clubbing,music,motorbike,games,forest,jungle,camping,luxury,water_activities,chill,adventure,romance,bicycle,festival,traditions,city_break,europe,asia,africa,north_america,south_america,oceania,mountains,church,drinks,aurora_borealis,coffee,theme_park,monarchy,science,bussines,casino,mythology,wild";
		String[] splitTags = tags.split(",");

		for (String t : splitTags) {
			Tag tag = new Tag();
			tag.setName(t);
			em.persist(tag);
		}
		em.flush();

		String destinations = "LAS-VEGAS:LAS:monuments,zoo,shopping,clubbing,north_america,theme_park,casino,games,love;JERUSALEM:VDA:sunny,culture,asia,church,history;BELGRAD:BEG:museum,city_break,science,europe,coffee;TASMANIA:HBA:oceania,summer,nature,rainy,tropical,jungle,adventure;SHANGHAI:SHA:asia,food,culture,clubbing,games,traditions;DUBAI:DWC:asia,water_activities,sunny,summer,museum,shopping,relax,zoo,chill;MIAMI:MIA:seaside,sunny,summer,holiday,cruiseship,ocean,clubbing,water_activities,adventure,south_america;CAPETOWN:CPT:seaside,africa,sunny,culture,tourism,history,traditions;BANGKOK:BKK:asia,sunny,culture,food,clubbing,festival,wild,mountains;MALTA:MLA:seaside,summer,beach,culture,swimming,europe,chill,traditions,holiday,hot;BUENOSAIRES:EZE:food,culture,holiday,tourism,architecture,music,South_america,city_break,bussines;LINZ:LNZ:winter,culture,museum,cold,monuments,cars,roadtrip,park,science,traditions,mountains,bussines;NASSAU:NAS:seaside,sunny,beach,sand,summer,culture,island,holiday,relax,south_america,history,water_activities,ocean,cruise_ship;RIO-DE-JAINERO:GIG:seaside,summer,hot,sand,water_activities,ocean,cruise_ship,south_america,adventure,culture,tropical,swimming,monuments,park;OTTAWA:YOW:winter,noth_america,culture,traditions,museum,cold,mountains;QUITO:UIO:Summer,hot,culture,traditions,coffee,south_america,monuments,shopping,adventure;MANILA:MNL:asia,seaside,sunny,summer,nature,food,culture,museum,holiday,ocean,adventure,wild;HELSINKI:HEL:winter,cold,seaside,culture,museum,history,city_break,europe,science,lake,architecture,mountains;DELHI:DEL:asia,traditions,food,culture,monuments,architecture,music,hot,summer,adventure;KINGSTON:KIN:seaside,summer,hot,relax,chill,water_activities,wild,adventure,camping,ocean,holiday,nature;JAKARTA:CGK:asia,vulcano,island,ocean,seaside,summer,sunny,hot,tropical,jungle,wild,relax,beach,cruise_ship;ANTANANARIVO:TNR:africa,tropical,jungle,camping,zoo,hot,rainy,nature,culture,water_activties,adventure,river,wild;MALE:MLE:asia,ocean,island,chill,relax,seaside,beach,summer,hot,food,culture,traditions,love,romance,wild;AUCKLAND:AKL:oceania,seasidezoo,sunny,culture,museum,cars,island,wild,mountains,camping,adventure,city_break,theme_park,park;CHISINAU:KIV:winter,cold,culture,traditions,roadtrip,music,country_side,monuments,wild,drinks,europe,history;NEW-YORK:JFK:north_america,seaside,ocean,spring,culture,museum,architecture,monuments,cruise_ship,bussines,city_break,luxury;LONDON:LTN:seaside,autumn,spring,food,culture,museum,holiday,tourism,cold,monuments,rainy,relax,ocean,zoo,architecture,shopping,history,clubbing,luxury,chill,bicycle,park,cars,festival,city_break,europe,church,drinks,coffee,monarchy,science,business,casino;MANCHESTER:MAN:spring,autumn,sports,museum,cold,rainy,roadtrip,ocean,country_side,architecture,history,camping,chill,city_break,europe,drinks,monarchy;PARIS:BVA:architecture,business,church,culture,drinks,europe,festival,food,history,holiday,love,luxury,monuments,museum,music,park,relax,romance,science,shopping,theme_park,tourism,traditions,zoo,city_break;ROME:FCO:architecture,beach,church,cruise_ship,culture,europe,food,history,holiday,hot,monumets,museum,music,mythology,science,summer,sunny,spring,tourism;MILAN:BGY:architecture,culture,europe,food,shopping,church,city_break,tourism,sunny,spring,summer;VENICE:TSF:europe,architecture,river,water_activities,love,romance,city_break,tourism,summer,hot;ATHENS:ATH:beach,europe,mythology,monuments,food,culture,spring,summer,autumn;BARCELONA:BCN:beach,europe,architecture,business,church,clubbing,cruise_ship,hot,holiday,luxury,park,shopping,tourism,city_break,summer,sports,seaside,romance,motorbike;VALENCIA:VLC:europe,summer,hot,zoo,seaside,beach,city_break,holiday,monuments,cruise_ship,tourism;AMSTERDAM:AMS:bicycle,europe,spring,rainy,chill,clubbing,cold,drinks,games,museum,music,relax,history,architecture,spring,autumn,city_break,tourism,romance;COPENHAGEN:CPH:bicycle,europe,spring,autumn,theme_park,cold,games,monuments,relax,architecture,city_break,tourism,cruise_ship,seaside,romance;REYKJAVIK:KEF:aurora_borealis,europe,adventure,cold,winter,vulcano,seaside,relax,snow,mountains,nature;BRUSSELS:CRL:europe,monuments,cold,rainy,city_break,tourism,spring,autumn,island,music,winter,ocean;BERLIN:TXL:europe,zoo,festival,monuments,museum,bicycle,clubbing,food,drinks,business,city_break,motorbike;VIENA:VIE:europe,spring,summer,autumn,winter,zoo,europe,museum,bicycle,culture,tourism,shopping,architecture;OSLO:OSL:europe,winter,autumn,cruise_ship,lake,seaside,luxury,cold,monarchy,sports,mountains,snow,rainy;STOCKHOLM:ARN:europe,cold,winter,autumn,culture,science,luxury,monarchy,music,bicycle,snow,lake;DUBROVNIK:DBV:europe,summer,hot,water_activities,history,monuments,city_break,seaside,holiday,chill,tourismtraditions,sunny,nature;SANTORINI:JTR:europe,hot,summer,island,seaside,luxury,food,drinks,sunny,history,culture,chill,architecture,swimming,cruise_ship,sand,beach,romance,mythology,nature;NICOSIA:ECN:europe,spring,autumn,hot,summer,island,seaside,sunny,cruise_ship,chill,water_activities,culture,beach,country_side,relax;ISTANBUL:IST:europe,asia,church,architecture,coffee,cruise_ship,culture,food,history,monuments,seaside,summer,spring;PRAGUE:PRG:europe,architecture,drinks,clubbing,city_break,spring,autumn,holiday,chill,tourism,shopping,romance,zoo;NICE:NCE:europe,seaside,luxury,chill,drinks,cruise_ship,festival,seaside,culture,sand,beach,summer;CATANIA:CTA:europe,vulcano,seaside,island,summer,hot,relax,architecture,food,drinks,luxury,holiday,sunny,swimming;TROMSO:TOS:europe,aurora_borealis,island,cold,sports,snow,mountains,camping,forest,lake,traditions,winter,autumn,adventure,nature;IZMIR:ADB:europe,adventure,traditions,seaside,spring,summer,monuments,hot,chill,coffee,drinks,culture,church,monuments,water_activities,motorbike,clubbing;BUDAPEST:BUD:europe,drinks,clubbing,architecture,spring,summer,city_break,games,roadtrip,river,tourism,bicycle,motorbike,romance,food,church;STRASBOURG:SXB:europe,spring,culture,museum,bussines,festival,roadtrip,zoo,monuments,tourism;KOLN:CGN:europe,architecture,coffee,autumn,sports,cars,games,culture,traditions,festival,music,river;GIBRALTAR:GIB:europe,seaside,sunny,summer,hot,architecture,zoo,festival,music,park,swimming;SALONIC:SKG:europe,mythology,shopping,theme_park,zoo,history,seaside,summer,spring,hot,sunny,culture,traditions,food,tourism;";
		String[] individualDest = destinations.split(";");
		for (String dst : individualDest) {
			List<Tag> tagList = new ArrayList<>();
			String[] splitDst = dst.split(":");
			String[] tags2 = splitDst[2].split(",");
			for (String tag : tags2) {
				Query q = em.createNamedQuery(Tag.BY_NAME).setParameter("tName", tag);
				List<Tag> resultList = q.getResultList();
				if (!resultList.isEmpty()) {
					tagList.add(resultList.get(0));
				}
			}
			Destination d = new Destination();
			d.setName(splitDst[0].replace('-', ' '));
			d.setAirport(splitDst[1]);
			d.setTags(tagList);
			em.persist(d);
		}
	}

}
