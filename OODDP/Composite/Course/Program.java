package OODDP.Composite.Course;

public class Program {
    public static void main(String[] args) {
        Housing building=new Housing("123 Street");
        Housing floor1=new Housing("123 Street - First Floor");
        int firstFloor=building.addStructures(floor1);

        Room washroom1m=new Room("1F Men's Washroom");
        Room wasRoom1w=new Room("1F Women's Washroom");
        Room common1=new Room("1F Common Area");
        
    }
}
