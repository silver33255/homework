package com.epam.rd.java.basic.practice7.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.rd.java.basic.practice7.dto.Person;
import com.epam.rd.java.basic.practice7.dto.Pet;
import com.epam.rd.java.basic.practice7.dto.Pets;

public class SAXHandler extends DefaultHandler {

	private static final String PERSON = "person";
	private static final String PETS = "pets";
	private static final String PET = "pet";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String GENDER = "gender";
	private static final String PET_ID = "pet-id";
	private static final String PET_NAME = "pet-name";
	private static final String PET_AGE = "pet-age";

	private List<Person> people;
	private String elementValue;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue = new String(ch, start, length);
	}

	@Override
	public void startDocument() throws SAXException {
		people = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case PERSON:
			people.add(new Person());
			break;
		case PETS:
			latestPerson().setPets(new Pets());
			latestPerson().getPets().setPet(new ArrayList<>());
			break;
		case PET:
			latestPerson().getPets().getPet().add(new Pet());
			break;
		default:
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case ID:
			latestPerson().setId(Integer.parseInt(elementValue));
			break;
		case NAME:
			latestPerson().setName(elementValue);
			break;
		case GENDER:
			latestPerson().setGender(elementValue);
			break;
		case PET_ID:
			latestPetOfPerson().setId(Integer.parseInt(elementValue));
			break;
		case PET_NAME:
			latestPetOfPerson().setName(elementValue);
			break;
		case PET_AGE:
			latestPetOfPerson().setAge(Integer.parseInt(elementValue));
			break;
		default:

			break;
		}
	}

	private Person latestPerson() {
		return this.people.get(this.people.size() - 1);
	}

	private Pet latestPetOfPerson() {
		return this.latestPerson().getPets().getPet().get(this.latestPerson().getPets().getPet().size() - 1);
	}

	public List<Person> getResult() {
		return this.people;
	}

}
