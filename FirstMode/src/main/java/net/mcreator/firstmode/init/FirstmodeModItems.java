
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.firstmode.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.firstmode.item.VulkanSwordItem;
import net.mcreator.firstmode.item.VulkanScaleItem;
import net.mcreator.firstmode.item.VulkanPickaxeItem;
import net.mcreator.firstmode.item.VulkanMagnetItem;
import net.mcreator.firstmode.item.VulkanAxeItem;
import net.mcreator.firstmode.item.VulkanArmorItem;
import net.mcreator.firstmode.FirstmodeMod;

public class FirstmodeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FirstmodeMod.MODID);
	public static final RegistryObject<Item> VULKAN_SCALE = REGISTRY.register("vulkan_scale", () -> new VulkanScaleItem());
	public static final RegistryObject<Item> VULKAN_SPAWN_EGG = REGISTRY.register("vulkan_spawn_egg", () -> new ForgeSpawnEggItem(FirstmodeModEntities.VULKAN, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> VULKAN_ARMOR_HELMET = REGISTRY.register("vulkan_armor_helmet", () -> new VulkanArmorItem.Helmet());
	public static final RegistryObject<Item> VULKAN_ARMOR_CHESTPLATE = REGISTRY.register("vulkan_armor_chestplate", () -> new VulkanArmorItem.Chestplate());
	public static final RegistryObject<Item> VULKAN_ARMOR_LEGGINGS = REGISTRY.register("vulkan_armor_leggings", () -> new VulkanArmorItem.Leggings());
	public static final RegistryObject<Item> VULKAN_ARMOR_BOOTS = REGISTRY.register("vulkan_armor_boots", () -> new VulkanArmorItem.Boots());
	public static final RegistryObject<Item> VULKAN_SWORD = REGISTRY.register("vulkan_sword", () -> new VulkanSwordItem());
	public static final RegistryObject<Item> VULKAN_PICKAXE = REGISTRY.register("vulkan_pickaxe", () -> new VulkanPickaxeItem());
	public static final RegistryObject<Item> VULKAN_AXE = REGISTRY.register("vulkan_axe", () -> new VulkanAxeItem());
	public static final RegistryObject<Item> VULKAN_MAGNET = REGISTRY.register("vulkan_magnet", () -> new VulkanMagnetItem());
}
