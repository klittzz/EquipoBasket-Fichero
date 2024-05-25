package main.model.match.foul.foulFactory;

public class TechnicalFoul implements FoulType{

    @Override
    public String foulType(byte random) {
        return "técnica";
    }
    
}
