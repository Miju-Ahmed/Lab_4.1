package OODDP.Chain_Of_Responsibility.Youtube;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel==DEBUG){
            System.out.println("DEBUG: " + message);
        }else{
            System.out.println("Transfer to Error.");
            super.log(logLevel, message);
        }
    }
    
}