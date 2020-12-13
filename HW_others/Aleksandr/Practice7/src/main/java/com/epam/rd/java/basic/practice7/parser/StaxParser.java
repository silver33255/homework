package com.epam.rd.java.basic.practice7.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.epam.rd.java.basic.practice7.dto.Person;
import com.epam.rd.java.basic.practice7.dto.Pet;
import com.epam.rd.java.basic.practice7.dto.Pets;

public class StaxParser implements Parser {

	private static Logger logger = Logger.getLogger(StaxParser.class.getName());
	
	private static final String PERSON = "person";
	private static final String PETS = "pets";
	private static final String PET = "pet";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String GENDER = "gender";
	private static final String PET_ID = "pet-id";
	private static final String PET_NAME = "pet-name";
	private static final String PET_AGE = "pet-age";

	private List<Person> people = new ArrayList<>();

	public List<Person> parseXML(String path) {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance(); //NOSONAR
		xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		try {
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
			while (reader.hasNext()) {
				XMLEvent nextEvent = reader.nextEvent();
				if (nextEvent.isStartElement()) {
					StartElement startElement = nextEvent.asStartElement();
					switch (startElement.getName().getLocalPart()) {
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
					case ID:
						nextEvent = reader.nextEvent();
						latestPerson().setId(Integer.parseInt(nextEvent.asCharacters().getData()));
						break;
					case NAME:
						nextEvent = reader.nextEvent();
						latestPerson().setName(nextEvent.asCharacters().getData());
						break;
					case GENDER:
						nextEvent = reader.nextEvent();
						latestPerson().setGender(nextEvent.asCharacters().getData());
						break;
					case PET_ID:
						nextEvent = reader.nextEvent();
						latestPetOfPerson().setId(Integer.parseInt(nextEvent.asCharacters().getData()));
						break;
					case PET_NAME:
						nextEvent = reader.nextEvent();
						latestPetOfPerson().setName(nextEvent.asCharacters().getData());
						break;
					case PET_AGE:
						nextEvent = reader.nextEvent();
						latestPetOfPerson().setAge(Integer.parseInt(nextEvent.asCharacters().getData()));
						break;
					default:
						break;
					}
				}
			}
		} catch (XMLStreamException xse) {
			logger.severe(xse.getMessage());
		} catch (FileNotFoundException fnfe) {
			logger.severe(fnfe.getMessage());
		}
		return people;
	}

	private Person latestPerson() {
		return this.people.get(this.people.size() - 1);
	}

	private Pet latestPetOfPerson() {
		return this.latestPerson().getPets().getPet().get(this.latestPerson().getPets().getPet().size() - 1);
	}

}
