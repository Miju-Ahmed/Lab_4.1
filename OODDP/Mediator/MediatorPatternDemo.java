package OODDP.Mediator;

public class MediatorPatternDemo {
    public static void main(String[] args){
        User miju = new User("Miju");
        User murad = new User("Murad");

        miju.sendMessage("Hi! Murad Chowdhury!");
        murad.sendMessage("Hello! Miju Chowdhury");
    }
}
