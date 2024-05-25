package main.model.team;
import java.util.ArrayList;
import java.util.Stack;

import main.model.match.Match;
import main.model.team.player.Player;

public class Team {

    private ArrayList<Player> players;
    private Stack<Match> results = new Stack<>();

    public Team(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public Stack<Match> getResults() {
        return results;
    }

    public void setResults(Stack<Match> results) {
        this.results = results;
    }

    
}
