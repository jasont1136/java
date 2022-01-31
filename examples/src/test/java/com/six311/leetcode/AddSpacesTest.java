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

    }
}
