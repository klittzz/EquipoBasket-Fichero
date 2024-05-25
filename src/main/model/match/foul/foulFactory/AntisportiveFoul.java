package main.model.match.foul.foulFactory;

public class AntisportiveFoul implements FoulType{

    @Override
    public String foulType(byte random) {
        return "antideportiva";
    }
}
