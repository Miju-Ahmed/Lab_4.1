package OODDP.Command.WithoutIssue;

public class AirConditioner {
    boolean isOn;
    int temprature;

    public void turnOnAC(){
        isOn=true;
        System.out.println("AC is ON");
    }

    public void turnOffAC(){
        isOn=false;
        System.out.println("AC is OFF");
    }

    public void setTemparature(int temp){
        this.temprature=temp;
        System.out.println("Tempature is : "+temprature);
    }
}
