package main.model.match.points;
import java.nio.file.NoSuchFileException;

import main.model.match.MatchType;

public class PointsFactory {

    // Este método comprobará que se le habrá pasado como parámetro para usar una de las 3 clases que implementan la interfáz Points

    public String play(MatchType type) throws NoSuchFileException{
        Points points = getType(type);
        return points.makePoints();
    }

    public Points getType(MatchType type) throws NoSuchFileException{
        return switch (type) {
            case oficialLocal -> new OficialLocalMatch();
            case oficialVisitor -> new OficialVisitorMatch();
            case exhibition -> new ExhibitionMatch();
            default -> throw new NoSuchFileException("Tipo de partido inexistente.");
        };
    }
}