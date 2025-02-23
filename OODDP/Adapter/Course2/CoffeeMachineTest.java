package OODDP.Adapter.Course2;

public class CoffeeMachineTest {
    public static void main(String[] args) {
        OldCoffeeMachine oldMachine = new OldCoffeeMachine();
        CoffeeMachineInterface touchScreen = new CoffeeTouchscreenAdapter(oldMachine);

        touchScreen.chooseFirstSelection();  // Output: A - Selected
        touchScreen.chooseSecondSelection(); // Output: B - Selected
    }
}

