package org.sagilog.events;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class TransactionEvent extends BankAccountEvent {

    private BigDecimal amount;
    private BigDecimal balance;


}
