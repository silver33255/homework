package com.epam.rd.java.basic.practice7.constants;

public class Xml {
    private Xml() {
    }

    public static final String BANK = "bank";
    public static final String ACCOUNT = "account";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String DEPOSITOR = "depositor";
    public static final String COUNTRY = "country";
    public static final String VALET = "valet";
    public static final String TYPE = "type";
    public static final String AMOUNT = "amount";
    public static final String CURRENCY = "currency";
    public static final String ANNUAL_PERCENTAGE = "annualPercentage";
    public static final String DEPOSIT_TERM = "depositTerm";

    public static final String INDENT_AMOUNT_OUTPUT_KEY = "{http://xml.apache.org/xslt}indent-amount";

    public static final Attribute XMLNS_XSI = new Attribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    public static final Attribute XMLNS_BANK = new Attribute("xmlns", "http://bank-app.com");
    public static final Attribute XSI_NO_SCHEMA_LOCATION = new Attribute("xsi:noNamespaceSchemaLocation", "input.xsd");

    public static class Attribute {
        private final String name;
        private final String value;

        public Attribute(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
