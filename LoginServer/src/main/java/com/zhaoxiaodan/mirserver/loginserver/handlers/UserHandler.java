package com.zhaoxiaodan.mirserver.loginserver.handlers;

import com.zhaoxiaodan.mirserver.db.entities.User;
import com.zhaoxiaodan.mirserver.network.Handler;
import com.zhaoxiaodan.mirserver.network.packets.Packet;

public abstract class UserHandler extends Handler {

	public final void onPacket(Packet packet) throws Exception {
		User user = (User) session.get("user");
		if (null == user)
			throw new Exception("user not found for packet:" + packet.protocol);

		onPacket(packet, user);
	}

	public abstract void onPacket(Packet packet, User user) throws Exception;
}