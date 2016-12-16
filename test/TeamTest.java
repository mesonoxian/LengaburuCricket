import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;

public class TeamTest {


    @Test
    public void shouldCreateTheTeam() throws Exception {

        Team team = new Team("Lengaburu", Arrays.asList(new Player("Sachin", new TreeMap<>())));
        assertEquals("Lengaburu", team.name());
    }

    @Test
    public void shouldHaveTeamMembersInTeam() throws Exception {

        List<Player> players = Arrays.asList(new Player("Sachin", new TreeMap<>()));

        Team team = new Team("Lengaburu", players);
        assertEquals("Lengaburu", team.name());

    }


}