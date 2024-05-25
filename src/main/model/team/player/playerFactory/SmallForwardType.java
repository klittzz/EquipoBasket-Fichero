package main.model.team.player.playerFactory;
import main.model.team.player.Player;
import main.model.team.player.SmallForward;

public class SmallForwardType implements PlayerType{

    @Override
    public Player createPlayer(String name, byte dorsal, short height, byte skill) {
        return new SmallForward(name, dorsal, height, skill);
    }
}
