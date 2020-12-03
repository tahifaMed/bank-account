package org.sagilog.events;


import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class WithdrawEvent extends TransactionEvent{

    public WithdrawEvent(BigDecimal amount, BigDecimal balance) {
        super(amount, balance);
    }

    @Override
    public String getOperationName() {
        return "Withdraw";
    }
}
