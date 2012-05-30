package ru.spbau.velikiy.task4;

import ru.spbau.velikiy.task4.sorters.HeapSort;
import ru.spbau.velikiy.task4.sorters.ShakerSort;
import ru.spbau.velikiy.task4.types.ComparableInteger;
import ru.spbau.velikiy.task4.types.ComparableString;

import static ru.spbau.velikiy.task4.Tests.*;

/**
 * Arithmetic Parser. With functions definitions.
 * Start point
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class Main {

    /**
     * Start point
     *
     * @param args program source path (not real using)
     */
    public static void main(String[] args) {

        System.out.println("HeapSort testing");
        System.out.println("------------------------------------------");
        integersTest(new HeapSort<ComparableInteger>());
        System.out.println();
        integersTestWithComparators(new HeapSort<ComparableInteger>());
        System.out.println();
        stringsTest(new HeapSort<ComparableString>());
        System.out.println();
        stringsTestWithComparators(new HeapSort<ComparableString>());

        System.out.println("ShakerSort testing");
        System.out.println("------------------------------------------");
        integersTest(new ShakerSort<ComparableInteger>());
        System.out.println();
        integersTestWithComparators(new ShakerSort<ComparableInteger>());
        System.out.println();
        stringsTest(new ShakerSort<ComparableString>());
        System.out.println();
        stringsTestWithComparators(new ShakerSort<ComparableString>());

    }


}
