package net.minecraft.data.advancements.packs;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ChanneledLightningTrigger;
import net.minecraft.advancements.critereon.DamagePredicate;
import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.DistancePredicate;
import net.minecraft.advancements.critereon.DistanceTrigger;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.KilledByCrossbowTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.advancements.critereon.LighthingBoltPredicate;
import net.minecraft.advancements.critereon.LightningStrikeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.PlayerHurtEntityTrigger;
import net.minecraft.advancements.critereon.PlayerPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.advancements.critereon.ShotCrossbowTrigger;
import net.minecraft.advancements.critereon.SlideDownBlockTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.advancements.critereon.TargetBlockTrigger;
import net.minecraft.advancements.critereon.TradeTrigger;
import net.minecraft.advancements.critereon.UsedTotemTrigger;
import net.minecraft.advancements.critereon.UsingItemTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.block.Blocks;

public class VanillaAdventureAdvancements implements AdvancementSubProvider {
   private static final int DISTANCE_FROM_BOTTOM_TO_TOP = 384;
   private static final int Y_COORDINATE_AT_TOP = 320;
   private static final int Y_COORDINATE_AT_BOTTOM = -64;
   private static final int BEDROCK_THICKNESS = 5;
   private static final EntityType<?>[] MOBS_TO_KILL = new EntityType[]{EntityType.BLAZE, EntityType.CAVE_SPIDER, EntityType.CREEPER, EntityType.DROWNED, EntityType.ELDER_GUARDIAN, EntityType.ENDER_DRAGON, EntityType.ENDERMAN, EntityType.ENDERMITE, EntityType.EVOKER, EntityType.GHAST, EntityType.GUARDIAN, EntityType.HOGLIN, EntityType.HUSK, EntityType.MAGMA_CUBE, EntityType.PHANTOM, EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.PILLAGER, EntityType.RAVAGER, EntityType.SHULKER, EntityType.SILVERFISH, EntityType.SKELETON, EntityType.SLIME, EntityType.SPIDER, EntityType.STRAY, EntityType.VEX, EntityType.VINDICATOR, EntityType.WITCH, EntityType.WITHER_SKELETON, EntityType.WITHER, EntityType.ZOGLIN, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIE, EntityType.ZOMBIFIED_PIGLIN};

   private static LightningStrikeTrigger.TriggerInstance fireCountAndBystander(MinMaxBounds.Ints p_252298_, EntityPredicate p_251894_) {
      return LightningStrikeTrigger.TriggerInstance.lighthingStrike(EntityPredicate.Builder.entity().distance(DistancePredicate.absolute(MinMaxBounds.Doubles.atMost(30.0D))).subPredicate(LighthingBoltPredicate.blockSetOnFire(p_252298_)).build(), p_251894_);
   }

   private static UsingItemTrigger.TriggerInstance lookAtThroughItem(EntityType<?> p_249703_, Item p_250746_) {
      return UsingItemTrigger.TriggerInstance.lookingAt(EntityPredicate.Builder.entity().subPredicate(PlayerPredicate.Builder.player().setLookingAt(EntityPredicate.Builder.entity().of(p_249703_).build()).build()), ItemPredicate.Builder.item().of(p_250746_));
   }

