package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.FullSortData;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.SortState;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, -5, -6, 1, 5, 1, 4, 6};
        QuickSort<Integer> quickSort = new QuickSort<>();
        FullSortData fullSortData = quickSort.sortWithData(arr, Comparator.naturalOrder());

        for (SortState sortState : fullSortData.states) {
            System.out.println("______________");
            System.out.println(Arrays.toString(sortState.arr));
            System.out.println(sortState.importantIndexes);
            System.out.println();
        }
    }
}
