package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.*;

public class Util {
    private static final String XML_NAMESPACE = "xmlns";

    private Util() {
    }

    public static void replace(Node node, Node newChild, Node oldChild) {
        try {
            node.replaceChild(newChild, oldChild);
        } catch (DOMException e) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                replace(children.item(i), newChild, oldChild);
            }
        }
    }

    public static void insert(Node node, Node newChild, Node refChild) {
        try {
            node.insertBefore(newChild, refChild);
        } catch (DOMException e) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                insert(children.item(i), newChild, refChild);
            }
        }
    }

    public static void remove(Node node, Node child) {
        try {
            node.removeChild(child);
        } catch (DOMException e) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                remove(children.item(i), child);
            }
        }
    }

    public static String getPrefix(Element element, String namespaceUri) {
        NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            Node node = attrs.item(i);
            String name = node.getNodeName();
            if (namespaceUri.equals(node.getNodeValue())
                    && (name != null && (XML_NAMESPACE.equals(name) || name.startsWith(XML_NAMESPACE + ":")))) {
                return name.split(":")[1];
            }
        }
        return "";
    }
}
