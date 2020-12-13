package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;
import java.util.List;

abstract class Parser {
    protected final String attributeName;
    protected final String attributePrefix;
    protected final Node document;

    public Parser(String attributeName, String attributePrefix, Node document) {
        this.attributeName = attributeName;
        this.attributePrefix = attributePrefix;
        this.document = document;
    }

    public abstract void parse(List<Parameter> parameters);

    protected NodeList getNodesWithAttribute() {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = xpath.compile(String.format("//*[@%s]", attributeName));
            return (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new UnsupportedOperationException("can not process XPath expression", e);
        }
    }
}
