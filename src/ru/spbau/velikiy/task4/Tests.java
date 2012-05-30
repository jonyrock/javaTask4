package ru.spbau.velikiy.task4;

import ru.spbau.velikiy.task4.comparators.IntegerModComparator;
import ru.spbau.velikiy.task4.comparators.StringLengthComparator;
import ru.spbau.velikiy.task4.core.Sorter;
import ru.spbau.velikiy.task4.types.ComparableInteger;
import ru.spbau.velikiy.task4.types.ComparableString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Tests {


    static void integersTest(Sorter<ComparableInteger> sorter) {

        System.out.println("ComparableInteger tests");

        // preparing computation structures
        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        List<Long> results = new ArrayList<Long>();

        // checking correctness and save statistics
        fillListIntegers(list, 10);
        System.out.println("Checking correctness");
        System.out.print("Source list: ");
        printList(list, true);
        results.add(getTime(list, sorter));
        System.out.print("Sorted list: ");
        printList(list, true);

        // collect statistics
        System.out.println("Executing bigger test (without comparator):");
        fillListIntegers(list, 100);
        results.add(getTime(list, sorter));
        fillListIntegers(list, 1000);
        results.add(getTime(list, sorter));
        fillListIntegers(list, 10000);
        results.add(getTime(list, sorter));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();

    }

    static void integersTestWithComparators(Sorter<ComparableInteger> sorter) {

        System.out.println("ComparableInteger tests with comparators");
        System.out.println("using IntegerModComparator(10)");

        // preparing computation structures
        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        List<Long> results = new ArrayList<Long>();
        Comparator<ComparableInteger> comparator = new IntegerModComparator(10);

        // checking correctness and save statistics
        fillListIntegers(list, 10);
        System.out.println("Checking correctness");
        System.out.print("Source list: ");
        printList(list, true);
        results.add(getTime(list, sorter, comparator));
        System.out.print("Sorted list: ");
        printList(list, true);

        // collect statistics
        System.out.println("Executing bigger test:");
        fillListIntegers(list, 100);
        results.add(getTime(list, sorter, comparator));
        fillListIntegers(list, 1000);
        results.add(getTime(list, sorter, comparator));
        fillListIntegers(list, 10000);
        results.add(getTime(list, sorter, comparator));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();

    }

    static void stringsTest(Sorter<ComparableString> sorter) {

        System.out.println("ComparableString tests");

        // preparing computation structures
        List<ComparableString> list = new ArrayList<ComparableString>();
        List<Long> results = new ArrayList<Long>();

        // checking correctness and save statistics
        fillListStrings(list, 10, 10);
        System.out.println("Checking correctness");
        System.out.println("Source list: ");
        printList(list, false);
        results.add(getTime(list, sorter));
        System.out.println("Sorted list: ");
        printList(list, false);

        // collect statistics
        System.out.println("Executing bigger test (without comparator):");
        fillListStrings(list, 100, 10);
        results.add(getTime(list, sorter));
        fillListStrings(list, 1000, 10);
        results.add(getTime(list, sorter));
        fillListStrings(list, 10000, 10);
        results.add(getTime(list, sorter));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();
    }

    static void stringsTestWithComparators(Sorter<ComparableString> sorter) {

        System.out.println("ComparableString tests with comparators");
        System.out.println("using StringLengthComparator");

        // preparing computation structures
        List<ComparableString> list = new ArrayList<ComparableString>();
        List<Long> results = new ArrayList<Long>();
        Comparator<ComparableString> comparator = new StringLengthComparator();

        // checking correctness and save statistics
        fillListStrings(list, 10, 10);
        System.out.println("Checking correctness");
        System.out.println("Source list: ");
        printList(list, false);
        results.add(getTime(list, sorter, comparator));
        System.out.println("Sorted list: ");
        printList(list, false);

        // collect statistics
        System.out.println("Executing bigger test:");
        fillListStrings(list, 100, 10);
        results.add(getTime(list, sorter, comparator));
        fillListStrings(list, 1000, 10);
        results.add(getTime(list, sorter, comparator));
        fillListStrings(list, 10000, 10);
        results.add(getTime(list, sorter, comparator));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();
    }

    static void fillListIntegers(List<ComparableInteger> list, int count) {

        list.clear();
        for (int i = 0; i < count; i++) {
            list.add(new ComparableInteger(
                    (int) (Math.random() * 1000)));
        }

    }

    static void fillListStrings(List<ComparableString> list, int count, int length) {

        list.clear();

        StringBuilder builder;
        int range = 'z' - 'a';

        for (int i = 0; i < count; i++) {
            builder = new StringBuilder();
            int lengthRandom = (int) (Math.random() * length) + 3;
            for (int j = 0; j < lengthRandom; j++) {
                builder.append((char) ('a' + (int) (Math.random() * range)));
            }
            list.add(new ComparableString(builder.toString()));
        }

    }

    static <T> void printList(List<T> list, boolean inline) {

        for (T item : list) {
            if (inline) {
                System.out.print(item + " ");
            } else {
                System.out.println(item);
            }
        }

        System.out.println();

    }

    static <T extends Comparable<T>> long getTime(List<T> list, Sorter<T> sorter) {
        Date startDate = new Date();
        sorter.sort(list);
        return new Date().getTime() - startDate.getTime();
    }

    static <T extends Comparable<T>> long getTime(List<T> list, Sorter<T> sorter,
                                                  Comparator<T> comparator) {
        Date startDate = new Date();
        sorter.sort(list, comparator);
        return new Date().getTime() - startDate.getTime();
    }


}
