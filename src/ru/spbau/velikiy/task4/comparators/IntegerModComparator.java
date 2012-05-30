package ru.spbau.velikiy.task4.comparators;

import ru.spbau.velikiy.task4.types.ComparableInteger;

import java.util.Comparator;

/**
 * Comparing by mod
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class IntegerModComparator implements Comparator<ComparableInteger> {

    /**
     * comparing mod
     */
    public final int n;

    /**
     * create from mod value
     *
     * @param n mod value
     */
    public IntegerModComparator(int n) {
        this.n = n;
    }

    /**
     * Compare two objects by mod value
     *
     * @param a first object
     * @param b second object
     * @return 1 if a%n >= b%n and 0 otherwise
     */
    public int compare(ComparableInteger a, ComparableInteger b) {
        int mod1 = a.value % n;
        int mod2 = b.value % n;
        if (mod1 == mod2)
            return 0;
        return (mod1 > mod2) ? 1 : -1;
    }

}
