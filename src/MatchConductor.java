import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MatchConductor {

    private final Integer TOTAL_PROABILITY = 100;
    private MatchStats matchStats;

    private Random randomGenerator = new Random();


    MatchConductor(MatchStats matchStats) {
        this.matchStats = matchStats;
    }


    private List<String> commentaryOnBattingTeamWin() {

        ArrayList<String> comments = new ArrayList<>();
        comments.addAll(matchStats.battingTeam().summary());
        comments.add(CommentaryEngine.commentBattingTeamWin(matchStats.battingTeamName(), matchStats.wicketsLeft(), matchStats.ballsRemaining()));

        return comments;
    }

    private List<String> commentaryOnBowlingTeamWin() {

        ArrayList<String> comments = new ArrayList<>();
        comments.addAll(matchStats.battingTeam().summary());
        comments.add(CommentaryEngine.commentBowlingTeamWin(matchStats.bowlingTeamName(), matchStats.runsRemaining()));

        return comments;
    }

    List<String> startMatch() {

        matchStats.comment(CommentaryEngine.matchStarted());

        while (!matchStats.isMatchOver()) {

            Score score = Score.getScoreByNumberRepresentation(matchStats.bat(randomGenerator.nextInt(TOTAL_PROABILITY)));
            score.getRules().execute(matchStats, score);
        }

        matchStats.comment(CommentaryEngine.matchSummary());
        matchStats.comments(matchStats.hasBattingTeamWon() ? commentaryOnBattingTeamWin() : commentaryOnBowlingTeamWin());

        return matchStats.comments();
    }


}
