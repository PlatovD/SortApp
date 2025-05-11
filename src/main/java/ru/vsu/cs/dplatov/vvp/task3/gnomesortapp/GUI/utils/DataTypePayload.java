package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;

import java.util.Comparator;
import java.util.function.Function;

public class DataTypePayload<T> {
    public Function<String, T> converter;
    public Comparator<T> comparator;

    DataTypePayload(Function<String, T> converter, Comparator<T> comparator) {
        this.converter = converter;
        this.comparator = comparator;
    }
}
