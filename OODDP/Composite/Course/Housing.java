package OODDP.Composite.Course;

import java.util.ArrayList;

public class Housing implements IStructure{
    private ArrayList<IStructure>structures;
    private String address;

    public Housing(String address){
        this.structures=new ArrayList<IStructure>();
        this.address=address;
    }

    public String getName(){
        return this.address;
    }
    public int addStructures(IStructure component){
        this.structures.add(component);
        return this.structures.size()-1;
    }

    public IStructure getStructure(int componentNumber){
        return this.structures.get(componentNumber);
    }

    public void locations(){
        System.out.println("You are currently in "+this.getName()+". It has ");
        for(IStructure struct:this.structures){
            System.out.println(struct.getname());
        }
    }

    @Override
    public void enter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enter'");
    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exit'");
    }

    @Override
    public String getname() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getname'");
    }
}
