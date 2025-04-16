package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;

public enum SortType {
    GNOMESORT("GnomeSort"),
    QUICKSORT("QuickSort");

    private final String name;

    SortType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
