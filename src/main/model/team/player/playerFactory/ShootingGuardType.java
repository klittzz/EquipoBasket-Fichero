package main.model.team.player.playerFactory;
import main.model.team.player.Player;
import main.model.team.player.ShootingGuard;

public class ShootingGuardType implements PlayerType{

    @Override
    public Player createPlayer(String name, byte dorsal, short height, byte skill) {
        return new ShootingGuard(name, dorsal, height, skill);
    }
}
