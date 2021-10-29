package com.github.vocably.minestore;

import com.github.vocably.minestore.abstracts.AbstractHandler;
import com.github.vocably.minestore.interfaces.NettyBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.Getter;

@Getter
public class MineStore {

    @Getter private static MineStore instance;

    private AbstractHandler handler;

    public MineStore() {
        instance = this;
    }

    public MineStore(String host, int port, String password) {
        super();

        bind(host, port, password);
    }

    public void bind(String host, int port, String password) {
        EventLoopGroup bossGroup = NettyBuilder.createLoopGroup();
        EventLoopGroup workerGroup = NettyBuilder.createLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                        .channel(NettyBuilder.createServerChannel())
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new StringEncoder());
                                ch.pipeline().addLast(new StringDecoder());
                                ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

                                    }
                                });
                            }
                        })
        .childOption(ChannelOption.SO_KEEPALIVE, true);
        serverBootstrap.bind(host, port);
    }

    public void registerHandler(AbstractHandler abstractHandler) {
        this.handler = abstractHandler;
    }
}
