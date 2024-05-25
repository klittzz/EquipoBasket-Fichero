package main.model.match.foul.foulFactory;

public class PersonalFoul implements FoulType{

    @Override
    public String foulType(byte random) {
        return "personal";
    }
}
