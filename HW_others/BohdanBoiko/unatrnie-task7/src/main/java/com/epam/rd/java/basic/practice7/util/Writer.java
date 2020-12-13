package com.epam.rd.java.basic.practice7.util;

import com.epam.rd.java.basic.practice7.entity.Account;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.entity.Valet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.epam.rd.java.basic.practice7.constants.Xml.*;

public class Writer {
    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
    private static final TransformerFactory TRANSFORMER_FACTORY = TransformerFactory.newInstance();

    static {
        DOCUMENT_BUILDER_FACTORY.setNamespaceAware(true);
    }

    private Writer() {
    }

    public static void saveToXML(Bank bank, String xmlFileName) throws ParserConfigurationException, TransformerException {
        Document document = getDocument(bank);
        StreamResult result = new StreamResult(new File(xmlFileName));

        Transformer transformer = TRANSFORMER_FACTORY.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(INDENT_AMOUNT_OUTPUT_KEY, "4");
        transformer.transform(new DOMSource(document), result);
    }

    private static Document getDocument(Bank bank) throws ParserConfigurationException {
        Document document = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder().newDocument();

        Element bankElement = document.createElement(BANK);
        bankElement.setAttribute(XMLNS_XSI.getName(), XMLNS_XSI.getValue());
        bankElement.setAttribute(XMLNS_BANK.getName(), XMLNS_BANK.getValue());
        bankElement.setAttribute(XSI_NO_SCHEMA_LOCATION.getName(), XSI_NO_SCHEMA_LOCATION.getValue());
        document.appendChild(bankElement);

        setAccounts(bankElement, bank.getAccounts(), document);

        return document;
    }

    private static void setAccounts(Element bankElement, List<Account> accounts, Document document) {
        for (Account account : accounts) {
            Element accountElement = document.createElement(ACCOUNT);
            bankElement.appendChild(accountElement);

            Element nameElement = document.createElement(NAME);
            nameElement.setTextContent(account.getName());
            accountElement.appendChild(nameElement);

            Element idElement = document.createElement(ID);
            idElement.setTextContent(account.getId().toString());
            accountElement.appendChild(idElement);

            Element depositorElement = document.createElement(DEPOSITOR);
            depositorElement.setTextContent(account.getDepositor());
            accountElement.appendChild(depositorElement);

            Element countryElement = document.createElement(COUNTRY);
            countryElement.setTextContent(account.getCountry());
            accountElement.appendChild(countryElement);

            setValets(accountElement, account.getValets(), document);
        }
    }

    private static void setValets(Element accountElement, List<Valet> valets, Document document) {
        for (Valet valet : valets) {
            Element valetElement = document.createElement(VALET);
            accountElement.appendChild(valetElement);

            Element typeElement = document.createElement(TYPE);
            typeElement.setTextContent(valet.getType().name());
            valetElement.appendChild(typeElement);

            Element amountElement = document.createElement(AMOUNT);
            amountElement.setTextContent(valet.getAmount().toString());
            valetElement.appendChild(amountElement);

            Element currencyElement = document.createElement(CURRENCY);
            currencyElement.setTextContent(valet.getCurrency().getCurrencyCode());
            valetElement.appendChild(currencyElement);

            Element annualPercentageElement = document.createElement(ANNUAL_PERCENTAGE);
            annualPercentageElement.setTextContent(valet.getAnnualPercentage().toString());
            valetElement.appendChild(annualPercentageElement);

            Element depositTermElement = document.createElement(DEPOSIT_TERM);
            depositTermElement.setTextContent(valet.getDepositTerm().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            valetElement.appendChild(depositTermElement);
        }
    }
}
