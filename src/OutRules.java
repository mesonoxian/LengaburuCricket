public class OutRules implements GameRules {
    @Override
    public MatchStats execute(MatchStats matchStats, Score numberRepresentation) {

        matchStats
                .runScored(0)
                .wicketFallen()
                .comment(CommentaryEngine.commentOut(matchStats.strikingBatsmanName(), matchStats.currentOver()))
                .nextBatsman()
                .comment(overChange(matchStats));

        return matchStats;
    }
}
