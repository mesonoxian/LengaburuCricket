import java.util.EnumSet;
import java.util.function.Predicate;

public enum Score {

    ZERO(0, new OddScoreRules()),
    ONE(1, new OddScoreRules()),
    TWO(2, new EvenScoreRules()),
    THREE(3, new OddScoreRules()),
    FOUR(4, new EvenScoreRules()),
    FIVE(5, new OddScoreRules()),
    SIX(6, new EvenScoreRules()),
    OUT(7, new OutRules());

    private final Integer numberRepresentation;
    private GameRules rules;

    Score(Integer numberRepresentation, GameRules rules) {
        this.numberRepresentation = numberRepresentation;
        this.rules = rules;
    }


    static Score getScoreByNumberRepresentation(Integer numberRepresentation) {

        EnumSet<Score> scores = EnumSet.allOf(Score.class);
        Predicate<Score> numberRepresentationPredicate = score -> score.getNumberRepresentation().equals(numberRepresentation);

        return scores.stream()
                .filter(numberRepresentationPredicate)
                .findFirst()
                .get();

    }

    public Integer getNumberRepresentation() {
        return numberRepresentation;
    }


    public GameRules getRules() {
        return rules;
    }
}
