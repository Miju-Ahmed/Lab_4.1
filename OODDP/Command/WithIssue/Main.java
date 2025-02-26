package OODDP.Command.WithIssue;

public class Main {
    public static void main(String[] args) {
        AriConditioner ac=new AriConditioner();
        ac.turnOnAC();
        ac.setTemparature(23);
        ac.turnOffAC();

        Bulb bulb=new Bulb();
        bulb.turnOffBulb();
        bulb.turnOffBulb();
    }
}
