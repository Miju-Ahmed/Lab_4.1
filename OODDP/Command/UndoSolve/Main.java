package OODDP.Command.UndoSolve;

import OODDP.Command.WithoutIssue.AirConditioner;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner=new AirConditioner();

        MyRemoteControl remoteObj=new MyRemoteControl();

        remoteObj.setCommand(new TurnACOnCommand(airConditioner));
        remoteObj.pressButton();
        remoteObj.undo();
        remoteObj.pressButton();
        remoteObj.pressButton();
        remoteObj.undo();
        remoteObj.undo();
        remoteObj.undo();
    }
}
