package com.epam.rd.java.basic.practice7.example;

import com.epam.rd.java.basic.practice7.example.controller.DOMController;
import com.epam.rd.java.basic.practice7.example.controller.SAXController;
import com.epam.rd.java.basic.practice7.example.controller.STAXController;
import com.epam.rd.java.basic.practice7.example.entity.Test;
import com.epam.rd.java.basic.practice7.example.util.Sorter;

/**
 * Entry point for practice 7 (simple version).
 * @author D.Kolesnikov
 *
 */
public class Main {
	public static void usage() {
		System.out.println("java ua.nure.kolesnikov.practice7.Main xmlFileName");
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			usage();
			return;
		}
		
		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);
		
		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////
		
		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Test test = domController.getTest();

		// sort (case 1)
		Sorter.sortQuestionsByQuestionText(test);
		
		// save
		String outputXmlFile = "output.dom.xml";
		DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////
		
		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		test = saxController.getTest();
		
		// sort  (case 2)
		Sorter.sortQuestionsByAnswersNumber(test);
		
		// save
		outputXmlFile = "output.sax.xml";
		
		// other way: 
		DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
		
		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////
		
		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		test = staxController.getTest();
		
		// sort  (case 3)
		Sorter.sortAnswersByContent(test);
		
		// save
		outputXmlFile = "output.stax.xml";
		DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}

}