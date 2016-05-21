package com.lta.flight.scanner.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Quote {
	@XmlAttribute(name = "QuoteId")
	private int quoteId;
	
	@XmlAttribute(name = "MinPrice")
	private int minPrice;
	
	

}
