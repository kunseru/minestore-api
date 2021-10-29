package com.github.vocably.minestore.example;

import com.github.vocably.minestore.MineStore;
import com.github.vocably.minestore.abstracts.AbstractHandler;
import com.github.vocably.minestore.event.MineStoreExpirationEvent;
import com.github.vocably.minestore.event.MineStorePurchaseEvent;
import com.github.vocably.minestore.example.handler.ExampleHandler;

import java.util.concurrent.TimeUnit;

public class ExamplePlugin {

/*
    *//**
     * Example Concept for MineStore Developer API
     *//*
    public static void main(String[] args) {
        MineStore mineStore = new MineStore();
        mineStore.bind("localhost", 1239, "aishais");
        mineStore.registerHandler(new ExampleHandler());
        mineStore.registerHandler(new AbstractHandler() {
            @Override
            public void onPurchase(String playerName, String packetBought, int timeout, TimeUnit timeUnit) {
                MineStorePurchaseEvent mineStorePurchaseEvent = new MineStorePurchaseEvent(playerName, packetBought, timeout, timeUnit);
            }

            @Override
            public void onExpiration(String playerName, String packetExpired) {
                MineStoreExpirationEvent mineStoreExpirationEvent = new MineStoreExpirationEvent(playerName, packetExpired);
            }
        });
    }*/

    public static void main(String[] args) {
        MineStore mineStore = new MineStore("localhost", 12310, "asjaisas");

        mineStore.registerHandler(new ExampleHandler());

        mineStore.registerHandler(new AbstractHandler() {
            @Override
            public void onPurchase(String playerName, String packetBought, int timeout, TimeUnit timeUnit) {
                MineStorePurchaseEvent mineStorePurchaseEvent = new MineStorePurchaseEvent(playerName, packetBought, timeout, timeUnit);
            }

            @Override
            public void onExpiration(String playerName, String packetExpired) {
                MineStoreExpirationEvent mineStoreExpirationEvent = new MineStoreExpirationEvent(playerName, packetExpired);
            }
        });
    }
}
