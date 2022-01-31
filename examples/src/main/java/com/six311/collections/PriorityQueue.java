package com.six311.collections;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> {

    final List<E> list = new ArrayList<>();

    final Comparator<E> comparator;

    PriorityQueue() {
        this.comparator = null;
    }

    PriorityQueue(final Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // enqueue
    public boolean add(final E e) {
        final boolean result = list.add(e);
        if (list.size() > 1) {
            list.sort(comparator);
        }
        return result;
    }

    @Nullable
    E peek() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    @Nullable
    E poll() {
        if (list.isEmpty()) {
            return null;
        }

        return list.remove(list.size()-1);
    }

    E remove(final int index) {
        final E removed = list.remove(index);

        if (list.size() > 1) {
            list.sort(comparator);
        }

        return removed;
    }

    // dequeue
    boolean remove(final E e) {
        final boolean removed = list.remove(e);

        if (removed && list.size() > 1) {
            list.sort(comparator);
        }

        return removed;
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    int size() {
        return list.size();
    }
}
