package com.github.vocably.minestore.abstracts;

import java.util.concurrent.TimeUnit;

public abstract class AbstractHandler {

    public abstract void onPurchase(String playerName, String packetBought, int timeout, TimeUnit timeUnit);
    public abstract void onExpiration(String playerName, String packetExpired);
}
