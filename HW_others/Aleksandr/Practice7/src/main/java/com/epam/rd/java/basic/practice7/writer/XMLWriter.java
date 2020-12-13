package com.epam.rd.java.basic.practice7.writer;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.epam.rd.java.basic.practice7.dto.People;
import com.epam.rd.java.basic.practice7.dto.Person;

public class XMLWriter {

	public void write(List<Person> objects, String parserType) throws JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(People.class);
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		File file = new File("output." + parserType.toLowerCase() + ".xml");
		People people = new People();
		people.setPerson(objects);
		marshallerObj.marshal(people, file);
	}

}
