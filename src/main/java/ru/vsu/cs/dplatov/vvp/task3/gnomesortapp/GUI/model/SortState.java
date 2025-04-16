package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model;

import java.util.HashSet;
import java.util.Set;

public class SortState {
    public final Object[] arr;
    public final Set<Integer> importantIndexes = new HashSet<>();

    public SortState(Object[] arr, int... importantIndexes) {
        this.arr = arr;
        for (int index : importantIndexes) {
            this.importantIndexes.add(index);
        }

    }
}
