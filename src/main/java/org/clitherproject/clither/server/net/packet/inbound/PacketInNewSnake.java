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
package org.clitherproject.clither.server.net.packet.inbound;

import io.netty.buffer.ByteBuf;
import org.clitherproject.clither.server.net.packet.Packet;

public class PacketInNewSnake extends Packet {
    int u1 = 0; //UNKNOWN
    int u2 = 0; //UNKNOWN
    int packetType = -1;
    
	@Override
	public void writeData(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void readData(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

}
