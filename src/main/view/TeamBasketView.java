package main.view;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Stack;

import main.controller.BasketTeamController;
import main.model.match.Match;
import main.model.match.MatchType;
import main.model.team.Team;
import main.model.team.player.Player;
import main.util.Aa;
import main.util.ES;
import main.util.FileUtil;

public class TeamBasketView {

    private BasketTeamController controller = new BasketTeamController();

    public void showMenu(Team team) throws NoSuchFileException{
        byte choice = 0;
        while(true){
            System.out.println("""
                --------------------------
                ----   Equipo Basket  ----
                --------------------------

                    1º Añadir jugador
                    2º Eliminar jugador
                    3º Jugar partido
                    4º Ver resumen del último partido
                    5º Ver resumen de la temporada
                    6º Ver resumen de los jugadores
                    0º Salir
                Elige: """);
            choice = ES.leerBytePositivo();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:

                    // Controlo que el usuario no pueda meter mas de 15 objetos Player.

                    if(team.getPlayers().size() == 15) System.out.println("No puedes añadir mas jugadores al equipo, ya hay 15.");
                    else team.getPlayers().add(createPlayer(team));
                    break;
                case 2:

                    // Controlo que el usuario no pueda eliminar objetos de la lista cuando este vacia.

                    if(team.getPlayers().isEmpty()) System.out.println("No puedes eliminar a ningún jugador ya que no hay ninguno.");
                    else deletePlayer(team.getPlayers());
                    break;
                case 3:

                    // Controlo que el usuario no pueda crear un objeto Match cuando la lista Players tenga un lenght menor que 14 o no tenga jugadores.

                    if(team.getPlayers().isEmpty()) System.out.println("No puedes jugar un partido ya que no hay ningun jugador.");
                    else if(team.getPlayers().size() < 14) System.out.println("No se puede jugar el partido ya que no hay jugadores suficientes.");
                    else {
                        playMatch(team.getResults(), team.getPlayers());
                        controller.updateFiles(team);
                        showLastMatch();
                    }
                    break;
                case 4:

                    // Controlo que el usuario no pueda ver la lista de resultados cuando este vacía.

                    if(team.getResults().isEmpty()) System.out.println("No existe ningún partido que resumir.");
                    else showLastMatch();
                    break;
                case 5:
                
                    // Controlo que el usuario no pueda ver la lista de resultados cuando este vacía.

                    if(team.getResults().isEmpty()) System.out.println("No existe ningún partido que resumir.");
                    else showSeason();
                    break;
                case 6:

                    // Controlo que el usuario no pueda ver la lista de jugadores cuando este vacía.    

                    if(team.getPlayers().isEmpty()) System.out.println("No puedes ver ningún resumen ya que no hay ningun jugador.");
                    else showSummaryPlayer(team.getPlayers(), team.getResults());
                    break;
                default:
                    System.out.println("Opción inválida, elija una correcta!");
                    break;
            }

        }
    }

    // Este método interactúa con el usuario para crear un jugador

    public Player createPlayer(Team team){
        String name;
        boolean flag = false;
        byte dorsal, skill;
        short height;
        System.out.print("Introduce el nombre y el apellido del jugador: ");
        name = ES.leerCadena();
        System.out.print("Introduce el dorsal del jugador: ");
        dorsal = ES.leerBytePositivo();
        while(!flag){
            byte counter = 0;
            if(dorsal > 100){
                System.out.println("El dorsal ni puede superar el numero 100.");
                dorsal = ES.leerBytePositivo();
                counter++;
            }
            if(!controlDorsal(team, dorsal)){
                System.out.println("El dorsal elegido ya esta asignado a otro jugador.");
                dorsal = ES.leerBytePositivo();
                counter++;
            }
            if(counter == 0) flag = true;
        }
        System.out.print("Introduce la altura en centímetros del jugador: ");
        height = ES.leerShortPositivo();
        while(!controlHeight(height)){
            System.out.println("La altura introducida no es válida");
            height = ES.leerShortPositivo();
        }
        System.out.print("Introduce la habilidad del jugador, en un número del 1 al 5: ");
        skill = ES.leerBytePositivo();
        while(!controlSkill(skill)){
            System.out.println("La habilidad introducida no es válida");
            skill = ES.leerBytePositivo();
        }
        Player player = controller.createPlayer(team ,name, dorsal, height, skill);
        return player;
    }

    // Este método interactúa con el usuario para eliminar un jugador

    public void deletePlayer(ArrayList<Player> players){
        byte choice = 0;
        System.out.println("Elige que jugador quieres eliminar: ");
        for (Player player : players) Aa.bonito(player.getName());
        choice = ES.leerBytePositivo();
        while(choice > players.size()){
            System.out.println("Jugador inexistente, intrduce uno válido");
            choice = ES.leerBytePositivo();
        }
        System.out.println("El jugador " + players.get(choice-1).getName() + " ha sido eliminado del equipo.");
        controller.deletePlayer((byte) (choice - 1), players);
        
    }

    // Este método interactúa con el usuario para recoger los datos, para crear un objeto Match

    public void playMatch(Stack<Match> results, ArrayList<Player> players) throws NoSuchFileException{
        String rivalTeam;
        MatchType type = null;
        byte choice = 0;
        boolean flag = false;
        System.out.print("Introduce el nombre del equipo rival: ");
        rivalTeam = ES.leerCadena();
        System.out.println("""
            Tipo de partido:
                1º Oficial y local
                2º Oficial y visitante
                3º Exhibicion
            Elige: """);
        choice = ES.leerBytePositivo();
        while(!flag){
            switch (choice) {
                case 1:
                    type = MatchType.oficialLocal;
                    flag = true;
                    break;
                case 2:
                    type = MatchType.oficialVisitor;
                    flag = true;
                    break;
                case 3:
                    type = MatchType.exhibition;
                    flag = true;
                    break;
                default:
                    System.out.print("Tipo inexistente, elige del 1 al 3: ");
                    break;
            }
        }
        controller.playMatch(results, rivalTeam, type, players);
    }

    // Este método muestra el contenido del fichero Match

    public void showLastMatch(){
        File file = new File("Match");
        System.out.println();
        FileUtil.fileReader(file);
        System.out.println();
    }

    // Este método muestra el contenido del fichero SeasonMatches

    public void showSeason(){
        File file = new File("SeasonMatches");
        System.out.println();
        FileUtil.fileReader(file);
        System.out.println();
    }

    // Este método muestra el resumen del Player que elijas, y que se encuentre dentro del ArrayList de players

    public void showSummaryPlayer(ArrayList<Player> players, Stack<Match> match){
        byte choice;
        System.out.println("¿Que jugador quieres ver?\n");
        for (Player player : players) Aa.bonito(player.getName());
        choice = ES.leerBytePositivo();
        while(choice > players.size()){
            System.out.print("Opcion inválida, escriba una opción válida:");
            choice = ES.leerBytePositivo();
        }
        System.out.println(players.get(choice-1).toString());
        playerFouls(players.get(choice-1), match);
    }

    // Este método muestra un contador de faltas de un Player pasado como parámetro

    private void playerFouls(Player player, Stack<Match> match){
        short antiSportiveFoul = 0, technicalFoul= 0, personalFoul = 0;
        for (Match match2 : match) {
            for (int i = 0; i < match2.getFouls().size(); i++) {
                if(match2.getFouls().get(i).getPlayer().getName().equals(player.getName())){
                    if(match2.getFouls().get(i).getType().equals("personal")) personalFoul++;
                    else if(match2.getFouls().get(i).getType().equals("antideportiva")) antiSportiveFoul++;
                    else technicalFoul++;
                }
            }
        }
        System.out.println("Las faltas cometidas por este jugador son: \n\tAntideportivas: " + antiSportiveFoul + "\n\tPersonales: " + personalFoul + "\n\tTécnicas: " + technicalFoul);
    }

    // Los tres siguientes métodos comprueban datos durante la creación de jugadores

    private boolean controlHeight(short height){
        if(height < 140 || height > 260) return false;
        return true;
    }

    private boolean controlSkill(byte skill){
        if(skill < 1 || skill > 5) return false;
        return true;
    }

    private boolean controlDorsal(Team team, byte dorsal){
        for (int i = 0; i < team.getPlayers().size(); i++) {
            if(dorsal == team.getPlayers().get(i).getDorsal()) return false;
        }
        return true;
    }
}