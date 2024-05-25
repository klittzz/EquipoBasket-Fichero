package main.model.team;
import java.util.ArrayList;
import java.util.Stack;

import main.model.match.Match;
import main.model.team.player.Player;
import main.util.FileUtil;

public class Team {

    private ArrayList<Player> players;
    private Stack<Match> results = new Stack<>();

    public Team(ArrayList<Player> players) {
        this.players = players;
    }

    // Este método actualizará el fichero del último partido y el del global

    public void updateFiles(Team team) {
        FileUtil.fileWriter(team.getResults().peek().toString(), "Match",1);
        FileUtil.fileWriter(team.getResults().peek().toString(), "SeasonMatches", 0);
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
