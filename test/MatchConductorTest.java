import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

/***
 *
 * TODO : Could have been solved using the mock test, But not done due to time constraint, and believe have tested downstream modules well
 */

public class MatchConductorTest {

    @Test
    public void shouldConductMatchTillMatchEnd() throws Exception {

        TreeMap<Integer, Integer> shotSelectionStrategy = new TreeMap<>();
        shotSelectionStrategy.put(5, 0);
        shotSelectionStrategy.put(35, 1);
        shotSelectionStrategy.put(60, 2);
        shotSelectionStrategy.put(70, 3);
        shotSelectionStrategy.put(85, 4);
        shotSelectionStrategy.put(86, 5);
        shotSelectionStrategy.put(95, 6);
        shotSelectionStrategy.put(100, 7);


        Team battingTeam = new Team("lengaburu", Arrays.asList(new Player("Virat", shotSelectionStrategy), new Player("Sachin", shotSelectionStrategy), new Player("Rahul", shotSelectionStrategy)));
        Team bowlingTeam = new Team("enchai", Arrays.asList(new Player("Murali", shotSelectionStrategy), new Player("Sanath", shotSelectionStrategy)));
        MatchStats matchStats = new MatchStats(Arrays.asList(battingTeam, bowlingTeam), 6, 12, 2);

        List<String> commentary = new MatchConductor(matchStats).startMatch();

        assertTrue(commentary.size() > 2);

    }
}