package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.controller.DomController;
import com.epam.rd.java.basic.practice7.controller.SaxController;
import com.epam.rd.java.basic.practice7.controller.StaxController;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.util.Sorter;
import com.epam.rd.java.basic.practice7.util.Writer;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.epam.rd.java.basic.practice7.constants.Paths.*;

public final class Main {
    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(final String... args) {
        parseSax(args[0]);
        parseStax(args[0]);
        parseDom(args[0]);
    }

    private static void parseSax(String fileName) {
        Bank bank;
        SaxController saxController = new SaxController(fileName);

        try {
            saxController.parse(true);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
        bank = saxController.getBank();

        Sorter.sortValetsByAmount(bank);
        saveToXml(bank, SAX_OUTPUT_FILE_NAME);
    }

    private static void parseStax(String fileName) {
        Bank bank;
        StaxController staxController = new StaxController(fileName);

        try {
            staxController.parse();
        } catch (IOException | XMLStreamException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
        bank = staxController.getBank();

        Sorter.sortAccountsByDepositor(bank);
        saveToXml(bank, STAX_OUTPUT_FILE_NAME);
    }

    private static void parseDom(String fileName) {
        Bank bank;
        DomController domController = new DomController(fileName);

        try {
            domController.parse(true);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
        bank = domController.getBank();

        Sorter.sortAccountsById(bank);
        saveToXml(bank, DOM_OUTPUT_FILE_NAME);
    }

    private static void saveToXml(Bank bank, String fileName) {
        try {
            Writer.saveToXML(bank, fileName);
        } catch (ParserConfigurationException | TransformerException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }
}
