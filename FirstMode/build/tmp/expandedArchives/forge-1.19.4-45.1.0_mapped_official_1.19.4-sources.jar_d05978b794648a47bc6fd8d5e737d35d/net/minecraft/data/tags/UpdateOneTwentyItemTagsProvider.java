package net.minecraft.data.tags;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class UpdateOneTwentyItemTagsProvider extends ItemTagsProvider {
   public UpdateOneTwentyItemTagsProvider(PackOutput p_275243_, CompletableFuture<HolderLookup.Provider> p_275444_, CompletableFuture<TagsProvider.TagLookup<Item>> p_275213_, CompletableFuture<TagsProvider.TagLookup<Block>> p_275641_) {
      super(p_275243_, p_275444_, p_275213_, p_275641_);
   }

   protected void addTags(HolderLookup.Provider p_256409_) {
      this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
      this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
      this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
      this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
      this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
      this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
      this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
      this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
      this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
      this.copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
      this.copy(BlockTags.BAMBOO_BLOCKS, ItemTags.BAMBOO_BLOCKS);
      this.copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
      this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
      this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
      this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
      this.copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
      this.copy(BlockTags.SAND, ItemTags.SAND);
      this.tag(ItemTags.CHEST_BOATS).add(Items.BAMBOO_CHEST_RAFT);
      this.tag(ItemTags.BOATS).add(Items.BAMBOO_RAFT);
      this.tag(ItemTags.BOOKSHELF_BOOKS).add(Items.BOOK, Items.WRITTEN_BOOK, Items.ENCHANTED_BOOK, Items.WRITABLE_BOOK);
      this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(Items.WARPED_HANGING_SIGN, Items.CRIMSON_HANGING_SIGN);
      this.tag(ItemTags.NOTE_BLOCK_TOP_INSTRUMENTS).add(Items.ZOMBIE_HEAD, Items.SKELETON_SKULL, Items.CREEPER_HEAD, Items.DRAGON_HEAD, Items.WITHER_SKELETON_SKULL, Items.PIGLIN_HEAD, Items.PLAYER_HEAD);
      this.tag(ItemTags.TRIMMABLE_ARMOR).add(Items.NETHERITE_HELMET).add(Items.NETHERITE_CHESTPLATE).add(Items.NETHERITE_LEGGINGS).add(Items.NETHERITE_BOOTS).add(Items.DIAMOND_HELMET).add(Items.DIAMOND_CHESTPLATE).add(Items.DIAMOND_LEGGINGS).add(Items.DIAMOND_BOOTS).add(Items.GOLDEN_HELMET).add(Items.GOLDEN_CHESTPLATE).add(Items.GOLDEN_LEGGINGS).add(Items.GOLDEN_BOOTS).add(Items.IRON_HELMET).add(Items.IRON_CHESTPLATE).add(Items.IRON_LEGGINGS).add(Items.IRON_BOOTS).add(Items.CHAINMAIL_HELMET).add(Items.CHAINMAIL_CHESTPLATE).add(Items.CHAINMAIL_LEGGINGS).add(Items.CHAINMAIL_BOOTS).add(Items.LEATHER_HELMET).add(Items.LEATHER_CHESTPLATE).add(Items.LEATHER_LEGGINGS).add(Items.LEATHER_BOOTS).add(Items.TURTLE_HELMET);
      this.tag(ItemTags.TRIM_MATERIALS).add(Items.IRON_INGOT).add(Items.COPPER_INGOT).add(Items.GOLD_INGOT).add(Items.LAPIS_LAZULI).add(Items.EMERALD).add(Items.DIAMOND).add(Items.NETHERITE_INGOT).add(Items.REDSTONE).add(Items.QUARTZ).add(Items.AMETHYST_SHARD);
      this.tag(ItemTags.TRIM_TEMPLATES).add(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE).add(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
      this.tag(ItemTags.SNIFFER_FOOD).add(Items.TORCHFLOWER_SEEDS);
      this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
      this.copy(BlockTags.CHERRY_LOGS, ItemTags.CHERRY_LOGS);
      this.tag(ItemTags.BOATS).add(Items.CHERRY_BOAT);
      this.tag(ItemTags.CHEST_BOATS).add(Items.CHERRY_CHEST_BOAT);
      this.tag(ItemTags.DECORATED_POT_SHARDS).add(Items.BRICK, Items.POTTERY_SHARD_ARCHER, Items.POTTERY_SHARD_PRIZE, Items.POTTERY_SHARD_ARMS_UP, Items.POTTERY_SHARD_SKULL);
      this.tag(ItemTags.BREAKS_DECORATED_POTS).addTag(ItemTags.TOOLS);
   }
}