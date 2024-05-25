package main.model.team.player.playerFactory;
import main.model.team.Team;
import main.model.team.player.*;

public class PlayerFactory {

    // Este método comprueba si ya existen la cantidad máxima de un tipo de Player

    private boolean flagTypePlayers(Team team, Player player){
        int counter = 0;
        for (Player player2 : team.getPlayers()) {
            if(player2.getClass().getSimpleName().equals(player.getClass().getSimpleName())) counter++;
        }
        if(counter >= 3) return false;
        return true;
    }

    // Este método controla el array de Players para poder autoasignar una posición a un Player cuya posición está ya llena

    private Player controlTypePlayers(Team team, Player player){
        Player playerAux = null;
        while (true) {
            if(player.getClass().getSimpleName().equals("Center")){
                playerAux = player;
                if(flagTypePlayers(team, playerAux)) return playerAux;
                else{
                    playerAux = new PowerForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                    if(flagTypePlayers(team, playerAux)) return playerAux;
                    else{
                        playerAux = new SmallForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                        if(flagTypePlayers(team, playerAux)) return playerAux;
                        else{
                            playerAux = new ShootingGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                            if(flagTypePlayers(team, playerAux)) return playerAux;
                            else{
                                playerAux = new PointGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                                if(flagTypePlayers(team, playerAux)) return playerAux;
                            }
                        }
                    }
                }
            }else if(player.getClass().getSimpleName().equals("PowerForward")){
                playerAux = player;
                if(flagTypePlayers(team, playerAux)) return playerAux;
                else{
                    playerAux = new Center(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                    if(flagTypePlayers(team, playerAux)) return playerAux;
                    else{
                        playerAux = new SmallForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                        if(flagTypePlayers(team, playerAux)) return playerAux;
                        else{
                            playerAux = new ShootingGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                            if(flagTypePlayers(team, playerAux)) return playerAux;
                            else{
                                playerAux = new PointGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                                if(flagTypePlayers(team, playerAux)) return playerAux;
                            }
                        }
                    }
                }
            }else if(player.getClass().getSimpleName().equals("SmallGuard")){
                playerAux = player;
                if(flagTypePlayers(team, playerAux)) return playerAux;
                else{
                    playerAux = new PowerForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                    if(flagTypePlayers(team, playerAux)) return playerAux;
                    else{
                        playerAux = new ShootingGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                        if(flagTypePlayers(team, playerAux)) return playerAux;
                        else{
                            playerAux = new Center(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                            if(flagTypePlayers(team, playerAux)) return playerAux;
                            else{
                                playerAux = new PointGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                                if(flagTypePlayers(team, playerAux)) return playerAux;
                            }
                        }
                    }
                }
            }else if(player.getClass().getSimpleName().equals("ShootingGuard")){
                playerAux = player;
                if(flagTypePlayers(team, playerAux)) return playerAux;
                else{
                    playerAux = new PointGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                    if(flagTypePlayers(team, playerAux)) return playerAux;
                    else{
                        playerAux = new SmallForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                        if(flagTypePlayers(team, playerAux)) return playerAux;
                        else{
                            playerAux = new PowerForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                            if(flagTypePlayers(team, playerAux)) return playerAux;
                            else{
                                playerAux = new Center(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                                if(flagTypePlayers(team, playerAux)) return playerAux;
                            }
                        }
                    }
                }
            }else {
                playerAux = player;
                if(flagTypePlayers(team, playerAux)) return playerAux;
                else{
                    playerAux = new ShootingGuard(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                    if(flagTypePlayers(team, playerAux)) return playerAux;
                    else{
                        playerAux = new SmallForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                        if(flagTypePlayers(team, playerAux)) return playerAux;
                        else{
                            playerAux = new PowerForward(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                            if(flagTypePlayers(team, playerAux)) return playerAux;
                            else{
                                playerAux = new Center(player.getName(),player.getDorsal(), player.getHeight(), player.getSkill());
                                if(flagTypePlayers(team, playerAux)) return playerAux;
                            }
                        }
                    }
                }
            }
        }
    }

    // Este método crea el tipo de objeto Player según los parámetros

    public Player createPlayer(Team team, String name, byte dorsal, short height, byte skill){
        PlayerType playerType = givePosition(name, dorsal, height, skill);
        Player player = playerType.createPlayer(name, dorsal, height, skill);
        Player playerVerified = controlTypePlayers(team, player);
        if(playerVerified != player) {
            System.out.println("El jugador no ha podido ser asignado a " + translateName(player) + " por lo que ha sido asignado automáticamente a " + translateName(playerVerified) + ".");
            player = playerVerified;
        }
        else System.out.println("El jugador ha sido asignado a " + translateName(player) + ".");
        return player;
    }

    // Este método elige la posición de la factoría según la siguiente operación: habilidad - altura

    public PlayerType givePosition(String name, byte dorsal, short height, byte skill){
        byte position = (byte) (skill - createHeightStar(height, skill));
        if(position < -3) return new CenterType();
        if(position < -1) return new PowerForwardType();
        if(position < 1) return new SmallForwardType();
        if(position < 3) return new ShootingGuardType();
        return new PointGuardType();
    }

    // Este método convierte la altura del jugador del 1 al 5

    private byte createHeightStar(short height, byte skill){
        if(height < 190 ) return 1;
        if(height < 195 ) return 2;
        if(height < 205 ) return 3;
        if(height < 210 ) return 4;
        return 5;
    }

    // Este método traduce la posición del inglés al español

    private static String translateName(Player player){
        if(player.getClass().getSimpleName().equals("Center")) return "Pivot";
        if(player.getClass().getSimpleName().equals("SmallForward")) return "Alero";
        if(player.getClass().getSimpleName().equals("ShootingGuard")) return "Escolta";
        if(player.getClass().getSimpleName().equals("PointGuard")) return "Base";
        else return "Ala Pivot";
    }
}
