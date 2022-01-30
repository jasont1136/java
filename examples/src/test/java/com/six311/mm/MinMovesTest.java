package com.six311.mm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jasontewhau
 * @since 1/31/22
 */
public class MinMovesTest {

    @Test
    void testMinMoves() {
        {
            final int moves = MinMoves.apply(5, 0);

            assertEquals(4, moves);
        }

        {
            final int moves = MinMoves.apply(19, 2);

            assertEquals(7, moves);
        }

        {
            final int moves = MinMoves.apply(10, 4);

            assertEquals(4, moves);
        }

    }
}
