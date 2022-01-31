package com.six311.bt;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
public class Node<V extends Comparable<V>> {

    private V value;
    private Node<V> left;
    private Node<V> right;

    public Node(@Nonnull final V value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Nonnull
    public V getValue() {
        return value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

    @Nullable
    public Node<V> getLeft() {
        return this.left;
    }

    public void setLeft(final Node<V> left) {
        this.left = left;
    }

    @Nullable
    public Node<V> getRight() {
        return this.right;
    }

    public void setRight(final Node<V> right) {
        this.right = right;
    }

    public int compareTo(final V v1, final V v2) {
        return v1.compareTo(v2);
    }
}