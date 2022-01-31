package com.six311.collections;

import com.six311.model.Node;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class BinaryTree<V extends Comparable<V>> {

    private Node<V> root;

    public BinaryTree() {
      this.root = null;
    }

    public void add(final V value) {
        root = addRecursive(root, value);
    }

    public boolean contains(final V value) {
        return containsRecursive(root, value);
    }

    public String traverse() {
        final StringBuilder sb = new StringBuilder();
        traverseRecursive(root, sb);
        return sb.toString();
    }

    public void delete(final V value) {
        deleteRecursive(root, value);
    }

    public void prettyPrint() {
        prettyPrintRecursive(root, "", true);
    }

    // PRIVATE METHODS

    private boolean containsRecursive(@Nullable final Node<V> current, final V value) {

        if (current == null) {
            return false;
        }

        final int compare = value.compareTo(current.getValue());

        final boolean result;

        if (compare == 0) {
            result = true;
        }
        else if (compare < 0) {
            result = containsRecursive(current.getLeft(), value);
        }
        else {
            result = containsRecursive(current.getRight(), value);
        }

        return result;
    }

    @Nonnull
    private Node<V> addRecursive(@Nullable final Node<V> current, final V value) {

        if (current == null) {
            return new Node<>(value);
        }

        final int compare = value.compareTo(current.getValue());

        if (compare < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (compare > 0) {
            current.setRight(addRecursive(current.getRight(), value));
        }
        // else {
        //     value already present so nothing to do
        // }

        return current;
    }

    private void traverseRecursive(@Nullable final Node<V> node, final StringBuilder sb) {
        if (node != null) {
            traverseRecursive(node.getLeft(), sb);
            sb.append(" ").append(node.getValue());
            traverseRecursive(node.getRight(), sb);
        }
    }

    @Nullable
    private Node<V> deleteRecursive(@Nullable final Node<V> current, final V value) {

        if (current == null) {
            return null;
        }

        final int compare = value.compareTo(current.getValue());

        if (compare == 0) {

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            else if (current.getRight() == null) {
                return current.getLeft();
            }
            else if (current.getLeft() == null) {
                return current.getRight();
            }
            else {

                final V smallestValue = findSmallestValue(current.getRight());
                current.setValue(smallestValue);
                current.setRight(deleteRecursive(current.getRight(), smallestValue));

                return current;
            }
        }
        else {

            if (compare < 0) {
                current.setLeft(deleteRecursive(current.getLeft(), value));
                return current;
            } else {
                current.setRight(deleteRecursive(current.getRight(), value));
                return current;
            }
        }
    }

    private void prettyPrintRecursive(@Nullable final Node<V> current, final String prefix, final boolean isLeft) {

        if (current == null) {
            return;
        }

        if (current.getRight() != null) {
            prettyPrintRecursive(current.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + current.getValue());

        if (current.getLeft() != null) {
            prettyPrintRecursive(current.getLeft(), prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    private V findSmallestValue(final Node<V> node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }
}
