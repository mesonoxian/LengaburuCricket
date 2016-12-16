import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Job : Handles all batsman related details and scoring strategy of batsman
 */

class Player {

    private String name;
    private NavigableMap<Integer, Integer> battingStrategy;

    private int ballsFaced = 0;
    private int runsScored = 0;

    private Status status = Status.NOT_BATTING;

    Player(String name, TreeMap<Integer, Integer> battingStrategy) {

        this.name = name;
        this.battingStrategy = battingStrategy;
    }

    public String name() {
        return this.name;
    }


    public Integer bat(Integer shotSelectionStrategy) {
        Map.Entry<Integer, Integer> shotSelected = battingStrategy.ceilingEntry(shotSelectionStrategy);
        return shotSelected.getValue();
    }

    public Player increaseRunsScored(Integer value) {
        this.runsScored = runsScored + value;
        return this;
    }

    public Player increaseBallsFaced() {
        this.ballsFaced = ballsFaced + 1;
        return this;
    }

    public int runsScored() {
        return this.runsScored;
    }

    public int ballsFaced() {
        return this.ballsFaced;
    }


    public Status status() {
        return status;
    }

    public Player status(Status status) {
        this.status = status;
        return this;
    }

    public String printSummary() {
        return (status == Status.BATTING) ? String.format("%s - %s*(%s ball)", name(), runsScored(), ballsFaced()) : String.format("%s - %s(%s ball)", name(), runsScored(), ballsFaced());
    }
}
