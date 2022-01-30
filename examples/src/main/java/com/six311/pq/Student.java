package com.six311.pq;

/**
 * @author jasontewhau
 * @since 1/31/22
 */
public class Student {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
