package OODDP.State;

import javax.naming.Context;

public class StartState implements State {
    public void doAction(OODDP.State.Context context){
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}
