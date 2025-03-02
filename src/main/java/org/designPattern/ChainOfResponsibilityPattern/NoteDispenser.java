package org.designPattern.ChainOfResponsibilityPattern;

public class NoteDispenser implements DispenseChain {
    private int noteValue;
    private DispenseChain nextDispenser;

    public NoteDispenser(int noteValue) {
        this.noteValue = noteValue;
    }

    @Override
    public void setNextChain(DispenseChain nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    @Override
    public void dispense(int amount) {
        if (amount == 0) return;
        if (amount >= noteValue) {

            int exchangeNote = amount / noteValue;
            int remainder = amount - exchangeNote * noteValue ;
            System.out.println(" Dispense " + exchangeNote + "x" + noteValue + " notes ");
            if (remainder != 0 && nextDispenser != null) {
                nextDispenser.dispense(remainder);
            }
        } else if (nextDispenser != null) {
            nextDispenser.dispense(amount);
        } else {
            throw new IllegalArgumentException("Invalid amount cannot dispense " + amount);
        }
    }
}
