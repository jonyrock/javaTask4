package ru.spbau.velikiy.task4.sorters;

import ru.spbau.velikiy.task4.core.AbstractSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting on heap
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSorter<T> {

    /**
     * sorts elements in list with comparable objects
     *
     * @param list for sorting
     */
    public void sort(final List<T> list, final Comparator<T> comparator) {

        Heap<T> heap = new Heap<T>(list.size(), comparator);
        for (T t : list) {
            heap.add(t);
        }
        list.clear();
        while (!heap.isEmpty()) {
            list.add(heap.pop());
        }

    }

    /**
     * Heap data structure
     *
     * @param <T> inner values
     */
    private static class Heap<T> {
        /**
         * Storing array
         */
        public ArrayList<T> data;
        /**
         * Index to push
         */
        public int topIndex = 0;
        /**
         * sorting comparator
         */
        public final Comparator<T> comparator;

        /**
         * Init heap
         *
         * @param capacity   init values in data
         * @param comparator for sorting
         */
        public Heap(int capacity, Comparator<T> comparator) {
            data = new ArrayList<T>(capacity);
            this.comparator = comparator;
        }

        /**
         * Is there any element?
         *
         * @return Contain or not elements
         */
        public boolean isEmpty() {
            return topIndex == 0;
        }

        /**
         * Add new element
         *
         * @param n value
         */
        public void add(T n) {
            data.add(n);
            heapify(topIndex);
            topIndex++;
        }

        /**
         * Take one and remove
         *
         * @return element on top
         */
        public T pop() {
            T t = data.get(0);
            data.set(0, data.get(topIndex - 1));
            topIndex--;
            heapifyDown(0);
            return t;
        }

        /**
         * return structure in normal state. To top
         *
         * @param i begin normalize index
         * @return new position
         */
        public int heapify(int i) {

            int p;
            while (i != 0) {
                p = (i - 1) / 2;
                if (comparator.compare(data.get(p), data.get(i)) != 1) {
                    break;
                }
                Collections.swap(data, p, i);
                i = p;
            }

            return i;

        }

        /**
         * return structure in normal state. To bottom
         *
         * @param i begin normalize index
         * @return new position
         */
        public int heapifyDown(int i) {

            while (true) {

                int ci1 = i * 2 + 1;
                int ci2 = ci1 + 1;
                int mi;

                if (ci1 >= topIndex) {
                    break;
                }

                if (ci2 >= topIndex) {
                    mi = ci1;
                } else {
                    mi = (comparator.compare(data.get(ci1),
                            data.get(ci2)) == -1) ? ci1 : ci2;
                }

                if (comparator.compare(data.get(i), data.get(mi)) == 1) {
                    Collections.swap(data, i, mi);
                } else {
                    break;
                }

                i = mi;

            }

            return i;

        }


    }

}
