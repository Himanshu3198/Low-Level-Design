package org.designPattern.ChainOfResponsibilityPattern;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(int amount);
}
