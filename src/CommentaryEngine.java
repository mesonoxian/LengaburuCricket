public class CommentaryEngine {

    static String commentRun(String player, Integer run, Double bowlsInOver) {
        String runsPluralOrSingular = run > 1 ? "runs" : "run";
        return String.format("%s %s scores %s %s", bowlsInOver, player, run, runsPluralOrSingular);
    }

    static String commentOut(String player, Double bowlsInOver) {
        return String.format("%s %s is out", bowlsInOver, player);
    }

    static String overSummary(Integer overLeft, Integer runsLeft) {
        return String.format("\n%d overs left. %s runs to win \n", overLeft, runsLeft);
    }

    static String commentBattingTeamWin(String teamName, Integer wicketsLeft, Integer ballsRemaining) {
        return String.format("\n%s won by %d wicket and %d balls remaining", teamName, wicketsLeft, ballsRemaining);
    }

    static String commentBowlingTeamWin(String teamName, Integer runsRemaining) {
        return String.format("\n%s won by %d runs", teamName, runsRemaining);
    }

    public static String matchStarted() {
        return "Match Started\n";
    }

    public static String matchSummary() {
        return "\nMatch Summary\n";
    }
}
