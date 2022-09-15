package com.blocklegend001.morecommands.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import com.blocklegend001.morecommands.network.MorecommandsModVariables;

public class GodProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MorecommandsModVariables.PlayerVariables())).godmodeEnabled == false) {
			{
				boolean _setval = true;
				entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.godmodeEnabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("God Mode Activated"), (false));
		} else {
			{
				boolean _setval = false;
				entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.godmodeEnabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("God Mode Disabled"), (false));
		}
	}
}
