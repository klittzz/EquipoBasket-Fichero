package main.model.match.points;

import java.util.Random;

public class OficialLocalMatch implements Points{
    
    @Override
    public String makePoints() {    
        Random gauss = new Random();
        return String.valueOf((int)(gauss.nextGaussian() * 16.5 + 92.5)) + "-" + String.valueOf((int)((gauss.nextGaussian() * 16.5 + 92.5) * 0.75));
    }
}
