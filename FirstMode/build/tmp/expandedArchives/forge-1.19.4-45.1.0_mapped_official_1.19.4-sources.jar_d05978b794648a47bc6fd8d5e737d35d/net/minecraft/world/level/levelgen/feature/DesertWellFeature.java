package net.minecraft.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.stream.Stream;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.packs.UpdateOneTwentyBuiltInLootTables;
import net.minecraft.util.RandomSource;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.apache.commons.lang3.mutable.MutableInt;

public class DesertWellFeature extends Feature<NoneFeatureConfiguration> {
   private static final BlockStatePredicate IS_SAND = BlockStatePredicate.forBlock(Blocks.SAND);
   private final BlockState sandSlab = Blocks.SANDSTONE_SLAB.defaultBlockState();
   private final BlockState sandstone = Blocks.SANDSTONE.defaultBlockState();
   private final BlockState water = Blocks.WATER.defaultBlockState();

   public DesertWellFeature(Codec<NoneFeatureConfiguration> p_65599_) {
      super(p_65599_);
   }

   public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159571_) {
      WorldGenLevel worldgenlevel = p_159571_.level();
      BlockPos blockpos = p_159571_.origin();

      for(blockpos = blockpos.above(); worldgenlevel.isEmptyBlock(blockpos) && blockpos.getY() > worldgenlevel.getMinBuildHeight() + 2; blockpos = blockpos.below()) {
      }

      if (!IS_SAND.test(worldgenlevel.getBlockState(blockpos))) {
         return false;
      } else {
         for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
               if (worldgenlevel.isEmptyBlock(blockpos.offset(i, -1, j)) && worldgenlevel.isEmptyBlock(blockpos.offset(i, -2, j))) {
                  return false;
               }
            }
         }

         for(int l = -1; l <= 0; ++l) {
            for(int l1 = -2; l1 <= 2; ++l1) {
               for(int k = -2; k <= 2; ++k) {
                  worldgenlevel.setBlock(blockpos.offset(l1, l, k), this.sandstone, 2);
               }
            }
         }

         if (worldgenlevel.enabledFeatures().contains(FeatureFlags.UPDATE_1_20)) {
            placeSandFloor(worldgenlevel, blockpos, p_159571_.random());
         }

         worldgenlevel.setBlock(blockpos, this.water, 2);

         for(Direction direction : Direction.Plane.HORIZONTAL) {
            worldgenlevel.setBlock(blockpos.relative(direction), this.water, 2);
         }

         for(int i1 = -2; i1 <= 2; ++i1) {
            for(int i2 = -2; i2 <= 2; ++i2) {
               if (i1 == -2 || i1 == 2 || i2 == -2 || i2 == 2) {
                  worldgenlevel.setBlock(blockpos.offset(i1, 1, i2), this.sandstone, 2);
               }
            }
         }

         worldgenlevel.setBlock(blockpos.offset(2, 1, 0), this.sandSlab, 2);
         worldgenlevel.setBlock(blockpos.offset(-2, 1, 0), this.sandSlab, 2);
         worldgenlevel.setBlock(blockpos.offset(0, 1, 2), this.sandSlab, 2);
         worldgenlevel.setBlock(blockpos.offset(0, 1, -2), this.sandSlab, 2);

         for(int j1 = -1; j1 <= 1; ++j1) {
            for(int j2 = -1; j2 <= 1; ++j2) {
               if (j1 == 0 && j2 == 0) {
                  worldgenlevel.setBlock(blockpos.offset(j1, 4, j2), this.sandstone, 2);
               } else {
                  worldgenlevel.setBlock(blockpos.offset(j1, 4, j2), this.sandSlab, 2);
               }
            }
         }

         for(int k1 = 1; k1 <= 3; ++k1) {
            worldgenlevel.setBlock(blockpos.offset(-1, k1, -1), this.sandstone, 2);
            worldgenlevel.setBlock(blockpos.offset(-1, k1, 1), this.sandstone, 2);
            worldgenlevel.setBlock(blockpos.offset(1, k1, -1), this.sandstone, 2);
            worldgenlevel.setBlock(blockpos.offset(1, k1, 1), this.sandstone, 2);
         }

         return true;
      }
   }

   private static void placeSandFloor(WorldGenLevel p_272978_, BlockPos p_273348_, RandomSource p_273431_) {
      BlockPos blockpos = p_273348_.offset(0, -1, 0);
      ObjectArrayList<BlockPos> objectarraylist = Util.make(new ObjectArrayList<>(), (p_273498_) -> {
         p_273498_.add(blockpos.east());
         p_273498_.add(blockpos.south());
         p_273498_.add(blockpos.west());
         p_273498_.add(blockpos.north());
      });
      Util.shuffle(objectarraylist, p_273431_);
      MutableInt mutableint = new MutableInt(p_273431_.nextInt(2, 4));
      Stream.concat(Stream.of(blockpos), objectarraylist.stream()).forEach((p_272729_) -> {
         if (mutableint.getAndDecrement() > 0) {
            p_272978_.setBlock(p_272729_, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 3);
            p_272978_.getBlockEntity(p_272729_, BlockEntityType.SUSPICIOUS_SAND).ifPresent((p_273395_) -> {
               p_273395_.setLootTable(UpdateOneTwentyBuiltInLootTables.DESERT_WELL_ARCHAEOLOGY, p_272729_.asLong());
            });
         } else {
            p_272978_.setBlock(p_272729_, Blocks.SAND.defaultBlockState(), 3);
         }

      });
   }
}