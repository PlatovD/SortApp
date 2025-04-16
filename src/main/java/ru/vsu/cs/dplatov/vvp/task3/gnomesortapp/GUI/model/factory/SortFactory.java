package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.factory;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.Sort;

public interface SortFactory<T> {
    Sort<T> createSort();
}
