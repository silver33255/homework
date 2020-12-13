package com.epam.rd.java.basic.practice7.controller.te;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    private static final String NAMESPACE = "http://www.thymeleaf.org";
    private static final DocumentBuilderFactory FACTORY = DocumentBuilderFactory.newInstance();
    private static final TransformerFactory TRANSFORMER_FACTORY = TransformerFactory.newInstance();
    private final String fileName;
    private final List<Parameter> parameters;

    public Engine(String fileName, List<Parameter> parameters) {
        this.fileName = fileName;
        this.parameters = parameters;
    }

    public void parse(Writer writer) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document = FACTORY.newDocumentBuilder().parse(fileName);
        Element root = document.getDocumentElement();
        String prefix = Util.getPrefix(root, NAMESPACE);

        new IfAttrParser(prefix, document).parse(parameters);
        new EachAttrParser(prefix, document).parse(parameters);
        new TextAttrParser(prefix, document).parse(parameters);
        new AttrValueParser(prefix, document).parse(parameters);

//        StreamResult result = new StreamResult(new File("o.html"));
//        Transformer transformer = TRANSFORMER_FACTORY.newTransformer();
//        transformer.transform(new DOMSource(document), result);
        write(document, writer);
    }

    private void write(Document document, Writer writer) throws TransformerException {
        StreamResult result = new StreamResult(writer);
        Transformer transformer = TRANSFORMER_FACTORY.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), result);
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("test", "test - value"));
        parameters.add(new Parameter("test2", "test : value2"));
        parameters.add(new Parameter("ts", new String[]{"1", "2", "0"}));
        parameters.add(new Parameter("bool2", "true"));
        parameters.add(new Parameter("bool1", "false"));
        parameters.add(new Parameter("class", "jiu! :)"));
        Engine e = new Engine("output.html", parameters);
        e.parse(new PrintWriter(System.out));
    }
}
