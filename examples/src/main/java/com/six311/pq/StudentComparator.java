package com.six311.pq;

import java.util.Comparator;

/**
 * A comparator for the Student class.
 *
 * @author jasontewhau
 * @since 1/31/22
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(final Student s1, final Student s2) {

        if (s1.getGpa() > s2.getGpa()) {
            return 1;
        }
        else if (s1.getGpa() < s2.getGpa()) {
            return -1;
        }
        else {
            // they must be the same, so sort by name
            return s1.getName().compareTo(s2.getName());
        }
    }
}
