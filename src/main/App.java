package main;
import java.util.ArrayList;

import main.model.team.Team;
import main.model.team.player.Center;
import main.model.team.player.Player;
import main.model.team.player.PointGuard;
import main.model.team.player.PowerForward;
import main.model.team.player.ShootingGuard;
import main.model.team.player.SmallForward;
import main.view.*;

public class App {

    // Te dejo comentados quince jugadores para que puedas probar el programa sin añadir jugadores.

    public static void main(String[] args) throws Exception {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new PointGuard("Stephen Curry", (byte) 2, (short) 191, (byte) 5);
        Player player2 = new PointGuard("Luka Doncic", (byte) 3, (short) 201, (byte) 5);
        Player player3 = new PointGuard("Damian Lillard", (byte) 1, (short) 190, (byte) 5);
        Player player4 = new ShootingGuard("James Harden", (byte) 2, (short) 196, (byte) 5);
        Player player5 = new ShootingGuard("Devin Booker", (byte) 2, (short) 198, (byte) 5);
        Player player6 = new ShootingGuard("Bradley Beal", (byte) 2, (short) 196, (byte) 5);
        Player player7 = new SmallForward("LeBron James", (byte) 5, (short) 206, (byte) 5);
        Player player8 = new SmallForward("Kevin Durant", (byte) 5, (short) 206, (byte) 5);
        Player player9 = new SmallForward("Kawhi Leonard", (byte) 4, (short) 201, (byte) 5);
        Player player10 = new PowerForward("Giannis Antetokounmpo", (byte) 4, (short) 211, (byte) 5);
        Player player11 = new PowerForward("Anthony Davis", (byte) 4, (short) 206, (byte) 5);
        Player player12 = new PowerForward("Kristaps Porzingis", (byte) 4, (short) 221, (byte) 4);
        Player player13 = new Center("Joel Embiid", (byte) 5, (short) 213, (byte) 5);
        Player player14 = new Center("Nikola Jokic", (byte) 4, (short) 213, (byte) 5);
        Player player15 = new Center("Rudy Gobert", (byte) 5, (short) 216, (byte) 5);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);
        players.add(player11);
        players.add(player12);
        players.add(player13);
        players.add(player14);
        players.add(player15);
        TeamBasketView user = new TeamBasketView();
        Team team = new Team(players);
        user.showMenu(team);
    }
}
