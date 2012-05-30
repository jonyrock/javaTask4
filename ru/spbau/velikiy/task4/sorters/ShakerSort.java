package spbau.velikiy.task4.sorters;


import spbau.velikiy.task4.core.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting with shakeSort algorithm 
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class ShakerSort<T extends Comparable<T>> extends AbstractSorter<T> {

    /**
     * sorts elements in list with comparable objects 
     * @param list for sorting
     */
    public void sort(List<T> list, Comparator<T> comparator) {

        int a;
        boolean exchange;        
        int count = list.size();

        do {
            
            exchange = false;
            
            for (a = count - 1; a > 0; --a) {
                if (comparator.compare(list.get(a - 1), list.get(a)) == 1) {
                    Collections.swap(list, a - 1, a);
                    exchange = true;
                }
            }
            
            for (a = 1; a < count; ++a) {
                if (comparator.compare(list.get(a - 1), list.get(a)) == 1) {
                    Collections.swap(list, a - 1, a);
                    exchange = true;
                }
            }
            
        } while (exchange);


        list.clear();
        list.addAll(list);

    }

}
