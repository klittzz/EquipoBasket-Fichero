package main.model.team.player;

public abstract class Player {

    private String name;
    private byte dorsal;
    private short height;
    private byte skill;
    private short points;
    
    public Player(String name, byte dorsal, short height, byte skill) {
        this.name = name;
        this.dorsal = dorsal;
        this.height = height;
        this.skill = skill;
    }

    public abstract short generatePoints();

    @Override
    public String toString() {
        return name + ", con el dorsal número " + dorsal + ", una altura de " + height + " cm, una habilidad de " + skill + " estrellas, y cuenta con " + points + " puntos.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getDorsal() {
        return dorsal;
    }

    public void setDorsal(byte dorsal) {
        this.dorsal = dorsal;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public byte getSkill() {
        return skill;
    }

    public void setSkill(byte skill) {
        this.skill = skill;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }
}
