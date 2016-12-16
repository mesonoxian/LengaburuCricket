public class EvenScoreRules implements GameRules {

    @Override
    public MatchStats execute(MatchStats matchStats, Score score) {

        matchStats
                .runScored(score.getNumberRepresentation())
                .comment(CommentaryEngine.commentRun(matchStats.strikingBatsmanName(), score.getNumberRepresentation(), matchStats.currentOver()))
                .comment(overChange(matchStats));

        return matchStats;
    }

}
