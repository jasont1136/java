package com.six311.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddSpacesTest {

    @Test
    public void testAddSpaces() {

        {
            final String result = AddSpaces.apply("EnjoyYourCoffee", new int[]{5, 9});

            assertEquals("Enjoy Your Coffee", result);
        }

        {
            final String result = AddSpaces.apply("LeetcodeHelpsMeLearn", new int[]{8, 13, 15});

            assertEquals("Leetcode Helps Me Learn", result);
        }

        {
            final String result = AddSpaces.apply("spacing", new int[]{1, 2, 3, 4, 5, 6});

            assertEquals("s p a c i n g", result);
        }
    }
}
