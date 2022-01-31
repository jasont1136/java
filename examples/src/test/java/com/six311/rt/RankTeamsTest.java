package com.six311.rt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RankTeamsTest {

    @Test
    public void testRankTeams() {

        {
            final String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};

            final String result = RankTeams.apply(votes);

            assertEquals("ACB", result);
        }

        {
            final String[] votes = new String[]{"WXYZ","XYZW"};

            final String result = RankTeams.apply(votes);

            assertEquals("XWYZ", result);
        }

        {
            final String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB", "BCA"};

            final String result = RankTeams.apply(votes);

            assertEquals("ABC", result);
        }

    }
}
