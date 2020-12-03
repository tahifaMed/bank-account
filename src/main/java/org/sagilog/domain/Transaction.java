package org.sagilog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
public class Transaction {

    private BigDecimal amount;
    private BigDecimal balance;
    private String operation;
    private LocalDateTime date;
}
