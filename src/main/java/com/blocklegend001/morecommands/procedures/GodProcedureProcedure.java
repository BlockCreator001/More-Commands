package com.blocklegend001.morecommands.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.blocklegend001.morecommands.MorecommandsModVariables;
import com.blocklegend001.morecommands.MorecommandsMod;

public class GodProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MorecommandsMod.LOGGER.warn("Failed to load dependency entity for procedure GodProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MorecommandsModVariables.PlayerVariables())).godmodeEnabled == false) {
			{
				boolean _setval = (true);
				entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.godmodeEnabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("God Mode Activated"), (false));
			}
		} else {
			{
				boolean _setval = (false);
				entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.godmodeEnabled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("God Mode Disabled"), (false));
			}
		}
	}
}
