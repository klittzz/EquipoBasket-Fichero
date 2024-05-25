package main.model.team.player.playerFactory;

import main.model.team.player.Center;
import main.model.team.player.Player;

public class CenterType implements PlayerType{

    @Override
    public Player createPlayer(String name, byte dorsal, short height, byte skill) {
        return new Center(name, dorsal, height, skill);
    }

}
