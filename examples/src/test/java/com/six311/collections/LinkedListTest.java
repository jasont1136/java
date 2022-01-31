package com.six311.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testLinkedList() {
        final LinkedList<Integer> ll = new LinkedList<>();

        ll.add(10);
        ll.add(11);
        ll.add(8);
        ll.add(12);
        ll.add(16);

        assertEquals(" 10 11 8 12 16 [ 16 12 8 11 10]", ll.traverse());
        assertEquals(10, ll.getFirst().getValue());
        assertEquals(16, ll.getLast().getValue());

        System.out.println(ll.traverse());

        assertTrue(ll.remove(12));
        assertFalse(ll.remove(24));

        assertEquals(" 10 11 8 16 [ 16 8 11 10]", ll.traverse());
        assertEquals(10, ll.getFirst().getValue());
        assertEquals(16, ll.getLast().getValue());

        ll.remove(16);

        System.out.println(ll.traverse());
        assertEquals(10, ll.getFirst().getValue());
        assertEquals(8, ll.getLast().getValue());

        ll.remove(10);

        System.out.println(ll.traverse());
        assertEquals(11, ll.getFirst().getValue());
        assertEquals(8, ll.getLast().getValue());

        ll.add(10);

        System.out.println(ll.traverse());
        assertEquals(11, ll.getFirst().getValue());
        assertEquals(10, ll.getLast().getValue());

    }

}
