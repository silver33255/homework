package com.epam.rd.java.basic.practice7;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.epam.rd.java.basic.practice7.dto.Person;
import com.epam.rd.java.basic.practice7.parser.DOMParser;
import com.epam.rd.java.basic.practice7.parser.Parser;
import com.epam.rd.java.basic.practice7.parser.SaxParser;
import com.epam.rd.java.basic.practice7.parser.StaxParser;
import com.epam.rd.java.basic.practice7.validator.XMLValidator;
import com.epam.rd.java.basic.practice7.writer.XMLWriter;

public final class Main {

	private static final String FILENAME = "input.xsd";
	
    public static void main(final String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {
    	XMLWriter writer = new XMLWriter();
    	Parser parser = new DOMParser();
    	List<Person> domList = parser.parseXML(args[0]);
    	//sort by gender
    	domList.sort((o1, o2)->o1.getGender().compareTo(o2.getGender()));
    	writer.write(domList, "dom");
    	XMLValidator.validateXMLSchema(FILENAME, "output.dom.xml");
    	
    	
    	parser = new SaxParser();
    	List<Person> saxList = parser.parseXML(args[0]);
    	//sort by name
    	saxList.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
    	writer.write(saxList, "sax");
    	XMLValidator.validateXMLSchema(FILENAME, "output.sax.xml");
    	
    	
    	parser = new StaxParser();
    	List<Person> staxList = parser.parseXML(args[0]);
    	//sort by id
    	staxList.sort((o1, o2)->Integer.compare(o1.getId(), o2.getId()));
    	writer.write(staxList, "stax");
    	XMLValidator.validateXMLSchema(FILENAME, "output.stax.xml");
    }
}
