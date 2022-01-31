package com.six311.model;

import java.util.Locale;

public class Student implements Comparable<Student> {
    private final String name;
    private final float gpa;

    public Student(final String name, final float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + "(" + gpa + ")";
    }

    @Override
    public int compareTo(final Student s) {
        return getName().toLowerCase(Locale.ROOT).compareTo(s.getName().toLowerCase(Locale.ROOT));
    }
}
