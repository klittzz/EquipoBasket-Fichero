package main.model.match.foul.foulFactory;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import main.model.match.foul.Foul;
import main.model.team.player.Player;

public class FoulFactory {

    public void createFouls(ArrayList<Player> players, Stack<Foul> fouls) throws NoSuchFileException{
        byte minute;
        byte random;
        for (byte i = 0; i < 4; i++) {
            for (byte j = 0; j < 5; j++) {
                random = (byte)(Math.random()*100 + 1);
                if(random <= 25){
                    minute = (byte)(Math.random()*12 + 1);
                    byte randomPlayer = (byte)(Math.random()*players.size());
                    byte randomFoul = (byte)(Math.random()*3 + 1);
                    fouls.add(new Foul(((byte)(i+1)), minute, giveFoulType(randomFoul), players.get(randomPlayer)));
                }
            }
        }
        sortFouls(fouls);
    }

    // Este método ordena los objetos Foul ordenados por cuarto y minuto

    private void sortFouls(Stack<Foul> fouls){
        Stack<Foul> auxFouls = new Stack<>();
        Stack<Foul> auxFouls2 = new Stack<>();
        for (int i = 0; i < 4; i++) {
            auxFouls = new Stack<>();
            for (Foul foul : fouls) if(foul.getQuarter() == (i+1)) auxFouls.push(foul);
            Collections.sort(auxFouls);
            for (Foul foul2 : auxFouls) auxFouls2.add(foul2);
        }
        fouls = auxFouls2;
    }

    public String giveFoulType(byte random) throws NoSuchFileException{
        FoulType foulType = giveType(random);
        return foulType.foulType(random);
    }

    public FoulType giveType(byte random) throws NoSuchFileException{
        return switch (random) {
            case 1 -> new AntisportiveFoul();
            case 2 -> new PersonalFoul();
            case 3 -> new TechnicalFoul();
            default -> throw new NoSuchFileException("Tipo de falta inexistente.");
        };
    }
}
