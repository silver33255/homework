package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.List;

class TextAttrParser extends Parser{

    public TextAttrParser(String attributePrefix, Node document) {
        super("text", attributePrefix, document);
    }

    @Override
    public void parse(List<Parameter> parameters) {
        NodeList tagList = getNodesWithAttribute();

        for (int i = 0; i < tagList.getLength(); i++) {
            Node oldTag = tagList.item(i);
            Element newTag = processTags(oldTag, parameters);

            newTag.removeAttribute(attributePrefix + ':' + attributeName);
            Util.replace(document, newTag, oldTag);
        }
    }

    private Element processTags(Node tag, List<Parameter> parameters) {
        Element newTag = (Element) tag.cloneNode(true);
        String attributeValue = tag.getAttributes().getNamedItem(attributePrefix + ':' + attributeName).getNodeValue();

        for (Parameter p : parameters) {
            if (p.getName().equals(attributeValue)) {
                newTag.setTextContent(p.getValue());
                break;
            }
        }

        return newTag;
    }
}
