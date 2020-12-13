package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.entity.Account;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.entity.Valet;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Currency;

import static com.epam.rd.java.basic.practice7.constants.Xml.*;

public class StaxController {
    private final String xmlFileName;
    private Bank bank;
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    public StaxController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse() throws IOException, XMLStreamException {
        XMLEventReader reader = FACTORY.createXMLEventReader(new FileInputStream(xmlFileName));
        Account tempAccount = new Account();
        Valet tempValet = new Valet();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case BANK:
                        bank = new Bank();
                        break;
                    case ACCOUNT:
                        tempAccount = new Account();
                        break;
                    case VALET:
                        tempValet = new Valet();
                        break;
                    case NAME:
                        nextEvent = reader.nextEvent();
                        tempAccount.setName(nextEvent.asCharacters().getData());
                        break;
                    case ID:
                        nextEvent = reader.nextEvent();
                        tempAccount.setId(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case DEPOSITOR:
                        nextEvent = reader.nextEvent();
                        tempAccount.setDepositor(nextEvent.asCharacters().getData());
                        break;
                    case COUNTRY:
                        nextEvent = reader.nextEvent();
                        tempAccount.setCountry(nextEvent.asCharacters().getData());
                        break;
                    case TYPE:
                        nextEvent = reader.nextEvent();
                        tempValet.setType(Valet.Type.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case AMOUNT:
                        nextEvent = reader.nextEvent();
                        tempValet.setAmount(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case CURRENCY:
                        nextEvent = reader.nextEvent();
                        tempValet.setCurrency(Currency.getInstance(nextEvent.asCharacters().getData()));
                        break;
                    case ANNUAL_PERCENTAGE:
                        nextEvent = reader.nextEvent();
                        tempValet.setAnnualPercentage(Short.parseShort(nextEvent.asCharacters().getData()));
                        break;
                    case DEPOSIT_TERM:
                        nextEvent = reader.nextEvent();
                        tempValet.setDepositTerm(LocalDateTime.parse(nextEvent.asCharacters().getData()));
                        break;
                    default:
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                switch (endElement.getName().getLocalPart()) {
                    case VALET:
                        tempAccount.addValet(tempValet);
                        break;
                    case ACCOUNT:
                        bank.addAccount(tempAccount);
                        break;
                    default:
                }
            }
        }
    }

    public Bank getBank() {
        return bank;
    }
}
