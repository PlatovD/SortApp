package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.FullSortData;

import java.util.Comparator;

public interface Sort<T> {
    void sort(T[] array, Comparator<T> comparator);

    FullSortData sortWithData(T[] array, Comparator<T> comparator);

    void sort(int[] array);

    void sort(boolean[] array);

    void sort(double[] array);
}