   public void generate(HolderLookup.Provider p_255887_, Consumer<Advancement> p_256428_) {
      Advancement advancement = Advancement.Builder.advancement().display(Items.MAP, Component.translatable("advancements.adventure.root.title"), Component.translatable("advancements.adventure.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"), FrameType.TASK, false, false, false).requirements(RequirementsStrategy.OR).addCriterion("killed_something", KilledTrigger.TriggerInstance.playerKilledEntity()).addCriterion("killed_by_something", KilledTrigger.TriggerInstance.entityKilledPlayer()).save(p_256428_, "adventure/root");
      Advancement advancement1 = Advancement.Builder.advancement().parent(advancement).display(Blocks.RED_BED, Component.translatable("advancements.adventure.sleep_in_bed.title"), Component.translatable("advancements.adventure.sleep_in_bed.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("slept_in_bed", PlayerTrigger.TriggerInstance.sleptInBed()).save(p_256428_, "adventure/sleep_in_bed");
      createAdventuringTime(p_256428_, advancement1, MultiNoiseBiomeSourceParameterList.Preset.OVERWORLD);
      Advancement advancement2 = Advancement.Builder.advancement().parent(advancement).display(Items.EMERALD, Component.translatable("advancements.adventure.trade.title"), Component.translatable("advancements.adventure.trade.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("traded", TradeTrigger.TriggerInstance.tradedWithVillager()).save(p_256428_, "adventure/trade");
      Advancement.Builder.advancement().parent(advancement2).display(Items.EMERALD, Component.translatable("advancements.adventure.trade_at_world_height.title"), Component.translatable("advancements.adventure.trade_at_world_height.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("trade_at_world_height", TradeTrigger.TriggerInstance.tradedWithVillager(EntityPredicate.Builder.entity().located(LocationPredicate.atYLocation(MinMaxBounds.Doubles.atLeast(319.0D))))).save(p_256428_, "adventure/trade_at_world_height");
      Advancement advancement3 = this.addMobsToKill(Advancement.Builder.advancement()).parent(advancement).display(Items.IRON_SWORD, Component.translatable("advancements.adventure.kill_a_mob.title"), Component.translatable("advancements.adventure.kill_a_mob.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).save(p_256428_, "adventure/kill_a_mob");
      this.addMobsToKill(Advancement.Builder.advancement()).parent(advancement3).display(Items.DIAMOND_SWORD, Component.translatable("advancements.adventure.kill_all_mobs.title"), Component.translatable("advancements.adventure.kill_all_mobs.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).save(p_256428_, "adventure/kill_all_mobs");
      Advancement advancement4 = Advancement.Builder.advancement().parent(advancement3).display(Items.BOW, Component.translatable("advancements.adventure.shoot_arrow.title"), Component.translatable("advancements.adventure.shoot_arrow.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("shot_arrow", PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntity(DamagePredicate.Builder.damageInstance().type(DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE)).direct(EntityPredicate.Builder.entity().of(EntityTypeTags.ARROWS))))).save(p_256428_, "adventure/shoot_arrow");
      Advancement advancement5 = Advancement.Builder.advancement().parent(advancement3).display(Items.TRIDENT, Component.translatable("advancements.adventure.throw_trident.title"), Component.translatable("advancements.adventure.throw_trident.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("shot_trident", PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntity(DamagePredicate.Builder.damageInstance().type(DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE)).direct(EntityPredicate.Builder.entity().of(EntityType.TRIDENT))))).save(p_256428_, "adventure/throw_trident");
      Advancement.Builder.advancement().parent(advancement5).display(Items.TRIDENT, Component.translatable("advancements.adventure.very_very_frightening.title"), Component.translatable("advancements.adventure.very_very_frightening.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("struck_villager", ChanneledLightningTrigger.TriggerInstance.channeledLightning(EntityPredicate.Builder.entity().of(EntityType.VILLAGER).build())).save(p_256428_, "adventure/very_very_frightening");
      Advancement.Builder.advancement().parent(advancement2).display(Blocks.CARVED_PUMPKIN, Component.translatable("advancements.adventure.summon_iron_golem.title"), Component.translatable("advancements.adventure.summon_iron_golem.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("summoned_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.IRON_GOLEM))).save(p_256428_, "adventure/summon_iron_golem");
      Advancement.Builder.advancement().parent(advancement4).display(Items.ARROW, Component.translatable("advancements.adventure.sniper_duel.title"), Component.translatable("advancements.adventure.sniper_duel.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(50)).addCriterion("killed_skeleton", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.SKELETON).distance(DistancePredicate.horizontal(MinMaxBounds.Doubles.atLeast(50.0D))), DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE)))).save(p_256428_, "adventure/sniper_duel");
      Advancement.Builder.advancement().parent(advancement3).display(Items.TOTEM_OF_UNDYING, Component.translatable("advancements.adventure.totem_of_undying.title"), Component.translatable("advancements.adventure.totem_of_undying.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("used_totem", UsedTotemTrigger.TriggerInstance.usedTotem(Items.TOTEM_OF_UNDYING)).save(p_256428_, "adventure/totem_of_undying");
      Advancement advancement6 = Advancement.Builder.advancement().parent(advancement).display(Items.CROSSBOW, Component.translatable("advancements.adventure.ol_betsy.title"), Component.translatable("advancements.adventure.ol_betsy.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("shot_crossbow", ShotCrossbowTrigger.TriggerInstance.shotCrossbow(Items.CROSSBOW)).save(p_256428_, "adventure/ol_betsy");
      Advancement.Builder.advancement().parent(advancement6).display(Items.CROSSBOW, Component.translatable("advancements.adventure.whos_the_pillager_now.title"), Component.translatable("advancements.adventure.whos_the_pillager_now.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("kill_pillager", KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(EntityPredicate.Builder.entity().of(EntityType.PILLAGER))).save(p_256428_, "adventure/whos_the_pillager_now");
      Advancement.Builder.advancement().parent(advancement6).display(Items.CROSSBOW, Component.translatable("advancements.adventure.two_birds_one_arrow.title"), Component.translatable("advancements.adventure.two_birds_one_arrow.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(65)).addCriterion("two_birds", KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(EntityPredicate.Builder.entity().of(EntityType.PHANTOM), EntityPredicate.Builder.entity().of(EntityType.PHANTOM))).save(p_256428_, "adventure/two_birds_one_arrow");
      Advancement.Builder.advancement().parent(advancement6).display(Items.CROSSBOW, Component.translatable("advancements.adventure.arbalistic.title"), Component.translatable("advancements.adventure.arbalistic.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, true).rewards(AdvancementRewards.Builder.experience(85)).addCriterion("arbalistic", KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(MinMaxBounds.Ints.exactly(5))).save(p_256428_, "adventure/arbalistic");
      Advancement advancement7 = Advancement.Builder.advancement().parent(advancement).display(Raid.getLeaderBannerInstance(), Component.translatable("advancements.adventure.voluntary_exile.title"), Component.translatable("advancements.adventure.voluntary_exile.description"), (ResourceLocation)null, FrameType.TASK, true, true, true).addCriterion("voluntary_exile", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityTypeTags.RAIDERS).equipment(EntityEquipmentPredicate.CAPTAIN))).save(p_256428_, "adventure/voluntary_exile");
      Advancement.Builder.advancement().parent(advancement7).display(Raid.getLeaderBannerInstance(), Component.translatable("advancements.adventure.hero_of_the_village.title"), Component.translatable("advancements.adventure.hero_of_the_village.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, true).rewards(AdvancementRewards.Builder.experience(100)).addCriterion("hero_of_the_village", PlayerTrigger.TriggerInstance.raidWon()).save(p_256428_, "adventure/hero_of_the_village");
      Advancement.Builder.advancement().parent(advancement).display(Blocks.HONEY_BLOCK.asItem(), Component.translatable("advancements.adventure.honey_block_slide.title"), Component.translatable("advancements.adventure.honey_block_slide.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("honey_block_slide", SlideDownBlockTrigger.TriggerInstance.slidesDownBlock(Blocks.HONEY_BLOCK)).save(p_256428_, "adventure/honey_block_slide");
      Advancement.Builder.advancement().parent(advancement4).display(Blocks.TARGET.asItem(), Component.translatable("advancements.adventure.bullseye.title"), Component.translatable("advancements.adventure.bullseye.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(50)).addCriterion("bullseye", TargetBlockTrigger.TriggerInstance.targetHit(MinMaxBounds.Ints.exactly(15), EntityPredicate.Composite.wrap(EntityPredicate.Builder.entity().distance(DistancePredicate.horizontal(MinMaxBounds.Doubles.atLeast(30.0D))).build()))).save(p_256428_, "adventure/bullseye");
      Advancement.Builder.advancement().parent(advancement1).display(Items.LEATHER_BOOTS, Component.translatable("advancements.adventure.walk_on_powder_snow_with_leather_boots.title"), Component.translatable("advancements.adventure.walk_on_powder_snow_with_leather_boots.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("walk_on_powder_snow_with_leather_boots", PlayerTrigger.TriggerInstance.walkOnBlockWithEquipment(Blocks.POWDER_SNOW, Items.LEATHER_BOOTS)).save(p_256428_, "adventure/walk_on_powder_snow_with_leather_boots");
      Advancement.Builder.advancement().parent(advancement).display(Items.LIGHTNING_ROD, Component.translatable("advancements.adventure.lightning_rod_with_villager_no_fire.title"), Component.translatable("advancements.adventure.lightning_rod_with_villager_no_fire.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("lightning_rod_with_villager_no_fire", fireCountAndBystander(MinMaxBounds.Ints.exactly(0), EntityPredicate.Builder.entity().of(EntityType.VILLAGER).build())).save(p_256428_, "adventure/lightning_rod_with_villager_no_fire");
      Advancement advancement8 = Advancement.Builder.advancement().parent(advancement).display(Items.SPYGLASS, Component.translatable("advancements.adventure.spyglass_at_parrot.title"), Component.translatable("advancements.adventure.spyglass_at_parrot.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("spyglass_at_parrot", lookAtThroughItem(EntityType.PARROT, Items.SPYGLASS)).save(p_256428_, "adventure/spyglass_at_parrot");
      Advancement advancement9 = Advancement.Builder.advancement().parent(advancement8).display(Items.SPYGLASS, Component.translatable("advancements.adventure.spyglass_at_ghast.title"), Component.translatable("advancements.adventure.spyglass_at_ghast.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("spyglass_at_ghast", lookAtThroughItem(EntityType.GHAST, Items.SPYGLASS)).save(p_256428_, "adventure/spyglass_at_ghast");
      Advancement.Builder.advancement().parent(advancement1).display(Items.JUKEBOX, Component.translatable("advancements.adventure.play_jukebox_in_meadows.title"), Component.translatable("advancements.adventure.play_jukebox_in_meadows.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("play_jukebox_in_meadows", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBiome(Biomes.MEADOW).setBlock(BlockPredicate.Builder.block().of(Blocks.JUKEBOX).build()), ItemPredicate.Builder.item().of(ItemTags.MUSIC_DISCS))).save(p_256428_, "adventure/play_jukebox_in_meadows");
      Advancement.Builder.advancement().parent(advancement9).display(Items.SPYGLASS, Component.translatable("advancements.adventure.spyglass_at_dragon.title"), Component.translatable("advancements.adventure.spyglass_at_dragon.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("spyglass_at_dragon", lookAtThroughItem(EntityType.ENDER_DRAGON, Items.SPYGLASS)).save(p_256428_, "adventure/spyglass_at_dragon");
      Advancement.Builder.advancement().parent(advancement).display(Items.WATER_BUCKET, Component.translatable("advancements.adventure.fall_from_world_height.title"), Component.translatable("advancements.adventure.fall_from_world_height.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("fall_from_world_height", DistanceTrigger.TriggerInstance.fallFromHeight(EntityPredicate.Builder.entity().located(LocationPredicate.atYLocation(MinMaxBounds.Doubles.atMost(-59.0D))), DistancePredicate.vertical(MinMaxBounds.Doubles.atLeast(379.0D)), LocationPredicate.atYLocation(MinMaxBounds.Doubles.atLeast(319.0D)))).save(p_256428_, "adventure/fall_from_world_height");
      Advancement.Builder.advancement().parent(advancement3).display(Blocks.SCULK_CATALYST, Component.translatable("advancements.adventure.kill_mob_near_sculk_catalyst.title"), Component.translatable("advancements.adventure.kill_mob_near_sculk_catalyst.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).addCriterion("kill_mob_near_sculk_catalyst", KilledTrigger.TriggerInstance.playerKilledEntityNearSculkCatalyst()).save(p_256428_, "adventure/kill_mob_near_sculk_catalyst");
      Advancement.Builder.advancement().parent(advancement).display(Blocks.SCULK_SENSOR, Component.translatable("advancements.adventure.avoid_vibration.title"), Component.translatable("advancements.adventure.avoid_vibration.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("avoid_vibration", PlayerTrigger.TriggerInstance.avoidVibration()).save(p_256428_, "adventure/avoid_vibration");
   }

   protected static void createAdventuringTime(Consumer<Advancement> p_275645_, Advancement p_275219_, MultiNoiseBiomeSourceParameterList.Preset p_275211_) {
      addBiomes(Advancement.Builder.advancement(), p_275211_.usedBiomes().toList()).parent(p_275219_).display(Items.DIAMOND_BOOTS, Component.translatable("advancements.adventure.adventuring_time.title"), Component.translatable("advancements.adventure.adventuring_time.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(500)).save(p_275645_, "adventure/adventuring_time");
   }

   private Advancement.Builder addMobsToKill(Advancement.Builder p_248814_) {
      for(EntityType<?> entitytype : MOBS_TO_KILL) {
         p_248814_.addCriterion(BuiltInRegistries.ENTITY_TYPE.getKey(entitytype).toString(), KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entitytype)));
      }

      return p_248814_;
   }

   protected static Advancement.Builder addBiomes(Advancement.Builder p_249250_, List<ResourceKey<Biome>> p_251338_) {
      for(ResourceKey<Biome> resourcekey : p_251338_) {
         p_249250_.addCriterion(resourcekey.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(resourcekey)));
      }

      return p_249250_;
   }
}