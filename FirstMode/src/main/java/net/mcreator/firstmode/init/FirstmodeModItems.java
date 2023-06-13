
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.firstmode.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.firstmode.FirstmodeMod;

public class FirstmodeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FirstmodeMod.MODID);
	public static final RegistryObject<Item> VULKAN_SPAWN_EGG = REGISTRY.register("vulkan_spawn_egg", () -> new ForgeSpawnEggItem(FirstmodeModEntities.VULKAN, -1, -1, new Item.Properties()));
}
