package com.six311.model;

import java.util.Comparator;

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
