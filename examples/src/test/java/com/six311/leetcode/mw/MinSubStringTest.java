package com.six311.leetcode.mw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinSubStringTest {

    @Test
    public void testMinWindow() {
        {
            final String result = MinSubString.apply("asdfcdeajkcaekl", "ace");

            assertEquals("cae", result);
        }

        {
            final String result = MinSubString.apply("aasdecdeajkcekla", "aace");

            assertEquals("ecdea", result);
        }

        {
            final String result = MinSubString.apply("eacaasdecadeajkcekla", "ace");

            assertEquals("eac", result);
        }
    }
}
