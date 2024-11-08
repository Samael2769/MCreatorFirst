package net.minecraft.data.loot.packs;

import java.util.List;
import java.util.Set;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class UpdateOneTwentyLootTableProvider {
   public static LootTableProvider create(PackOutput p_248721_) {
      return new LootTableProvider(p_248721_, Set.of(), List.of(new LootTableProvider.SubProviderEntry(UpdateOneTwentyFishingLoot::new, LootContextParamSets.FISHING), new LootTableProvider.SubProviderEntry(UpdateOneTwentyBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(UpdateOneTwentyChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(UpdateOneTwentyEntityLoot::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(UpdateOneTwentyArchaeologyLoot::new, LootContextParamSets.ARCHAEOLOGY)));
   }
}