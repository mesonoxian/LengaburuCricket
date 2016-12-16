import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CommentaryEngineTest {

    @Test
    public void shouldReturnMatchStartedAndMatchSummary() throws Exception {
        assertEquals("Match Started\n", CommentaryEngine.matchStarted());
        assertEquals("\nMatch Summary\n", CommentaryEngine.matchSummary());
    }


    @Test
    public void shouldCommentRunBasedOnNumOfRun() throws Exception {
        assertEquals("0.1 Virat scores 1 run", CommentaryEngine.commentRun("Virat", 1, 0.1));
        assertEquals("0.2 Virat scores 2 runs", CommentaryEngine.commentRun("Virat", 2, 0.2));
    }

    @Test
    public void shouldReturnCommentOnBattingTeamWinAndBowlingTeamWin() throws Exception {

        assertEquals("\nLengaburu won by 1 wicket and 1 balls remaining", CommentaryEngine.commentBattingTeamWin("Lengaburu", 1, 1));
        assertEquals("\nLengaburu won by 2 runs", CommentaryEngine.commentBowlingTeamWin("Lengaburu", 2));
    }

    @Test
    public void shouldCommentOut() throws Exception {
        assertEquals("0.1 Virat is out", CommentaryEngine.commentOut("Virat", 0.1));
    }

    @Test
    public void shouldCommentOverSummary() throws Exception {
        assertEquals("\n1 overs left. 10 runs to win \n", CommentaryEngine.overSummary(1, 10));
    }
}