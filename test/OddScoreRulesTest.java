import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;

public class OddScoreRulesTest {


    private OddScoreRules oddScoreRules;

    private MatchStats matchStats;


    @Before
    public void setUp() throws Exception {

        Team battingTeam = new Team("lengaburu", Arrays.asList(new Player("Virat", new TreeMap<>()), new Player("Sachin", new TreeMap<>()), new Player("Rahul", new TreeMap<>())));
        Team bowlingTeam = new Team("enchai", Arrays.asList(new Player("Murali", new TreeMap<>()), new Player("Sanath", new TreeMap<>())));
        matchStats = new MatchStats(Arrays.asList(battingTeam, bowlingTeam), 12, 20, 2);

        oddScoreRules = new OddScoreRules();
    }

    @Test
    public void shouldIncreaseTheScoreByOneRunsAAndBallsByOneOnScoreBoard() throws Exception {

        MatchStats matchStats = oddScoreRules.execute(this.matchStats, Score.ONE);

        assertEquals(20 - 1, Math.toIntExact(matchStats.runsRemaining()));
        assertEquals(12 - 1, Math.toIntExact(matchStats.ballsRemaining()));
    }

    @Test
    public void shouldChangeStrikeAsItEvenScoreAndNotOverChange() throws Exception {

        assertEquals("Virat", matchStats.strikingBatsmanName());

        MatchStats matchStats = oddScoreRules.execute(this.matchStats, Score.ONE);

        assertEquals("Sachin", matchStats.strikingBatsmanName());
        assertEquals("Virat", matchStats.nonStrikingBatsmanName());
    }

    @Test
    public void shouldChangeTheStrikingPlayerRunsAndScoreByTwoAndOne() throws Exception {

        MatchStats matchStats = oddScoreRules.execute(this.matchStats, Score.ONE);

        assertEquals(1, matchStats.nonStrikingBatsman().ballsFaced());
        assertEquals(1, matchStats.nonStrikingBatsman().runsScored());

    }

}