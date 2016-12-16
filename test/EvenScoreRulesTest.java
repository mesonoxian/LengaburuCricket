import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;

public class EvenScoreRulesTest {

    private EvenScoreRules evenScoreRules;

    private MatchStats matchStats;


    @Before
    public void setUp() throws Exception {

        Team battingTeam = new Team("lengaburu", Arrays.asList(new Player("Virat", new TreeMap<>()), new Player("Sachin", new TreeMap<>()), new Player("Rahul", new TreeMap<>())));
        Team bowlingTeam = new Team("enchai", Arrays.asList(new Player("Murali", new TreeMap<>()), new Player("Sanath", new TreeMap<>())));
        matchStats = new MatchStats(Arrays.asList(battingTeam, bowlingTeam), 12, 20, 2);

        evenScoreRules = new EvenScoreRules();
    }

    @Test
    public void shouldIncreaseTheScoreByTwoRunsAAndBallsByOneOnScoreBoard() throws Exception {

        MatchStats matchStats = evenScoreRules.execute(this.matchStats, Score.TWO);

        assertEquals(20 - 2, Math.toIntExact(matchStats.runsRemaining()));
        assertEquals(12 - 1, Math.toIntExact(matchStats.ballsRemaining()));
    }

    @Test
    public void shouldNotChangeStrikeAsItEvenScoreAndNotOverChange() throws Exception {

        MatchStats matchStats = evenScoreRules.execute(this.matchStats, Score.TWO);
        assertEquals("Virat", matchStats.strikingBatsmanName());
    }

    @Test
    public void shouldChangeTheStrikingPlayerRunsAndScoreByTwoAndOne() throws Exception {

        MatchStats matchStats = evenScoreRules.execute(this.matchStats, Score.TWO);

        assertEquals(1, matchStats.strikingBatsman().ballsFaced());
        assertEquals(2, matchStats.strikingBatsman().runsScored());

    }
}