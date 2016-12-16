import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static junit.framework.TestCase.*;

public class MatchStatsTest {

    private MatchStats matchStats;

    private Integer runsToWin = 40;
    private Integer wicketsLeft = 2;
    private Integer ballsRemaining = 24;


    @Before
    public void setUp() throws Exception {
        Team battingTeam = new Team("lengaburu", Arrays.asList(new Player("Virat", new TreeMap<>()), new Player("Sachin", new TreeMap<>()), new Player("Rahul", new TreeMap<>())));
        Team bowlingTeam = new Team("enchai", Arrays.asList(new Player("Murali", new TreeMap<>()), new Player("Sanath", new TreeMap<>())));
        matchStats = new MatchStats(Arrays.asList(battingTeam, bowlingTeam), ballsRemaining, runsToWin, wicketsLeft);
    }

    @Test
    public void shouldReturnTheBattingTeamNameAsLengaburuAndBowlingTeamNameAsEnchai() throws Exception {
        assertEquals("lengaburu", matchStats.battingTeamName());
        assertEquals("enchai", matchStats.bowlingTeamName());
    }

    @Test
    public void shouldReturnStrikingAndNonStrikingBatsmanNameAsViratAndSachinAsRespectively() throws Exception {
        assertEquals("Virat", matchStats.strikingBatsmanName());
        assertEquals("Sachin", matchStats.nonStrikingBatsmanName());
    }

    @Test
    public void shouldIncreaseTheBallByOneAndRunsScoredBySixOnTheStrikingBatsmanOnTheRunScored() throws Exception {

        Integer runScored = 6;

        MatchStats matchStats = this.matchStats.runScored(runScored);

        assertEquals(1, Math.toIntExact(matchStats.strikingBatsman().ballsFaced()));
        assertEquals(Math.toIntExact(runScored), Math.toIntExact(matchStats.strikingBatsman().runsScored()));
    }

    @Test
    public void shouldIncreaseTheBallByOneAndRunsScoredBySixOnTheMatchScoreBoardByCheckingOnBallsRemainingAndRuns() throws Exception {

        Integer runScored = 6;

        MatchStats matchStats = this.matchStats.runScored(runScored);

        assertEquals(ballsRemaining - 1, Math.toIntExact(matchStats.ballsRemaining()));
        assertEquals(runsToWin - runScored, Math.toIntExact(matchStats.runsRemaining()));
    }

    @Test
    public void shouldChangeStrikeOnTheOverChange() throws Exception {

        assertEquals("Virat", matchStats.strikingBatsmanName());
        assertEquals("Sachin", matchStats.nonStrikingBatsmanName());

        this.matchStats.changeStrike();

        assertEquals("Sachin", matchStats.strikingBatsmanName());
        assertEquals("Virat", matchStats.nonStrikingBatsmanName());
    }

    @Test
    public void shouldCheckIsOverChangeAndIsNotChangeAlso() throws Exception {
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);

        assertTrue(matchStats.isOverChange());

        this.matchStats.runScored(1);

        assertFalse(matchStats.isOverChange());
    }

    @Test
    public void shouldIncreaseWicketsFallenAndChangeTheStrikeBatsmanToOutAndIncreaseOnWicketFallen() throws Exception {
        this.matchStats.wicketFallen();

        assertEquals(Status.OUT, this.matchStats.strikingBatsman().status());
        assertEquals(1, Math.toIntExact(this.matchStats.strikingBatsman().ballsFaced()));
        assertEquals(1, Math.toIntExact(this.matchStats.wicketsLeft()));
    }

    @Test
    public void shouldCheckIsTeamAllOut() throws Exception {
        assertFalse(this.matchStats.isAllOUT());

        this.matchStats.wicketFallen();
        this.matchStats.wicketFallen();

        assertTrue(this.matchStats.isAllOUT());

    }

    @Test
    public void shouldCheckHasReachedTarget() throws Exception {

        this.matchStats.runScored(1);

        assertFalse(this.matchStats.hasReachedTarget());

        this.matchStats.runScored(40);

        assertTrue(this.matchStats.hasReachedTarget());
    }

    @Test
    public void shouldCheckIsOverCompleted() throws Exception {
        assertFalse(this.matchStats.isInningsOverComplete());
    }

    @Test
    public void shouldCheckIsMatchOver() throws Exception {

        assertFalse(this.matchStats.isMatchOver());
    }

    @Test
    public void shouldCheckHasBattingTeamWon() throws Exception {

        this.matchStats.runScored(1);

        assertFalse(this.matchStats.hasBattingTeamWon());

        this.matchStats.runScored(40);

        assertTrue(this.matchStats.hasBattingTeamWon());
    }

    @Test
    public void shouldReturnMeCurrentOvers() throws Exception {

        this.matchStats.runScored(1);
        assertEquals(0.1, matchStats.currentOver());

        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        assertEquals(1.0, matchStats.currentOver());

        this.matchStats.runScored(1);
        assertEquals(1.1, matchStats.currentOver());
    }

    @Test
    public void shouldReturnMeOversLeftInTheMatch() throws Exception {

        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);
        this.matchStats.runScored(1);

        assertEquals(3, Math.toIntExact(matchStats.oversLeft()));
    }


    @Test
    public void shouldBringNextBatsManOnCurrentBatsManOut() throws Exception {

        this.matchStats.wicketFallen().nextBatsman();
        assertEquals("Rahul", this.matchStats.strikingBatsmanName());
    }
}