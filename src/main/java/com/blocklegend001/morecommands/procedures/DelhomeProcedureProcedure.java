package com.blocklegend001.morecommands.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import com.blocklegend001.morecommands.network.MorecommandsModVariables;

public class DelhomeProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MorecommandsModVariables.PlayerVariables())).has_home == false) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You don't have a home"), (false));
		} else {
			{
				boolean _setval = false;
				entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.has_home = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Home successfuly deleted!"), (false));
		}
	}
}
