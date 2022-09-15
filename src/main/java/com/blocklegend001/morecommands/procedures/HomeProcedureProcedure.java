package com.blocklegend001.morecommands.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import com.blocklegend001.morecommands.network.MorecommandsModVariables;

public class HomeProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MorecommandsModVariables.PlayerVariables())).has_home == false) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You don't have a home set for the moment. Please set a new one"), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Teleporting to your home..."), (false));
			{
				Entity _ent = entity;
				_ent.teleportTo(
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_x),
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_y),
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_z));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_x),
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_y),
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_z),
							_ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
