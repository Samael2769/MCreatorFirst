package net.minecraft.world.level.levelgen.structure.templatesystem;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;

public abstract class StructureProcessor {
   @Nullable
   @Deprecated //Forge: Use process below, with the Template context
   public StructureTemplate.StructureBlockInfo processBlock(LevelReader p_74416_, BlockPos p_74417_, BlockPos p_74418_, StructureTemplate.StructureBlockInfo p_74419_, StructureTemplate.StructureBlockInfo p_74420_, StructurePlaceSettings p_74421_) {
      return p_74420_;
   }

   protected abstract StructureProcessorType<?> getType();

   @Nullable
   public StructureTemplate.StructureBlockInfo process(LevelReader p_74140_, BlockPos p_74141_, BlockPos p_74142_, StructureTemplate.StructureBlockInfo p_74143_, StructureTemplate.StructureBlockInfo p_74144_, StructurePlaceSettings p_74145_, @Nullable StructureTemplate template) {
      return processBlock(p_74140_, p_74141_, p_74142_, p_74143_, p_74144_, p_74145_);
   }

   /**
    * FORGE: Add entity processing.
    * <p>
    * Use this method to process entities from a structure in much the same way as
    * blocks, parameters are analogous.
    *
    * @param world
    * @param seedPos
    * @param rawEntityInfo
    * @param entityInfo
    * @param placementSettings
    * @param template
    *
    * @see #process(LevelReader, BlockPos, BlockPos, StructureTemplate.StructureBlockInfo, StructureTemplate.StructureBlockInfo, StructurePlaceSettings, StructureTemplate)
    */
   public StructureTemplate.StructureEntityInfo processEntity(LevelReader world, BlockPos seedPos, StructureTemplate.StructureEntityInfo rawEntityInfo, StructureTemplate.StructureEntityInfo entityInfo, StructurePlaceSettings placementSettings, StructureTemplate template) {
      return entityInfo;
   }

   public void finalizeStructure(LevelAccessor p_273167_, BlockPos p_273713_, BlockPos p_272620_, StructurePlaceSettings p_272830_, List<StructureTemplate.StructureBlockInfo> p_273019_) {
   }
}
