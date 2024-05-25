package main.model.team.player.playerFactory;
import main.model.team.player.Player;

public interface PlayerType {
    Player createPlayer(String name, byte dorsal, short height, byte skill);
}
