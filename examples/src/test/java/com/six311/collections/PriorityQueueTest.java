package com.six311.collections;

import com.six311.model.Student;
import com.six311.model.StudentComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        final PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        pq.add(new Student("James", 3.0f));
        pq.add(new Student("Frances", 2.9f));
        pq.add(new Student("Paige", 4.2f));
        pq.add(new Student("Sheldon", 4.0f));
        pq.add(new Student("Sally", 3.5f));

        System.out.println(pq.traverse());

        assertStudentMatches(pq.poll(), "Paige");
        assertStudentMatches(pq.poll(), "Sheldon");
        assertStudentMatches(pq.poll(), "Sally");
        assertStudentMatches(pq.poll(), "James");
        assertStudentMatches(pq.poll(), "Frances");

        assertTrue(pq.isEmpty());
    }

    @Test
    public void testPriorityQueue_withRemoves() {
        final PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());

        pq.add(new Student("James", 3.0f));
        pq.add(new Student("Frances", 3.2f));
        pq.add(new Student("Paige", 4.2f));
        pq.add(new Student("Sheldon", 4.0f));
        pq.add(new Student("Sally", 2.5f));

        assertStudentMatches(pq.poll(), "Paige");
        assertFalse(pq.remove(new Student("Paige", 4.2f)));
        assertStudentMatches(pq.poll(), "Sheldon");
        pq.add(new Student("Mazer", 5.4f));
        assertTrue(pq.add(new Student("Sheldon", 4.0f)));

        System.out.println(pq.traverse());

        assertStudentMatches(pq.poll(), "Mazer");
    }

    private void assertStudentMatches(final Student student, final String name) {
        assertNotNull(student);
        assertEquals(name, student.getName());
    }
}
