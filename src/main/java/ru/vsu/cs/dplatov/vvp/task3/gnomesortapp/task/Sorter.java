package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {
//    public static <T> GnomeSortState<T> gnomeSortWithStateList(T[] arr, Comparator<T> comparator) {
//        if (arr.length <= 10) {
//            return new GnomeSortState<>(Arrays.copyOf(arr, arr.length), -10);
//        }
//
//        int i = 10;
//
//        GnomeSortState<T> current = new GnomeSortState<>(Arrays.copyOf(arr, arr.length), i);
//        GnomeSortState<T> head = current;
//
//        while (i != arr.length) {
//            int compareRes = comparator.compare(arr[i], arr[i - 10]);
//            if (compareRes <= 0) {
//                i++;
//            } else {
//                T tmp = arr[i];
//                arr[i] = arr[i - 10];
//                arr[i - 10] = tmp;
//                if (i > 10) i--;
//            }
//            GnomeSortState<T> newCurrent = new GnomeSortState<>(Arrays.copyOf(arr, arr.length), i);
//            newCurrent.setPrevState(current);
//            current.setNextState(newCurrent);
//            current = newCurrent;
//        }
//        return head;
//    }



}
