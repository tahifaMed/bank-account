package org.sagilog.events;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
public abstract class BankAccountEvent {

    private UUID uuid;
    private LocalDateTime date;


    protected BankAccountEvent() {
        this.uuid = UUID.randomUUID();
        this.date = LocalDateTime.now();
    }

    public abstract String getOperationName();
}
