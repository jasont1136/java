package com.six311.bt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
public class BinaryTreeTest {

    private static final int[] VALUES = new int[]{6, 2, 8, 4, 5, 3, 9, 10};

    @Test
    public void testBinaryTree_prettyPrint() {

        final BinaryTree bt = createBinaryTree();

        bt.prettyPrint();
    }

    @Test
    public void testBinaryTree_traverse() {

        final BinaryTree bt = createBinaryTree();

        final String sorted = bt.traverse();

        final StringBuilder sb = new StringBuilder();
        Arrays.stream(VALUES).sorted().forEach(x -> sb.append(" ").append(x));
        System.out.println(sb);

        assertEquals(sb.toString(), sorted);
    }

    @Test
    public void testBinaryTree_contains() {

        final BinaryTree bt = createBinaryTree();

        assertTrue(bt.contains(10));
        assertFalse(bt.contains(13));
    }

    @Test
    public void testBinaryTree_delete() {

        final BinaryTree bt = createBinaryTree();

        assertTrue(bt.contains(10));

        bt.delete(10);

        assertFalse(bt.contains(10));
        assertFalse(bt.contains(13));

        bt.delete(13);

        assertFalse(bt.contains(13));

    }

    private BinaryTree createBinaryTree() {

        final BinaryTree bt = new BinaryTree();

        for (final int value : VALUES) {
            bt.add(value);
        }

        return bt;
    }
}
