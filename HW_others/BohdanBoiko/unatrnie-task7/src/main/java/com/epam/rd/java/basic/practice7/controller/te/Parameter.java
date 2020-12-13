package com.epam.rd.java.basic.practice7.controller.te;

import java.util.Arrays;
import java.util.function.Function;

public class Parameter {
    private final String name;
    private final Object value;
    private Function<Object, String> extractor = Object::toString;
    private Function<Object, String[]> arrayMapper = o -> (String[]) o;

    public Parameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public void setExtractor(Function<Object, String> extractor) {
        this.extractor = extractor;
    }

    public void setArrayMapper(Function<Object, String[]> arrayMapper) {
        this.arrayMapper = arrayMapper;
    }

    public String[] getValueAsArray() {
        return arrayMapper.apply(value);
    }

    public String getValue() {
        return extractor.apply(value);
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Parameter parameter = new Parameter("nam1e", new String[] {"va1", "dg", "45fg"});
        parameter.setArrayMapper(o -> (String[]) o);

        String[] array = parameter.getValueAsArray();
        Arrays.stream(array).forEach(System.out::println);
    }
}
