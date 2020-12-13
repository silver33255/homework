package com.epam.rd.java.basic.practice7.parser;

import java.io.IOException;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.rd.java.basic.practice7.dto.Person;
import com.epam.rd.java.basic.practice7.handler.SAXHandler;

public class SaxParser implements Parser {

	@Override
	public List<Person> parseXML(String filename) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); //NOSONAR
		SAXParser saxParser = factory.newSAXParser();
		saxParser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		saxParser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		SAXHandler handler = new SAXHandler();
		saxParser.parse("input.xml", handler);
		return handler.getResult();
	}

}
