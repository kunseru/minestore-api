package com.github.vocably.minestore.example.handler;

import com.github.vocably.minestore.abstracts.AbstractHandler;

import java.util.concurrent.TimeUnit;

public class ExampleHandler extends AbstractHandler {

    @Override
    public void onPurchase(String playerName, String packetBought, int timeout, TimeUnit timeUnit) {

    }

    @Override
    public void onExpiration(String playerName, String packetExpired) {

    }
}
