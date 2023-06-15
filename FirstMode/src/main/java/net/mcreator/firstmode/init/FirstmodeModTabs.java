
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.firstmode.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirstmodeModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("firstmode", "vulkan_mod"),
				builder -> builder.title(Component.translatable("item_group.firstmode.vulkan_mod")).icon(() -> new ItemStack(FirstmodeModItems.VULKAN_SCALE.get())).displayItems((parameters, tabData) -> {
					tabData.accept(FirstmodeModItems.VULKAN_SCALE.get());
					tabData.accept(FirstmodeModItems.VULKAN_SPAWN_EGG.get());
					tabData.accept(FirstmodeModItems.VULKAN_ARMOR_HELMET.get());
					tabData.accept(FirstmodeModItems.VULKAN_ARMOR_CHESTPLATE.get());
					tabData.accept(FirstmodeModItems.VULKAN_ARMOR_LEGGINGS.get());
					tabData.accept(FirstmodeModItems.VULKAN_ARMOR_BOOTS.get());
					tabData.accept(FirstmodeModItems.VULKAN_SWORD.get());
					tabData.accept(FirstmodeModItems.VULKAN_PICKAXE.get());
					tabData.accept(FirstmodeModItems.VULKAN_AXE.get());
					tabData.accept(FirstmodeModItems.VULKAN_MAGNET.get());
				})

		);
	}
}
