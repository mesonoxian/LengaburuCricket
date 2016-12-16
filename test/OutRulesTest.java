import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;

public class OutRulesTest {

    private OutRules outRules;

    private MatchStats matchStats;


    @Before
    public void setUp() throws Exception {

        Team battingTeam = new Team("lengaburu", Arrays.asList(new Player("Virat", new TreeMap<>()), new Player("Sachin", new TreeMap<>()), new Player("Rahul", new TreeMap<>())));
        Team bowlingTeam = new Team("enchai", Arrays.asList(new Player("Murali", new TreeMap<>()), new Player("Sanath", new TreeMap<>())));
        matchStats = new MatchStats(Arrays.asList(battingTeam, bowlingTeam), 12, 20, 2);

        outRules = new OutRules();
    }

    @Test
    public void shouldIncreaseTheScoreByZeroRunsAAndBallsByOneAndWicketsGoneByOneOnScoreBoardAndStrikeBatsmanWillBeNew() throws Exception {

        assertEquals("Virat", matchStats.strikingBatsmanName());


        MatchStats matchStats = outRules.execute(this.matchStats, Score.ONE);

        assertEquals(20, Math.toIntExact(matchStats.runsRemaining()));
        assertEquals(12 - 1, Math.toIntExact(matchStats.ballsRemaining()));
        assertEquals(1, Math.toIntExact(matchStats.wicketsLeft()));

        assertEquals("Rahul", matchStats.strikingBatsmanName());

    }

}