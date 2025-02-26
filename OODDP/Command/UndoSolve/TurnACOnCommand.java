package OODDP.Command.UndoSolve;

import OODDP.Command.WithoutIssue.AirConditioner;

public class TurnACOnCommand implements ICommand{
    AirConditioner ac;
    TurnACOnCommand(AirConditioner ac){
        this.ac=ac;
    }

    @Override
    public void execute(){
        ac.turnOnAC();
    }

    @Override
    public void undo(){
        ac.turnOffAC();
    }
}
