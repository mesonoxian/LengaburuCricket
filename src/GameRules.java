public interface GameRules {

    MatchStats execute(MatchStats matchStats, Score score);

    default String overChange(MatchStats matchStats) {

        if (matchStats.isOverChange() && !matchStats.isMatchOver()) {
            matchStats.changeStrike();
            return CommentaryEngine.overSummary(matchStats.oversLeft(), matchStats.runsRemaining());
        }

        return "";
    }
}
