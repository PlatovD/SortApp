//package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;
//
//import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.QuickSort;
//import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.Sort;
//
//import java.time.Duration;
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//public class TimingTester<T> {
//    private T[] arrayForTests;
//    private List<String> testsResults;
//
//    public TimingTester(T[] arrayForTests) {
//        this.arrayForTests = Arrays.copyOf(arrayForTests, arrayForTests.length);
//    }
//
//    public void test() {
//        T[] arrTest = Arrays.copyOf(arrayForTests, arrayForTests.length);
//        testsResults(arrTest, new QuickSort<>());
//    }
//
//    private void testBySort(T[] arr, Sort<?> sort) {
//        Instant start = Instant.now();
//        sort.sort(arr, (Comparator<T>) Comparator.naturalOrder());
//        Instant end = Instant.now();
//        testsResults.add(Duration.between(start, end).toMillis() + " " + sort.toString());
//    }
//}
