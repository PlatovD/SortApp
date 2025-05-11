package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.factory;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.SortType;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.GnomeSort;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.QuickSort;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.Sort;

public class SortFactory {
    public static <T> Sort<T> createSort(SortType sortType) {
        return switch (sortType) {
            case GNOMESORT -> new GnomeSort<>();
            case QUICKSORT -> new QuickSort<>();
            default -> throw new IllegalArgumentException("Unknown sort type " + sortType);
        };
    }
}
