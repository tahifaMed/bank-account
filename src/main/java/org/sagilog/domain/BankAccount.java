package org.sagilog.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.sagilog.events.BankAccountEvent;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Getter
public class BankAccount {

    private UUID uuid;
    @Setter
    private List<BankAccountEvent> accountEvents;

    private BigDecimal balance;

    public BankAccount() {
        this.uuid = UUID.randomUUID();
        this.accountEvents = Collections.synchronizedList(List.of());
        this.balance = BigDecimal.ZERO;
    }


    /**
     * add new Event to immutable List
     * @param accountEvent the event of an operation committed by a client
     */
    public void addEvent(BankAccountEvent accountEvent) {
        this.accountEvents = Collections.synchronizedList(
                Stream.concat(
                        this.accountEvents.stream(), List.of(accountEvent).stream()
                ).collect(Collectors.toList()));
    }

}
