package main.model.match.foul;

import main.model.team.player.Player;

public class Foul implements Comparable<Foul>{

    private byte quarter;
    private byte minute;
    private String type;
    private Player player;

    public Foul(byte quarter, byte minute, String type, Player player) {
        this.quarter = quarter;
        this.minute = minute;
        this.type = type;
        this.player = player;
    }

    @Override
    public String toString() {
        return "\n\nLa falta " + type + " ha sido cometida por el jugador " + player.getName() + " en el cuarto " + quarter + ", en el minuto " + minute;
    }

    @Override
    public int compareTo(Foul o) {
        return Byte.compare(minute, o.getMinute());
    }

    public byte getQuarter() {
        return quarter;
    }

    public void setQuarter(byte quarter) {
        this.quarter = quarter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    
}
