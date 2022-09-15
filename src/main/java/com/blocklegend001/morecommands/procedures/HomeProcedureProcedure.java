package com.blocklegend001.morecommands.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

import com.blocklegend001.morecommands.MorecommandsModVariables;
import com.blocklegend001.morecommands.MorecommandsMod;

public class HomeProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MorecommandsMod.LOGGER.warn("Failed to load dependency entity for procedure HomeProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MorecommandsModVariables.PlayerVariables())).has_home == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You don't have a home set for the moment. Please set a new one"),
						(false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Teleporting to your home..."), (false));
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_x),
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_y),
						((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MorecommandsModVariables.PlayerVariables())).home_z));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_x),
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_y),
							((entity.getCapability(MorecommandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MorecommandsModVariables.PlayerVariables())).home_z),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		}
	}
}
