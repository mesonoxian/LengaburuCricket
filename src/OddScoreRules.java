public class OddScoreRules implements GameRules {

    @Override
    public MatchStats execute(MatchStats matchStats, Score score) {

        matchStats
                .runScored(score.getNumberRepresentation())
                .comment(CommentaryEngine.commentRun(matchStats.strikingBatsmanName(), score.getNumberRepresentation(), matchStats.currentOver()))
                .changeStrike()
                .comment(overChange(matchStats));

        return matchStats;
    }
}
