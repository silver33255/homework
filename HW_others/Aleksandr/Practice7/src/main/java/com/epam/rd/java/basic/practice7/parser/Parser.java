package com.epam.rd.java.basic.practice7.parser;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.epam.rd.java.basic.practice7.dto.Person;

public interface Parser {

	public List<Person> parseXML(String filename) throws ParserConfigurationException, SAXException, IOException;
	
}
