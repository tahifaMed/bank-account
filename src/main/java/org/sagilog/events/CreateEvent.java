package org.sagilog.events;


public class CreateEvent extends BankAccountEvent{
    @Override
    public String getOperationName() {
        return "create";
    }
}
