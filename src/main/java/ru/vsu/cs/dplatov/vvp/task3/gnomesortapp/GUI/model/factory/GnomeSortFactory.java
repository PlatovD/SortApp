package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.factory;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.GnomeSort;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.Sort;

public class GnomeSortFactory<T> implements SortFactory<T> {
    @Override
    public Sort<T> createSort() {
        return new GnomeSort<>();
    }
}
