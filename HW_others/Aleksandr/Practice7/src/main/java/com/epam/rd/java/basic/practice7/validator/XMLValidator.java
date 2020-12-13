package com.epam.rd.java.basic.practice7.validator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {

	private static Logger logger = Logger.getLogger(XMLValidator.class.getName());
	
	private XMLValidator() {}
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //NOSONAR
			factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); 
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();  //NOSONAR
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			logger.severe(e.getMessage());
			return false;
		}
		return true;
	}

}
