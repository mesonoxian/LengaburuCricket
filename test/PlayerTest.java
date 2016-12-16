import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void shouldCreateTheBatsmanAndReturnBatsmanNameOnAsking() throws Exception {

        Player batsman = new Player("Virat", new TreeMap<>());
        assertEquals("Virat", batsman.name());
    }

    @Test
    public void shouldAddCriteriaForThePlayerAndBatAccordingToThePlayer() {

        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        viratProability.put(5, 0);
        viratProability.put(35, 1);
        viratProability.put(60, 2);
        viratProability.put(70, 3);
        viratProability.put(85, 4);
        viratProability.put(86, 5);
        viratProability.put(95, 6);
        viratProability.put(100, 7);

        Player batsman = new Player("Virat", viratProability);
        int runScored = batsman.bat(36);

        assertEquals(runScored, 2);

    }

    @Test
    public void shouldIncreaseTheBallsFacedAndRunsScoredAndReturnWhenAsked() {

        TreeMap<Integer, Integer> viratProability = new TreeMap<>();

        Player batsman = new Player("Virat", viratProability);
        batsman.increaseBallsFaced();
        batsman.increaseRunsScored(3);

        assertEquals(batsman.runsScored(), 3);
        assertEquals(batsman.ballsFaced(), 1);

    }

    @Test
    public void batsmanShouldBeInYetToBatStateInitially() {

        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        Player batsman = new Player("Virat", viratProability);

        assertEquals(batsman.status(), Status.NOT_BATTING);

    }

    @Test
    public void batsmanChangeStatusToOut() {

        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        Player batsman = new Player("Virat", viratProability);

        batsman.status(Status.OUT);

        assertEquals(batsman.status(), Status.OUT);


    }

    @Test
    public void shouldIncreaseRunScored() throws Exception {
        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        Player batsman = new Player("Virat", viratProability);

        batsman.increaseRunsScored(1);

        assertEquals(1, batsman.runsScored());
    }

    @Test
    public void shouldIncreaseBallsFaced() throws Exception {
        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        Player batsman = new Player("Virat", viratProability);

        batsman.increaseBallsFaced();

        assertEquals(1, batsman.ballsFaced());
    }

    @Test
    public void shouldChangeStatus() throws Exception {
        TreeMap<Integer, Integer> viratProability = new TreeMap<>();
        Player batsman = new Player("Virat", viratProability);

        batsman.status(Status.BATTING);

        assertEquals(Status.BATTING, batsman.status());
    }
}