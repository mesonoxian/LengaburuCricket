import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Integer overs = 4;
        Integer balls = overs * 6;

        Integer runsToWin = 40;


        TreeMap<Integer, Integer> viratShotSelectionStrategy = new TreeMap<>();
        viratShotSelectionStrategy.put(5, 0);
        viratShotSelectionStrategy.put(35, 1);
        viratShotSelectionStrategy.put(60, 2);
        viratShotSelectionStrategy.put(70, 3);
        viratShotSelectionStrategy.put(85, 4);
        viratShotSelectionStrategy.put(86, 5);
        viratShotSelectionStrategy.put(95, 6);
        viratShotSelectionStrategy.put(100, 7);

        TreeMap<Integer, Integer> rahulShotSelectionStrategy = new TreeMap<>();
        rahulShotSelectionStrategy.put(10, 0);
        rahulShotSelectionStrategy.put(50, 1);
        rahulShotSelectionStrategy.put(70, 2);
        rahulShotSelectionStrategy.put(75, 3);
        rahulShotSelectionStrategy.put(85, 4);
        rahulShotSelectionStrategy.put(86, 5);
        rahulShotSelectionStrategy.put(90, 6);
        rahulShotSelectionStrategy.put(100, 7);

        TreeMap<Integer, Integer> sachinShotSelectionStrategy = new TreeMap<>();
        sachinShotSelectionStrategy.put(20, 0);
        sachinShotSelectionStrategy.put(50, 1);
        sachinShotSelectionStrategy.put(65, 2);
        sachinShotSelectionStrategy.put(70, 3);
        sachinShotSelectionStrategy.put(75, 4);
        sachinShotSelectionStrategy.put(76, 5);
        sachinShotSelectionStrategy.put(80, 6);
        sachinShotSelectionStrategy.put(100, 7);

        TreeMap<Integer, Integer> dhoniShotSelectionStrategy = new TreeMap<>();
        dhoniShotSelectionStrategy.put(30, 0);
        dhoniShotSelectionStrategy.put(55, 1);
        dhoniShotSelectionStrategy.put(60, 2);
        dhoniShotSelectionStrategy.put(60, 3);
        dhoniShotSelectionStrategy.put(65, 4);
        dhoniShotSelectionStrategy.put(66, 5);
        dhoniShotSelectionStrategy.put(75, 6);
        dhoniShotSelectionStrategy.put(100, 7);


        Player virat = new Player("Virat", viratShotSelectionStrategy);
        Player nodhi = new Player("Rahul", rahulShotSelectionStrategy);
        Player shashi = new Player("Sachin", sachinShotSelectionStrategy);
        Player abhi = new Player("Dhoni", dhoniShotSelectionStrategy);

        Team lengaburu = new Team("Lengaburu", Arrays.asList(virat, nodhi, shashi, abhi));
        Team enchai = new Team("Enchai", Collections.emptyList());

        MatchStats matchStats = new MatchStats(Arrays.asList(lengaburu, enchai), balls, runsToWin, 3);

        List<String> commentary = new MatchConductor(matchStats).startMatch();

        commentary
                .stream()
                .filter(comment -> !comment.isEmpty())
                .forEach(System.out::println);

    }
}
