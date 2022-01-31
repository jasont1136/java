package com.six311.collections;

import com.six311.model.Node;

import javax.annotation.Nullable;
import java.util.Comparator;

public class PriorityQueue<V extends Comparable<V>> {

    Node<V> root;
    Node<V> last;
    final Comparator<V> comparator;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(final Comparator<V> comparator) {
        this.root = null;
        this.last = null;
        this.comparator = comparator;
    }


    // enqueue
    public boolean add(final V value) {

        final Node<V> node = new Node<>(value);

        if (root == null) {
            root = node;
            last = node;
            return true;
        }

        Node<V> current = root;

        boolean success = false;
        boolean duplicate = false;

        while (current != null) {

            final int compare = compare(value, current.getValue());

            if (compare < 0) {
                // add before current
                addAfter(current.getPrev(), node);
                success = true;
                break;
            } else if (compare == 0) {
                // duplicate so don't add
                duplicate = true;
                break;
            } else {
                current = current.getNext();
            }
        }

        if (!success && !duplicate) {
            // this means the value is greater than all previous, so add to the end
            addAfter(last, node);
            success = true;
        }

        return success;
    }

    @Nullable
    V peek() {
        if (last == null) {
            return null;
        }
        else {
            return last.getValue();
        }
    }

    @Nullable
    V poll() {

        if (last == null) {
            return null;
        }

        final Node<V> node = last;

        final Node<V> prev = last.getPrev();

        if (prev == null) {
            // there is only one node left
            root = null;
            last = null;
        }
        else {
            prev.setNext(null);
            last = prev;
        }

        return node.getValue();
    }

    // dequeue
    boolean remove(final V value) {

        Node<V> current = root;

        Node<V> foundNode = null;

        while (current != null) {

            final int compare = compare(value, current.getValue());

            if (compare == 0) {
                foundNode = current;
                break;
            }

            current = current.getNext();
        }

        boolean success = false;

        if (foundNode != null) {
            final Node<V> next = foundNode.getNext();
            final Node<V> prev = foundNode.getPrev();

            if (prev == null) {
                if (next == null) {
                    // this is the only node left, so reset root and last
                    root = null;
                    last = null;
                } else {
                    // this is the root node, so set root to next after removing
                    next.setPrev(null);
                    root = next;
                }
            } else {
                if (next == null) {
                    // this is the last node, so set last to prev after removing
                    prev.setNext(null);
                    last = prev;
                } else {
                    next.setPrev(prev);
                    prev.setNext(next);
                }
            }

            foundNode = null;
            success = true;
        }

        return success;
    }

    boolean isEmpty() {
        return root == null;
    }

    String traverse() {
        final StringBuilder sb = new StringBuilder();

        Node<V> current = root;

        while (current != null) {
            sb.append(" ").append(current.getValue());

            current = current.getNext();
        }

        current = last;

        sb.append(" [");
        while (current != null) {
            sb.append(" ").append(current.getValue());

            current = current.getPrev();
        }

        sb.append("]");

        return sb.toString();
    }

    // PRIVATE METHODS

    private void addAfter(@Nullable final Node<V> after, final Node<V> node) {

        if (after == null) {
            // add to the root
            root.setPrev(node);
            node.setNext(root);
            root = node;
        }
        else {
            final Node<V> next = after.getNext();
            node.setNext(next);
            node.setPrev(after);
            after.setNext(node);

            if (next != null) {
                next.setPrev(node);
            }

            if (after == last) {
                last = node;
            }
        }
    }

    private void removeAfter(@Nullable final Node<V> source, final Node<V> node) {

        if (source == null) {
            // remove from the root
            root.setPrev(node);
            node.setNext(root);
            root = node;
        }
        else {
            source.setNext(node);
            node.setPrev(source);

            if (source == last) {
                last = node;
            }
        }
    }

    private int compare(final V v1, final V v2) {

        final int compare;
        if (comparator != null) {
            compare = comparator.compare(v1, v2);
        }
        else {
            compare = v1.compareTo(v2);
        }

        return compare;
    }
}
