package OODDP.Command.UndoSolve;

public class TurnACOffCommand implements ICommand{
    AriConditioner ac;
    TurnACOffCommand(AriConditioner ac){
        this.ac=ac;
    }

    @Override
    public void execute(){
        ac.turnOffAC();
    }
    @Override
    public void undo(){
        ac.turnOnAC();
    }
}
