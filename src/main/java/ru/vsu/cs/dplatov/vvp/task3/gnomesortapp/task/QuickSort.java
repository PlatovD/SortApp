package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task;

import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.FullSortData;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.SortState;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        if (array.length < 2) {
            return;
        }
        quickSortRealization(array, comparator, 0, array.length - 1);
    }

    private void quickSortRealization(T[] array, Comparator<T> comparator, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(array, comparator, l, r);
        quickSortRealization(array, comparator, l, pivot - 1);
        quickSortRealization(array, comparator, pivot + 1, r);

    }

    private int partition(T[] array, Comparator<T> comparator, int l, int r) {
        T pivot = array[r];

        while (l <= r) {
            while (comparator.compare(array[l], pivot) < 0) {
                l++;
            }
            while (comparator.compare(array[r], pivot) > 0) {
                r--;
            }
            if (l <= r) {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        return r;
    }

    private void swap(T[] array, int index1, int index2) {
        if (index2 < 0 || index2 >= array.length || index1 >= array.length || index1 < 0) {
            return;
        }
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Override
    public FullSortData sortWithData(T[] array, Comparator<T> comparator) {
        if (array.length < 2) {
            return new FullSortData();
        }
        FullSortData fullSortData = new FullSortData();
        Instant start = Instant.now();
        sort(Arrays.copyOf(array, array.length), comparator);
        Instant end = Instant.now();
        fullSortData.workingTime = Duration.between(start, end).toMillis();
        fullSortData.cntIterations--;
        quickSortRealization(array, comparator, 0, array.length - 1, fullSortData);
        return fullSortData;
    }

    private void quickSortRealization(T[] array, Comparator<T> comparator, int l, int r, FullSortData fullSortData) {
        if (l >= r) {
            return;
        }
        fullSortData.cntIterations++;
        fullSortData.states.add(new SortState(Arrays.copyOf(array, array.length)));
        int pivot = partition(array, comparator, l, r, fullSortData);
        fullSortData.states.get(fullSortData.states.size() - 1).importantIndexes.add(pivot);
        quickSortRealization(array, comparator, l, pivot - 1, fullSortData);
        quickSortRealization(array, comparator, pivot + 1, r, fullSortData);

    }

    private int partition(T[] array, Comparator<T> comparator, int l, int r, FullSortData fullSortData) {
        T pivot = array[r];

        while (l <= r) {
            while (comparator.compare(array[l], pivot) < 0) {
                l++;
            }
            while (comparator.compare(array[r], pivot) > 0) {
                r++;
            }
            if (l <= r) {
                swap(array, l, r);
                fullSortData.cntReplaces++;
                l++;
                r--;
            }
        }
        return r;
    }

    @Override
    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        quickSortRealization(array, 0, array.length - 1);
    }

    private void quickSortRealization(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(array, l, r);
        quickSortRealization(array, l, pivot - 1);
        quickSortRealization(array, pivot + 1, r);

    }

    private int partition(int[] array, int l, int r) {
        int pivot = array[r];

        while (l <= r) {
            while (array[l] <= pivot) {
                l++;
            }
            while (array[r] >= pivot) {
                r--;
            }
            if (l <= r) {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    private void swap(int[] array, int index1, int index2) {
        if (index2 < 0 || index2 >= array.length || index1 >= array.length || index1 < 0) {
            return;
        }
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Override
    public void sort(boolean[] array) {
        System.out.println("Coming soon");
    }

    @Override
    public void sort(double[] array) {
        System.out.println("Coming soon");
    }

    @Override
    public String toString() {
        return "Быстрая сортировка";
    }
}
