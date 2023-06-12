package net.minecraft.data.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public abstract class BiomeData {
   public static void bootstrap(BootstapContext<Biome> p_273095_) {
      HolderGetter<PlacedFeature> holdergetter = p_273095_.lookup(Registries.PLACED_FEATURE);
      HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = p_273095_.lookup(Registries.CONFIGURED_CARVER);
      p_273095_.register(Biomes.THE_VOID, OverworldBiomes.theVoid(holdergetter, holdergetter1));
      p_273095_.register(Biomes.PLAINS, OverworldBiomes.plains(holdergetter, holdergetter1, false, false, false));
      p_273095_.register(Biomes.SUNFLOWER_PLAINS, OverworldBiomes.plains(holdergetter, holdergetter1, true, false, false));
      p_273095_.register(Biomes.SNOWY_PLAINS, OverworldBiomes.plains(holdergetter, holdergetter1, false, true, false));
      p_273095_.register(Biomes.ICE_SPIKES, OverworldBiomes.plains(holdergetter, holdergetter1, false, true, true));
      p_273095_.register(Biomes.DESERT, OverworldBiomes.desert(holdergetter, holdergetter1));
      p_273095_.register(Biomes.SWAMP, OverworldBiomes.swamp(holdergetter, holdergetter1));
      p_273095_.register(Biomes.MANGROVE_SWAMP, OverworldBiomes.mangroveSwamp(holdergetter, holdergetter1));
      p_273095_.register(Biomes.FOREST, OverworldBiomes.forest(holdergetter, holdergetter1, false, false, false));
      p_273095_.register(Biomes.FLOWER_FOREST, OverworldBiomes.forest(holdergetter, holdergetter1, false, false, true));
      p_273095_.register(Biomes.BIRCH_FOREST, OverworldBiomes.forest(holdergetter, holdergetter1, true, false, false));
      p_273095_.register(Biomes.DARK_FOREST, OverworldBiomes.darkForest(holdergetter, holdergetter1));
      p_273095_.register(Biomes.OLD_GROWTH_BIRCH_FOREST, OverworldBiomes.forest(holdergetter, holdergetter1, true, true, false));
      p_273095_.register(Biomes.OLD_GROWTH_PINE_TAIGA, OverworldBiomes.oldGrowthTaiga(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.OLD_GROWTH_SPRUCE_TAIGA, OverworldBiomes.oldGrowthTaiga(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.TAIGA, OverworldBiomes.taiga(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.SNOWY_TAIGA, OverworldBiomes.taiga(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.SAVANNA, OverworldBiomes.savanna(holdergetter, holdergetter1, false, false));
      p_273095_.register(Biomes.SAVANNA_PLATEAU, OverworldBiomes.savanna(holdergetter, holdergetter1, false, true));
      p_273095_.register(Biomes.WINDSWEPT_HILLS, OverworldBiomes.windsweptHills(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.WINDSWEPT_GRAVELLY_HILLS, OverworldBiomes.windsweptHills(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.WINDSWEPT_FOREST, OverworldBiomes.windsweptHills(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.WINDSWEPT_SAVANNA, OverworldBiomes.savanna(holdergetter, holdergetter1, true, false));
      p_273095_.register(Biomes.JUNGLE, OverworldBiomes.jungle(holdergetter, holdergetter1));
      p_273095_.register(Biomes.SPARSE_JUNGLE, OverworldBiomes.sparseJungle(holdergetter, holdergetter1));
      p_273095_.register(Biomes.BAMBOO_JUNGLE, OverworldBiomes.bambooJungle(holdergetter, holdergetter1));
      p_273095_.register(Biomes.BADLANDS, OverworldBiomes.badlands(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.ERODED_BADLANDS, OverworldBiomes.badlands(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.WOODED_BADLANDS, OverworldBiomes.badlands(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.MEADOW, OverworldBiomes.meadowOrCherryGrove(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.GROVE, OverworldBiomes.grove(holdergetter, holdergetter1));
      p_273095_.register(Biomes.SNOWY_SLOPES, OverworldBiomes.snowySlopes(holdergetter, holdergetter1));
      p_273095_.register(Biomes.FROZEN_PEAKS, OverworldBiomes.frozenPeaks(holdergetter, holdergetter1));
      p_273095_.register(Biomes.JAGGED_PEAKS, OverworldBiomes.jaggedPeaks(holdergetter, holdergetter1));
      p_273095_.register(Biomes.STONY_PEAKS, OverworldBiomes.stonyPeaks(holdergetter, holdergetter1));
      p_273095_.register(Biomes.RIVER, OverworldBiomes.river(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.FROZEN_RIVER, OverworldBiomes.river(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.BEACH, OverworldBiomes.beach(holdergetter, holdergetter1, false, false));
      p_273095_.register(Biomes.SNOWY_BEACH, OverworldBiomes.beach(holdergetter, holdergetter1, true, false));
      p_273095_.register(Biomes.STONY_SHORE, OverworldBiomes.beach(holdergetter, holdergetter1, false, true));
      p_273095_.register(Biomes.WARM_OCEAN, OverworldBiomes.warmOcean(holdergetter, holdergetter1));
      p_273095_.register(Biomes.LUKEWARM_OCEAN, OverworldBiomes.lukeWarmOcean(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.DEEP_LUKEWARM_OCEAN, OverworldBiomes.lukeWarmOcean(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.OCEAN, OverworldBiomes.ocean(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.DEEP_OCEAN, OverworldBiomes.ocean(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.COLD_OCEAN, OverworldBiomes.coldOcean(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.DEEP_COLD_OCEAN, OverworldBiomes.coldOcean(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.FROZEN_OCEAN, OverworldBiomes.frozenOcean(holdergetter, holdergetter1, false));
      p_273095_.register(Biomes.DEEP_FROZEN_OCEAN, OverworldBiomes.frozenOcean(holdergetter, holdergetter1, true));
      p_273095_.register(Biomes.MUSHROOM_FIELDS, OverworldBiomes.mushroomFields(holdergetter, holdergetter1));
      p_273095_.register(Biomes.DRIPSTONE_CAVES, OverworldBiomes.dripstoneCaves(holdergetter, holdergetter1));
      p_273095_.register(Biomes.LUSH_CAVES, OverworldBiomes.lushCaves(holdergetter, holdergetter1));
      p_273095_.register(Biomes.DEEP_DARK, OverworldBiomes.deepDark(holdergetter, holdergetter1));
      p_273095_.register(Biomes.NETHER_WASTES, NetherBiomes.netherWastes(holdergetter, holdergetter1));
      p_273095_.register(Biomes.WARPED_FOREST, NetherBiomes.warpedForest(holdergetter, holdergetter1));
      p_273095_.register(Biomes.CRIMSON_FOREST, NetherBiomes.crimsonForest(holdergetter, holdergetter1));
      p_273095_.register(Biomes.SOUL_SAND_VALLEY, NetherBiomes.soulSandValley(holdergetter, holdergetter1));
      p_273095_.register(Biomes.BASALT_DELTAS, NetherBiomes.basaltDeltas(holdergetter, holdergetter1));
      p_273095_.register(Biomes.THE_END, EndBiomes.theEnd(holdergetter, holdergetter1));
      p_273095_.register(Biomes.END_HIGHLANDS, EndBiomes.endHighlands(holdergetter, holdergetter1));
      p_273095_.register(Biomes.END_MIDLANDS, EndBiomes.endMidlands(holdergetter, holdergetter1));
      p_273095_.register(Biomes.SMALL_END_ISLANDS, EndBiomes.smallEndIslands(holdergetter, holdergetter1));
      p_273095_.register(Biomes.END_BARRENS, EndBiomes.endBarrens(holdergetter, holdergetter1));
   }

   public static void nextUpdate(BootstapContext<Biome> p_273661_) {
      HolderGetter<PlacedFeature> holdergetter = p_273661_.lookup(Registries.PLACED_FEATURE);
      HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = p_273661_.lookup(Registries.CONFIGURED_CARVER);
      p_273661_.register(Biomes.CHERRY_GROVE, OverworldBiomes.meadowOrCherryGrove(holdergetter, holdergetter1, true));
   }
}