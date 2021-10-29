package com.github.vocably.minestore.example.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MineStoreExpirationEvent {

    private final String playerName;
    private final String packetExpiring;
}
