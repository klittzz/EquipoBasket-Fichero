package main.model.team.player;

public class ShootingGuard extends Player{

    public ShootingGuard(String name, byte dorsal, short height, byte skill) {
        super(name, dorsal, height, skill);    }

    @Override
    public short generatePoints() {
        return (short)(Math.random()*25 + 15);
    }

    @Override
    public String toString() {
        return "El escolta " + super.toString();
    }
}
