package com.github.vocably.minestore.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class MineStorePurchaseEvent {

    private final String playerName;
    private final String packetBought;
    private final int timeout;
    private final TimeUnit timeUnit;
}
