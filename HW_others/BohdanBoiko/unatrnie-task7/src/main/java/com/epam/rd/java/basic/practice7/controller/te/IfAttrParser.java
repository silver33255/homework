package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.List;

class IfAttrParser extends Parser {
    public IfAttrParser(String attributePrefix, Node document) {
        super("if", attributePrefix, document);
    }

    @Override
    public void parse(List<Parameter> parameters) {
        NodeList tagList = getNodesWithAttribute();

        for (int i = 0; i < tagList.getLength(); i++) {
            Element tag = (Element) tagList.item(i);
            processTags(document, tag, parameters);
        }
    }

    private void processTags(Node document, Element tag, List<Parameter> parameters) {
        String attributeValue = tag.getAttributes().getNamedItem(attributePrefix + ':' + attributeName).getNodeValue();

        for (Parameter p : parameters) {
            if (p.getName().equals(attributeValue)) {
                if (!Boolean.parseBoolean(p.getValue())) {
                    Util.remove(document, tag);
                }
                break;
            }
        }

        tag.removeAttribute(attributePrefix + ':' + attributeName);
    }
}
