package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;

public enum DataType {
    INTEGER("Integer", new DataTypePayload<Integer>(Integer::parseInt, Integer::compareTo)),

    DOUBLE("Double", new DataTypePayload<Double>(Double::parseDouble, Double::compareTo)),

    STRING("String", new DataTypePayload<String>(String::toString, String::compareTo)),

    BOOLEAN("Boolean", new DataTypePayload<Boolean>(Boolean::parseBoolean, Boolean::compareTo));

    private final String name;
    private final DataTypePayload<?> payload;

    DataType(String name, DataTypePayload<?> payload) {
        this.name = name;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return name;
    }

    public <T> DataTypePayload<T> getPayload() {
        return (DataTypePayload<T>) payload;
    }
}
