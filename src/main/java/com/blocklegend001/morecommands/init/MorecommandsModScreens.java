
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.blocklegend001.morecommands.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.blocklegend001.morecommands.client.gui.DisposalGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MorecommandsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MorecommandsModMenus.DISPOSAL_GUI, DisposalGUIScreen::new);
		});
	}
}
