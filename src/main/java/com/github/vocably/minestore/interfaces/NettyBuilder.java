package com.github.vocably.minestore.interfaces;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public interface NettyBuilder {

    static EventLoopGroup createLoopGroup() {
        boolean epoll = Epoll.isAvailable();
        if(epoll) {
            return new EpollEventLoopGroup();
        } else {
            return new NioEventLoopGroup();
        }
    }

    static Class<? extends ServerSocketChannel>  createServerChannel() {
        boolean epoll = Epoll.isAvailable();
        if(epoll) {
            return EpollServerSocketChannel.class;
        } else {
            return NioServerSocketChannel.class;
        }
    }

    static Class<? extends SocketChannel>  createChannel() {
        boolean epoll = Epoll.isAvailable();
        if(epoll) {
            return EpollSocketChannel.class;
        } else {
            return NioSocketChannel.class;
        }
    }
}
