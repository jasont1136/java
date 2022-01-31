package com.six311.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Node<V extends Comparable<V>> {

    private V value;
    private Node<V> next;
    private Node<V> prev;

    public Node(@Nonnull final V value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Nonnull
    public V getValue() {
        return value;
    }

    public void setValue(@Nonnull final V value) {
        this.value = value;
    }

    @Nullable
    public Node<V> getLeft() {
        return getPrev();
    }

    public void setLeft(@Nullable final Node<V> left) {
        setPrev(left);
    }

    @Nullable
    public Node<V> getRight() {
        return getNext();
    }

    public void setRight(@Nullable final Node<V> right) {
        setNext(right);
    }

    @Nullable
    public Node<V> getNext() {
        return this.next;
    }

    public void setNext(@Nullable final Node<V> next) {
        this.next = next;
    }

    @Nullable
    public Node<V> getPrev() {
        return this.prev;
    }

    public void setPrev(@Nullable final Node<V> prev) {
        this.prev = prev;
    }

    public int compareTo(final V v1, final V v2) {
        return v1.compareTo(v2);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}