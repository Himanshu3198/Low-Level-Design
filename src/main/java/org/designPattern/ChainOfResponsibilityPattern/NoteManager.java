package org.designPattern.ChainOfResponsibilityPattern;

public class NoteManager {
    private DispenseChain chain;
    public NoteManager(){
        DispenseChain dispense500 = new NoteDispenser(500);
        DispenseChain dispense100 = new NoteDispenser(100);
        DispenseChain dispense50 = new NoteDispenser(50);
        DispenseChain dispense10 = new NoteDispenser(10);
        dispense500.setNextChain(dispense100);
        dispense100.setNextChain(dispense50);
        dispense50.setNextChain(dispense10);
        this.chain = dispense500;
    }

    public void withdraw(int amount){
        if(amount % 10 != 0){
            System.out.println("Sorry Exchange not available! Amount Should be multiple of 10");
        }
        chain.dispense(amount);
    }

}
