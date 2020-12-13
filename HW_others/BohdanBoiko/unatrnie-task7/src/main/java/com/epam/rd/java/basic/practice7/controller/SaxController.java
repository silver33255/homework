package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.entity.Account;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.entity.Valet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Currency;

import static com.epam.rd.java.basic.practice7.constants.Paths.FEATURE_TURN_SCHEMA_VALIDATION_ON;
import static com.epam.rd.java.basic.practice7.constants.Paths.FEATURE_TURN_VALIDATION_ON;
import static com.epam.rd.java.basic.practice7.constants.Xml.*;

public class SaxController {
    private final String xmlFileName;
    private Bank bank;
    private static final SAXParserFactory FACTORY = SAXParserFactory.newInstance();

    public SaxController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse(boolean isValid) throws SAXException, ParserConfigurationException, IOException {
        FACTORY.setNamespaceAware(true);

        if (isValid) {
            FACTORY.setFeature(FEATURE_TURN_VALIDATION_ON, true);
            FACTORY.setFeature(FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser parser = FACTORY.newSAXParser();
        parser.parse(xmlFileName, new XmlHandler());
    }

    public Bank getBank() {
        return bank;
    }

    public class XmlHandler extends DefaultHandler {
        private String lastElementName;
        private Account tempAccount;
        private Valet tempValet;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (BANK.equals(qName)) {
                bank = new Bank();
            }
            if (ACCOUNT.equals(qName)) {
                tempAccount = new Account();
            }
            if (VALET.equals(qName)) {
                tempValet = new Valet();
            }
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (VALET.equals(qName)) {
                tempAccount.addValet(tempValet);
            }
            if (ACCOUNT.equals(qName)) {
                bank.addAccount(tempAccount);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);

            if (content.isEmpty()) {
                return;
            }

            switch (lastElementName) {
                case NAME:
                    tempAccount.setName(content);
                    break;
                case ID:
                    tempAccount.setId(Integer.parseInt(content));
                    break;
                case DEPOSITOR:
                    tempAccount.setDepositor(lastElementName);
                    break;
                case COUNTRY:
                    tempAccount.setCountry(content);
                    break;
                case TYPE:
                    tempValet.setType(Valet.Type.valueOf(content));
                    break;
                case AMOUNT:
                    tempValet.setAmount(Integer.parseInt(content));
                    break;
                case CURRENCY:
                    tempValet.setCurrency(Currency.getInstance(content));
                    break;
                case ANNUAL_PERCENTAGE:
                    tempValet.setAnnualPercentage(Short.parseShort(content));
                    break;
                case DEPOSIT_TERM:
                    tempValet.setDepositTerm(LocalDateTime.parse(content));
                    break;
                default:
            }
        }
    }
}
