package com.six311.collections;

import com.six311.model.Node;

public class LinkedList<V extends Comparable<V>> {

    private Node<V> root;
    private Node<V> last;

    public LinkedList() {
        this.root = null;
        this.last = null;
    }

    public Node<V> getLast() {
        return this.last;
    }

    public Node<V> getFirst() {
        return this.root;
    }

    public void add(final V value) {

        final Node<V> node = new Node<>(value);

        if (root == null) {
            root = node;
            last = node;
        }
        else {
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }
    }

    public boolean remove(final V value) {

        Node<V> current = root;

        Node<V> foundNode = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                foundNode = current;
                break;
            }
            current = current.getNext();
        }

        final boolean result;

        if (foundNode != null) {
            final Node<V> prev = foundNode.getPrev();
            final Node<V> next = foundNode.getNext();

            if (prev == null) {
                // first node is being removed, so prev should be null, and root moved
                if (next != null) {
                    next.setPrev(null);
                    root = next;
                }
            }
            else {
                prev.setNext(next);
            }

            if (next == null) {
                // last node is being removed, so next should be null, and last moved
                if (prev != null) {
                    prev.setNext(null);
                    last = prev;
                }
            }
            else {
                next.setPrev(prev);
            }

            foundNode = null;

            result = true;
        }
        else {
            result = false;
        }

        return result;
    }

    public String traverse() {
        final StringBuilder sb = new StringBuilder();

        Node<V> current = root;
        while (current != null) {
            sb.append(" ").append(current.getValue());
            current = current.getNext();
        }

        sb.append(" [");
        current = last;

        while (current != null) {
            sb.append(" ").append(current.getValue());
            current = current.getPrev();
        }

        sb.append("]");

        return sb.toString();
    }

}
