import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 *   JOB : Handles all the score manipulation functionality
 */

class MatchStats {

    private final Integer NO_OF_BALLS_IN_OVER = 6;
    private final Integer ZERO = 0;
    private final Integer ONE = 1;
    private final Integer totalWickets;
    private final Integer balls;
    private final Integer runsToWin;
    private Team battingTeam;
    private Team bowlingTeam;
    private Player strikingBatsman;
    private Player nonStrikingBatsman;
    private Integer ballsBowled;
    private Integer runsScored;
    private Integer wicketsFallen;

    private List<String> commentary;


    MatchStats(List<Team> teams, Integer balls, Integer runsToWin, Integer wicketsLeft) {

        this.battingTeam = teams.get(0);
        this.bowlingTeam = teams.get(1);

        this.totalWickets = wicketsLeft;
        this.balls = balls;
        this.runsToWin = runsToWin;

        this.strikingBatsman = battingTeam.getNextPlayer();
        this.nonStrikingBatsman = battingTeam.getNextPlayer();

        this.ballsBowled = ZERO;
        this.runsScored = ZERO;
        this.wicketsFallen = ZERO;

        this.commentary = new ArrayList<String>();
    }


    public String bowlingTeamName() {
        return bowlingTeam.name();
    }

    public String battingTeamName() {
        return battingTeam.name();
    }

    public String strikingBatsmanName() {
        return strikingBatsman.name();
    }

    public String nonStrikingBatsmanName() {
        return nonStrikingBatsman.name();
    }


    public MatchStats runScored(Integer runsScored) {
        this.increaseOver().increaseRun(runsScored);
        return this;
    }

    private MatchStats increaseOver() {
        this.ballsBowled = ballsBowled + ONE;
        this.strikingBatsman.increaseBallsFaced();
        return this;
    }

    private MatchStats increaseRun(Integer run) {
        this.runsScored = runsScored + run;
        this.strikingBatsman.increaseRunsScored(run);
        return this;
    }

    public Player strikingBatsman() {
        return strikingBatsman;
    }

    public Integer ballsRemaining() {
        return balls - ballsBowled;

    }

    public Integer runsRemaining() {
        return runsToWin - runsScored;
    }

    public MatchStats changeStrike() {
        Player exchangeStrikeTempPlayer = strikingBatsman;
        strikingBatsman = nonStrikingBatsman;
        nonStrikingBatsman = exchangeStrikeTempPlayer;
        return this;
    }

    public Boolean isOverChange() {
        return (ballsBowled % NO_OF_BALLS_IN_OVER) == ZERO;
    }

    public MatchStats wicketFallen() {
        this.wicketsFallen = this.wicketsFallen + ONE;
        strikingBatsman.increaseBallsFaced();
        strikingBatsman.status(Status.OUT);
        return this;
    }

    public Integer wicketsLeft() {
        return totalWickets - wicketsFallen;
    }

    public Boolean isAllOUT() {
        return Objects.equals(wicketsFallen, totalWickets);
    }

    public Boolean hasReachedTarget() {
        return runsScored > runsToWin;
    }

    public Boolean isInningsOverComplete() {
        return ballsBowled >= balls;
    }

    public Boolean isMatchOver() {
        return isInningsOverComplete() || isAllOUT() || hasReachedTarget();
    }

    public Boolean hasBattingTeamWon() {
        return hasReachedTarget();
    }

    public Double currentOver() {
        return ballsBowled < NO_OF_BALLS_IN_OVER ? (new Double(ballsBowled) / 10) : (ballsBowled / NO_OF_BALLS_IN_OVER) + (new Double((ballsBowled % NO_OF_BALLS_IN_OVER)) / 10);
    }

    public Integer oversLeft() {
        Integer leftBalls = balls - ballsBowled;
        Double oversLeft = (leftBalls / NO_OF_BALLS_IN_OVER) + ((double) (leftBalls % NO_OF_BALLS_IN_OVER) / 10);
        return oversLeft.intValue();
    }


    public MatchStats nextBatsman() {

        if (!isAllOUT()) {
            strikingBatsman = battingTeam.getNextPlayer();
        }
        return this;

    }

    public Integer bat(Integer battingStrike) {
        return strikingBatsman.bat(battingStrike);
    }

    public Team battingTeam() {
        return battingTeam;
    }

    public MatchStats comment(String comment) {
        this.commentary.add(comment);
        return this;
    }

    public MatchStats comments(List<String> comments) {
        this.commentary.addAll(comments);
        return this;
    }

    public List<String> comments() {
        return commentary;
    }

    public Player nonStrikingBatsman() {
        return nonStrikingBatsman;
    }
}
