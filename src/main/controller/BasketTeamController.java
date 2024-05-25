package main.controller;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Stack;

import main.model.match.Match;
import main.model.match.MatchType;
import main.model.team.Team;
import main.model.team.player.Player;
import main.model.team.player.playerFactory.PlayerFactory;
public class BasketTeamController {

    // Este método 

    public Player createPlayer(Team team, String name, byte dorsal, short height, byte skill){
        PlayerFactory playerFactory = new PlayerFactory();
        return playerFactory.createPlayer(team, name, dorsal, height, skill);
    }

    public void deletePlayer(byte choice,ArrayList<Player> players){
        players.remove(choice);
    }

    public void playMatch(Stack<Match> results, String rivalTeam, MatchType type, ArrayList<Player> players) throws NoSuchFileException{
        results.push(new Match(rivalTeam, type, players));
    }
}
