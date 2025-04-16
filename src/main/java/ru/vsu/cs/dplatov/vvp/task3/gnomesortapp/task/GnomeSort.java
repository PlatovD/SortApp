package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.FullSortData;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.SortState;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

public class GnomeSort<T> implements Sort<T> {
    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        if (array.length <= 1) {
            return;
        }

        int i = 1;
        while (i != array.length) {
            int compareRes = comparator.compare(array[i], array[i - 1]);
            if (compareRes >= 0) {
                i++;
            } else {
                T tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
                if (i > 1) i--;
            }
        }

    }

    @Override
    public FullSortData sortWithData(T[] array, Comparator<T> comparator) {
        FullSortData fullSortData = new FullSortData();
        fullSortData.arrSize = array.length;
        Instant start = Instant.now();
        sort(Arrays.copyOf(array, array.length), comparator);
        Instant end = Instant.now();
        fullSortData.workingTime = Duration.between(start, end).toMillis();

        int i = Math.min(array.length, 1);

        while (i != array.length) {
            fullSortData.states.add(new SortState(Arrays.copyOf(array, array.length), i - 1, i));
            fullSortData.cntIterations++;
            int compareRes = comparator.compare(array[i], array[i - 1]);
            if (compareRes >= 0) {
                i++;
            } else {
                fullSortData.cntReplaces++;
                T tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
                if (i > 1) i--;
            }
        }
        return fullSortData;

    }

    @Override
    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int i = 1;
        while (i != arr.length) {
            if (arr[i] >= arr[i - 1]) {
                i++;
            } else {
                int tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                if (i > 1) i--;
            }
        }
    }

    @Override
    public void sort(boolean[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int i = 1;
        while (i != arr.length) {
            if (arr[i] && !arr[i - 1] || !arr[i] && !arr[i - 1] || arr[i] && arr[i - 1]) {
                i++;
            } else {
                boolean tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                if (i > 1) i--;
            }
        }
    }

    @Override
    public void sort(double[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int i = 1;
        while (i != arr.length) {
            if (arr[i] >= arr[i - 1]) {
                i++;
            } else {
                double tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                if (i > 1) i--;
            }
        }
    }

    @Override
    public String toString() {
        return "Гномья сортировка";
    }
}
