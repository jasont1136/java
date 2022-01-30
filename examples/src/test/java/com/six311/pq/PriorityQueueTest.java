package com.six311.pq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jasontewhau
 * @since 1/31/22
 */
public class PriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        final PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        pq.add(new Student("James", 3.0f));
        pq.add(new Student("Frances", 3.2f));
        pq.add(new Student("Paige", 4.2f));
        pq.add(new Student("Sheldon", 4.0f));
        pq.add(new Student("Sally", 2.5f));

        assertStudentMatches(pq.poll(), "Paige");
        assertStudentMatches(pq.poll(), "Sheldon");
        assertStudentMatches(pq.poll(), "Frances");
        assertStudentMatches(pq.poll(), "James");
        assertStudentMatches(pq.poll(), "Sally");

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
        pq.remove(3);
        assertStudentMatches(pq.poll(), "Frances");
        pq.add(new Student("Mazer", 5.4f));
        pq.add(new Student("Sheldon", 4.0f));

        assertStudentMatches(pq.poll(), "Mazer");
    }

    private void assertStudentMatches(final Student student, final String name) {
        assertNotNull(student);
        assertEquals(name, student.getName());
    }
}
