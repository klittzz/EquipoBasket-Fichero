package main.model.team.player;

public class PointGuard extends Player{

    public PointGuard(String name, byte dorsal, short height, byte skill) {
        super(name, dorsal, height, skill);    }

    @Override
    public short generatePoints() {
        return (short)(Math.random()*20 + 10);
    }

    @Override
    public String toString() {
        return "El base " + super.toString();
    }
}
