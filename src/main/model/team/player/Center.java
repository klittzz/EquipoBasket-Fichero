package main.model.team.player;

public class Center extends Player{

    public Center(String name, byte dorsal, short height, byte skill) {
        super(name, dorsal, height, skill);
    }

    @Override
    public short generatePoints() {
        return (short)(Math.random()*20 + 10);
    }

    @Override
    public String toString() {
        return "El pivot " + super.toString();
    }


}