package com.six311.bt;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
final class Node {
    int value;
    Node left;
    Node right;

    Node(final int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}