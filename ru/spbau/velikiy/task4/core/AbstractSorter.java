package spbau.velikiy.task4.core;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract class for sorting algorithms
 *
 * @param <T> storing type
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public abstract class AbstractSorter<T extends Comparable<T>> implements Sorter<T> {

    /**
     * sorts elements in list with comparable objects
     *
     * @param list for sorting
     */
    public void sort(List<T> list) {

        this.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                return a.compareTo(b);
            }
        });

    }

}
