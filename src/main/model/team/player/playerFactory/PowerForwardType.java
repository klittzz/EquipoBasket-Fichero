package main.model.team.player.playerFactory;
import main.model.team.player.Player;
import main.model.team.player.PowerForward;

public class PowerForwardType implements PlayerType{

    @Override
    public Player createPlayer(String name, byte dorsal, short height, byte skill) {
        return new PowerForward(name, dorsal, height, skill);
    }
}
