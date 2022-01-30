package com.six311.bt;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public final class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(final int value) {
        root = addRecursive(root, value);
    }

    public boolean contains(final int value) {
        return containsRecursive(root, value);
    }

    public String traverse() {
        final StringBuilder sb = new StringBuilder();
        traverseRecursive(root, sb);
        return sb.toString();
    }

    public void delete(final int value) {
        deleteRecursive(root, value);
    }

    public void prettyPrint() {
        prettyPrintRecursive(root, "", true);
    }

    // PRIVATE METHODS

    private boolean containsRecursive(final Node current, final int value) {

        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }
        else {
            return value < current.value?
                    containsRecursive(current.left, value):
                    containsRecursive(current.right, value);
        }
    }

    private Node addRecursive(final Node current, final int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private void traverseRecursive(final Node node, final StringBuilder sb) {
        if (node != null) {
            traverseRecursive(node.left, sb);
            sb.append(" ").append(node.value);
            traverseRecursive(node.right, sb);
        }
    }

    private Node deleteRecursive(final Node current, final int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {

            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.right == null) {
                return current.left;
            }
            else if (current.left == null) {
                return current.right;
            }
            else {

                final int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);

                return current;
            }
        }
        else {

            if (value < current.value) {
                current.left = deleteRecursive(current.left, value);
                return current;
            } else {
                current.right = deleteRecursive(current.right, value);
                return current;
            }
        }
    }

    private void prettyPrintRecursive(final Node current, final String prefix, final boolean isLeft) {
        if (current == null) {
            return;
        }

        if (current.right != null) {
            prettyPrintRecursive(current.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + current.value);

        if (current.left != null) {
            prettyPrintRecursive(current.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    private int findSmallestValue(final Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }
}
