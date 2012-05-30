package ru.spbau.velikiy.task4.comparators;

import ru.spbau.velikiy.task4.types.ComparableString;

import java.util.Comparator;

/**
 * Comparing by string length
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class StringLengthComparator implements Comparator<ComparableString> {

    /**
     * compare two string by length
     *
     * @param a first object
     * @param b second object
     * @return 1 if length(a) >= length(b) and 0 otherwise
     */
    public int compare(ComparableString a, ComparableString b) {
        if(a.value.length() == b.value.length() )
            return 0;
        return (a.value.length() >= b.value.length()) ? 1 : -1;
    }

}
