package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;

import java.util.Comparator;

public enum DataType {
    INTEGER("Integer"),
    DOUBLE("Double"),
    STRING("String"),
    BOOLEAN("Boolean");

    private final String name;

    DataType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
