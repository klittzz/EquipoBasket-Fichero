package main.model.team.player.playerFactory;
import main.model.team.player.Player;
import main.model.team.player.PointGuard;

public class PointGuardType implements PlayerType{

    @Override
    public Player createPlayer(String name, byte dorsal, short height, byte skill) {
        return new PointGuard(name, dorsal, height, skill);
    }
}
