package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

class AttrValueParser extends Parser {
    public AttrValueParser(String attributePrefix, Node document) {
        super("", attributePrefix, document);
    }

    @Override
    public void parse(List<Parameter> parameters) {
        Document doc = (Document) document;
        parseNodes(doc.getDocumentElement(), parameters);
    }

    private void parseNodes(Node node, List<Parameter> parameters) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            processAttributes(node.getAttributes(), parameters);

            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                parseNodes(childNodes.item(i), parameters);
            }
        }
    }

    private void processAttributes(NamedNodeMap attributes, List<Parameter> parameters) {
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attribute = (Attr) attributes.item(i);
            String value = attribute.getValue();
            if (value.matches("\\$\\{.+}")) {
                for (Parameter p : parameters) {
                    if (p.getName().equals(getParameter(value))) {
                        attribute.setValue(p.getValue());
                        break;
                    }
                }
            }
        }
    }

    private String getParameter(String attrValue) {
        return attrValue
                .replace("${", "")
                .replace("}", "");
    }
}
