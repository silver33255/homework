package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.entity.Account;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.entity.Valet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Currency;

import static com.epam.rd.java.basic.practice7.constants.Paths.FEATURE_TURN_SCHEMA_VALIDATION_ON;
import static com.epam.rd.java.basic.practice7.constants.Paths.FEATURE_TURN_VALIDATION_ON;
import static com.epam.rd.java.basic.practice7.constants.Xml.ACCOUNT;
import static com.epam.rd.java.basic.practice7.constants.Xml.VALET;

public class DomController {
    private final String xmlFileName;
    private Bank bank;
    private static final DocumentBuilderFactory FACTORY = DocumentBuilderFactory.newInstance();

    public DomController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse(boolean isValid) throws SAXException, ParserConfigurationException, IOException {
        FACTORY.setNamespaceAware(true);

        if (isValid) {
            FACTORY.setFeature(FEATURE_TURN_VALIDATION_ON, true);
            FACTORY.setFeature(FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        bank = new Bank();
        Document document = FACTORY.newDocumentBuilder().parse(xmlFileName);
        Element root = document.getDocumentElement();

        NodeList accountList = root.getElementsByTagName(ACCOUNT);
        for (int i = 0; i < accountList.getLength(); i++) {
            Node accountNode = accountList.item(i);
            bank.addAccount(getAccount(accountNode));
        }
    }

    public Bank getBank() {
        return bank;
    }

    private Account getAccount(Node accountNode) {
        Account account = new Account();
        NodeList childNodes = accountNode.getChildNodes();
        String[] content = getInnerTagContent(childNodes, 4);

        account.setName(content[0]);
        account.setId(Integer.parseInt(content[1]));
        account.setDepositor(content[2]);
        account.setCountry(content[3]);
        addValetsIfExist(account, childNodes);

        return account;
    }

    private void addValetsIfExist(Account account, NodeList nodes) {
        Node node;

        for (int i = 0; i < nodes.getLength(); i++) {
            node = nodes.item(i);
            if (VALET.equals(node.getNodeName())) {
                account.addValet(getValet(node));
            }
        }
    }

    private Valet getValet(Node valetNode) {
        Valet valet = new Valet();
        NodeList childNodes = valetNode.getChildNodes();
        String[] content = getInnerTagContent(childNodes, 5);

        valet.setType(Valet.Type.valueOf(content[0]));
        valet.setAmount(Integer.parseInt(content[1]));
        valet.setCurrency(Currency.getInstance(content[2]));
        valet.setAnnualPercentage(Short.parseShort(content[3]));
        valet.setDepositTerm(LocalDateTime.parse(content[4]));

        return valet;
    }

    private String[] getInnerTagContent(NodeList nodes, int quantity) {
        Node node;
        String[] content = new String[quantity];
        int j = 0;

        for (int i = 0; i < nodes.getLength() && j < quantity; i++) {
            node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                content[j] = node.getChildNodes().item(0).getTextContent();
                j++;
            }
        }

        return content;
    }
}
