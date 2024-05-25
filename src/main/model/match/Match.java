package main.model.match;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Stack;

import main.model.match.foul.Foul;
import main.model.match.foul.foulFactory.FoulFactory;
import main.model.match.points.PointsFactory;
import main.model.team.player.Player;

public class Match{

    private String rivalTeam;
    private MatchType type;
    private Result result;
    private String points;
    private Stack<Foul> fouls = new Stack<>();
    private ArrayList<Player> players;

    public Match(String rivalTeam, MatchType type, ArrayList<Player> players) throws NoSuchFileException {
        this.rivalTeam = rivalTeam;
        this.type = type;
        this.players = players;
        this.points = asignPoints();
        asignResult();
        asignFouls();
        givePlayerPoints();
    }

    // El siguiente método dará un resultado de forma aleatoria según el tipo de partido usando un patrón de diseño de factoría

    private String asignPoints() throws NoSuchFileException{
        PointsFactory pointsFactory = new PointsFactory(); 
        return pointsFactory.play(type);
    }

    // El siguiente método asigna el resultado del partido según el método anterior
    
    private void asignResult(){
        String arrayPoints [] = points.split("-");
        if(Integer.valueOf(arrayPoints[0]) > Integer.valueOf(arrayPoints[1])) result = Result.victoria;
        if(Integer.valueOf(arrayPoints[0]) < Integer.valueOf(arrayPoints[1])) result = Result.derrota;
        if(Integer.valueOf(arrayPoints[0]) == Integer.valueOf(arrayPoints[1])) result = Result.empate;
    }

    // El siguiente método creara las faltas del partido de forma aleatoria, habiendo un máximo de 5 faltas por cuarto.

    private void asignFouls() throws NoSuchFileException{
        FoulFactory foulFactory = new FoulFactory();
        foulFactory.createFouls(players, fouls);
    }

    // El siguiente método repartirá los puntos del partido con los jugadores del mismo

    public void givePlayerPoints(){
        String arrayPoints [] = points.split("-");
        short resultingPoints = 0;
        byte randomPlayer = 0;
        while (resultingPoints != Short.valueOf(arrayPoints[0])){
            while (resultingPoints <= Short.valueOf(arrayPoints[0])){
                randomPlayer = (byte)(Math.random()*players.size());
                players.get(randomPlayer).setPoints(players.get(randomPlayer).generatePoints());
                resultingPoints += (short)players.get(randomPlayer).getPoints();
            }
            short overPoints = (short) (resultingPoints - Short.valueOf(arrayPoints[0]));
            players.get(randomPlayer).setPoints((short)(players.get(randomPlayer).getPoints() - overPoints));
            resultingPoints = (short) (resultingPoints - overPoints);
        }
    }

    @Override
    public String toString() {
        return "\nPartido vs " + rivalTeam + "\nEl partido ha acabado en " + result + " con un resultado  de " + points + "\n\nEl partido ha tenido estas faltas: " + fouls.peek().toString();
    }

    public String getRivalTeam() {
        return rivalTeam;
    }

    public void setRivalTeam(String rivalTeam) {
        this.rivalTeam = rivalTeam;
    }

    public MatchType getType() {
        return type;
    }

    public void setType(MatchType type) {
        this.type = type;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    
    public Stack<Foul> getFouls() {
        return fouls;
    }

    public void setFouls(Stack<Foul> fouls) {
        this.fouls = fouls;
    }    

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
