package org.sagilog.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DepositEvent extends TransactionEvent{


    public DepositEvent(BigDecimal amount, BigDecimal balance) {
        super(amount, balance);
    }

    @Override
    public String getOperationName() {
        return "Deposit";
    }
}
