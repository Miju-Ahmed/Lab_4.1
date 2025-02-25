package OODDP.Chain_Of_Responsibility.Youtube;

public class Main {
    public static void main(String[] args) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.ERROR, "Exception occurs.\n");
        logObject.log(LogProcessor.DEBUG, "need to debug this.\n");
        logObject.log(LogProcessor.INFO, "just for info\n");
    }
}
