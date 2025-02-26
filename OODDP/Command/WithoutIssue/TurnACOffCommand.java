package OODDP.Command.WithoutIssue;

import OODDP.Command.WithIssue.AriConditioner;

public class TurnACOffCommand implements ICommand{
    AriConditioner ac;
    TurnACOffCommand(AriConditioner ac){
        this.ac=ac;
    }

    @Override
    public void execute(){
        ac.turnOffAC();
    }
}
