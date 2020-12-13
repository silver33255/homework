package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO: add inner loop support
class EachAttrParser extends Parser {

    public EachAttrParser(String attributePrefix, Node document) {
        super("each", attributePrefix, document);
    }

    @Override
    public void parse(List<Parameter> parameters) {
        NodeList tagList = getNodesWithAttribute();

        for (int i = 0; i < tagList.getLength(); i++) {
            Element oldTag = (Element) tagList.item(i);
            String attributeValue = oldTag.getAttributes().getNamedItem(attributePrefix + ':' + attributeName).getNodeValue();
            String expectedParameterName = attributeValue.split(" : ")[1];

            for (Parameter parameter : parameters) {
                if (parameter.getName().equals(expectedParameterName)) {
                    List<Node> childElements = getChildElements(oldTag);
                    processChildElements(oldTag, childElements, parameter, attributeValue);
                    break;
                }
            }
            oldTag.removeAttribute(attributePrefix + ':' + attributeName);
        }
    }

    private List<Node> getChildElements(Node tag) {
        NodeList childNodes = tag.getChildNodes();
        List<Node> childElements = new ArrayList<>();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                childElements.add(childNode.cloneNode(true));
                Util.remove(document, childNode);
            }
        }

        return childElements;
    }

    private void processChildElements(Node tag, List<Node> childElements, Parameter parameter, String attributeValue) {
        String[] values = parameter.getValueAsArray();
        Parser parser = new TextAttrParser(attributePrefix, tag);
        for (String value : values) {
            for (Node child : childElements) {
                tag.appendChild(child.cloneNode(true));
            }
            Parameter newParameter = new Parameter(attributeValue.split(" : ")[0], value);
            parser.parse(Collections.singletonList(newParameter));
        }
    }
}
