import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Job : Handles all the team related.
 */

class Team {

    private String name;
    private List<Player> players;

    Team(String name, List<Player> players) {

        this.name = name;
        this.players = players;
    }

    String name() {
        return name;
    }


    Player getNextPlayer() {

        Predicate<Player> findPlayer = player -> player.status().equals(Status.NOT_BATTING);

        Function<Player, Player> changeStateToBatting = player -> {
            player.status(Status.BATTING);
            return player;
        };

        return players.stream()
                .filter(findPlayer)
                .findFirst()
                .map(changeStateToBatting)
                .get();

    }

    public List<String> summary() {
        return players.stream()
                .map(Player::printSummary)
                .collect(Collectors.toList());
    }
}
