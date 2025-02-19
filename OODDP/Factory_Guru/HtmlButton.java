public class HtmlButton implements Button{
    public void render(){
        System.out.println("Its the test button option");
        onClick();
    }
    public void onClick(){
        System.out.println("Click! Button says - Hello World!");
    }
}