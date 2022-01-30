package com.six311.mw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
public class MinWindowTest {

    @Test
    public void testMinWindow() {
        {
            final String result = MinWindow.apply("asdfcdeajkcaekl", "ace");

            assertEquals("cae", result);
        }

        {
            final String result = MinWindow.apply("aasdecdeajkcekla", "aace");

            assertEquals("ecdea", result);
        }

        {
            final String result = MinWindow.apply("eacaasdecadeajkcekla", "ace");

            assertEquals("eac", result);
        }
    }
}
