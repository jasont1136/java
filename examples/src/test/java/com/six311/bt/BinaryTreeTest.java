package com.six311.bt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
public class BinaryTreeTest {

    private static final int[] INT_VALUES = new int[]{6, 2, 8, 4, 5, 3, 9, 10};
    private static final String[] STR_VALUES = new String[]{"F", "J", "B", "S", "D", "A", "K", "E", "C", "W"};

    @Test
    public void testBinaryTree_prettyPrint() {

        {
            final BinaryTree<Integer> bt = createIntBinaryTree();
            bt.prettyPrint();
        }

        {
            final BinaryTree<String> bt = createStringBinaryTree();
            bt.prettyPrint();
        }

    }

    @Test
    public void testBinaryTree_traverse() {

        {
            final BinaryTree<Integer> bt = createIntBinaryTree();

            final String sorted = bt.traverse();

            assertEquals(" 2 3 4 5 6 8 9 10", sorted);
        }

        {
            final BinaryTree<String> bt = createStringBinaryTree();

            final String sorted = bt.traverse();

            assertEquals(" A B C D E F J K S W", sorted);
        }
    }

    @Test
    public void testBinaryTree_delete() {

        {
            final BinaryTree<Integer> bt = createIntBinaryTree();

            assertTrue(bt.contains(10));

            bt.delete(10);

            assertFalse(bt.contains(10));
            assertFalse(bt.contains(13));

            bt.delete(13);

            assertFalse(bt.contains(13));
        }

        {
            final BinaryTree<String> bt = createStringBinaryTree();

            assertTrue(bt.contains("S"));

            bt.delete("S");

            assertFalse(bt.contains("S"));
            assertFalse(bt.contains("Q"));

            bt.delete("Q");

            assertFalse(bt.contains("Q"));
        }

    }

    private BinaryTree<Integer> createIntBinaryTree() {

        final BinaryTree<Integer> bt = new BinaryTree<>();

        for (final int value : INT_VALUES) {
            bt.add(value);
        }

        return bt;
    }

    private BinaryTree<String> createStringBinaryTree() {
        final BinaryTree<String> bt = new BinaryTree<>();

        for (final String value : STR_VALUES) {
            bt.add(value);
        }

        return bt;
    }
}
