import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ScoreTest {

    @Test
    public void getScoreByItsNumberRepresentation() throws Exception {

        assertEquals(Score.ZERO, Score.getScoreByNumberRepresentation(0));
        assertEquals(Score.ONE, Score.getScoreByNumberRepresentation(1));
        assertEquals(Score.TWO, Score.getScoreByNumberRepresentation(2));
        assertEquals(Score.THREE, Score.getScoreByNumberRepresentation(3));
        assertEquals(Score.FOUR, Score.getScoreByNumberRepresentation(4));
        assertEquals(Score.FIVE, Score.getScoreByNumberRepresentation(5));
        assertEquals(Score.SIX, Score.getScoreByNumberRepresentation(6));
        assertEquals(Score.OUT, Score.getScoreByNumberRepresentation(7));
    }

    @Test
    public void getRulesByItsNumber() throws Exception {

        assertEquals(OddScoreRules.class, Score.ZERO.getRules().getClass());
        assertEquals(OddScoreRules.class, Score.ONE.getRules().getClass());
        assertEquals(EvenScoreRules.class, Score.TWO.getRules().getClass());
        assertEquals(OddScoreRules.class, Score.THREE.getRules().getClass());
        assertEquals(EvenScoreRules.class, Score.FOUR.getRules().getClass());
        assertEquals(OddScoreRules.class, Score.FIVE.getRules().getClass());
        assertEquals(EvenScoreRules.class, Score.SIX.getRules().getClass());
        assertEquals(OutRules.class, Score.OUT.getRules().getClass());
    }
}