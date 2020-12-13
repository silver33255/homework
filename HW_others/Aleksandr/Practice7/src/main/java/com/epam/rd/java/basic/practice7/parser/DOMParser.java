package com.epam.rd.java.basic.practice7.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.epam.rd.java.basic.practice7.dto.Person;
import com.epam.rd.java.basic.practice7.dto.Pet;
import com.epam.rd.java.basic.practice7.dto.Pets;
import com.epam.rd.java.basic.practice7.validator.XMLValidator;


public class DOMParser implements Parser {

	private Document getDOMDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //NOSONAR
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		DocumentBuilder builder = factory.newDocumentBuilder();
		return  builder.parse(new InputSource(filename));
	}

	public List<Person> parseXML(String filename) throws ParserConfigurationException, SAXException, IOException { //NOSONAR
		if (!XMLValidator.validateXMLSchema("input.xsd", filename)) {
			return new ArrayList<>();
		}
		List<Person> result = new ArrayList<>();
		Document document = getDOMDocument(filename);
		NodeList people = document.getElementsByTagName("person");
		for (int i = 0; i < people.getLength(); i++) {
			Node node = people.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				NodeList nameNodes = element.getChildNodes();
				int id = -1;
				String name = "";
				String gender = "";
				Pets pets = new Pets();
				for (int j = 0; j < nameNodes.getLength(); j++) {
					Node innerNode = nameNodes.item(j);
					if (innerNode.getNodeType() == Node.ELEMENT_NODE) {
						//get element of each person
						Element elem = (Element) innerNode;
						if (innerNode.getNodeName().equals("name")) {
							name = elem.getTextContent();
						} else if (innerNode.getNodeName().equals("id")) {
							id = Integer.parseInt(elem.getTextContent());
						} else if (innerNode.getNodeName().equals("gender")) {
							gender = elem.getTextContent();
						} else if (innerNode.getNodeName().equals("pets")) {
							//get all pets of person
							NodeList petsNode = innerNode.getChildNodes();
							for (int k = 0; k < petsNode.getLength(); k++) {
								Node petNode = petsNode.item(k);
								if (petNode.getNodeType() == Node.ELEMENT_NODE) {
									//get pets tag
									Element petElem = (Element) petNode;
									NodeList petElemNodes = petElem.getChildNodes();
									String petName = "";
									int petId = -1;
									int petAge = -1;
									for (int l = 0; l < petElemNodes.getLength(); l++) {
										Node innerPetNode = petElemNodes.item(l);
										if (innerPetNode.getNodeType() == Node.ELEMENT_NODE) {
											//get particular pet 
											Element innerPetElem = (Element) innerPetNode;
											if (innerPetElem.getNodeName().equals("pet-name")) {
												petName = innerPetElem.getTextContent();
											} else if (innerPetNode.getNodeName().equals("pet-id")) {
												petId = Integer.parseInt(innerPetElem.getTextContent());
											} else if (innerPetNode.getNodeName().equals("pet-age")) {
												petAge = Integer.parseInt(innerPetElem.getTextContent());
											}
										}
									}
									//add a new pet to list
									pets.getPet().add(new Pet(petId, petAge, petName));
								}
							}
						}
					}
				}
				//create a new person with parsed parameters
				result.add(new Person(id, name, gender, pets));
			}
		}
		return result;
	}
}
