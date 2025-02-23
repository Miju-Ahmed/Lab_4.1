package OODDP.Adapter.Course2;
public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

	OldCoffeeMachine theMachine;

	public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
		theMachine = newMachine;
	}
	
	public void chooseFirstSelection() {
		theMachine.selectA();
	}
	
	public void chooseSecondSelection() {
		theMachine.selectB();
}
}
