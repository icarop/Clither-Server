/**
 * This file is part of Clither.
 *
 * Clither is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Clither is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Clither.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.clitherproject.clither.server.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.logging.Logger;

import org.clitherproject.clither.api.event.player.PlayerDisconnectEvent;
import org.clitherproject.clither.server.ClitherServer;
import org.clitherproject.clither.server.net.packet.Packet;
import org.clitherproject.clither.server.world.PlayerImpl;

public class ClientHandler extends SimpleChannelInboundHandler<Packet> {

    private final ClitherServer server;
    private PlayerImpl player;
    
    static Logger log = Logger.getGlobal();

    public ClientHandler(ClitherServer server) {
        this.server = server;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.player = new PlayerImpl(ctx.channel());
        server.getPlayerList().addPlayer(player);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        PlayerDisconnectEvent event = new PlayerDisconnectEvent(player);
        server.getPluginManager().callEvent(event);
        server.getPlayerList().removePlayer(player);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        player.getConnection().handle(packet);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    }
}

