package net.minecraft.data.tags;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.GameEventTags;
import net.minecraft.world.level.gameevent.GameEvent;

public class GameEventTagsProvider extends IntrinsicHolderTagsProvider<GameEvent> {
   @VisibleForTesting
   static final GameEvent[] VIBRATIONS_EXCEPT_FLAP = new GameEvent[]{GameEvent.BLOCK_ATTACH, GameEvent.BLOCK_CHANGE, GameEvent.BLOCK_CLOSE, GameEvent.BLOCK_DESTROY, GameEvent.BLOCK_DETACH, GameEvent.BLOCK_OPEN, GameEvent.BLOCK_PLACE, GameEvent.BLOCK_ACTIVATE, GameEvent.BLOCK_DEACTIVATE, GameEvent.CONTAINER_CLOSE, GameEvent.CONTAINER_OPEN, GameEvent.DISPENSE_FAIL, GameEvent.DRINK, GameEvent.EAT, GameEvent.ELYTRA_GLIDE, GameEvent.ENTITY_DAMAGE, GameEvent.ENTITY_DIE, GameEvent.ENTITY_DISMOUNT, GameEvent.ENTITY_INTERACT, GameEvent.ENTITY_MOUNT, GameEvent.ENTITY_PLACE, GameEvent.ENTITY_ROAR, GameEvent.ENTITY_SHAKE, GameEvent.EQUIP, GameEvent.EXPLODE, GameEvent.FLUID_PICKUP, GameEvent.FLUID_PLACE, GameEvent.HIT_GROUND, GameEvent.INSTRUMENT_PLAY, GameEvent.ITEM_INTERACT_FINISH, GameEvent.LIGHTNING_STRIKE, GameEvent.NOTE_BLOCK_PLAY, GameEvent.PISTON_CONTRACT, GameEvent.PISTON_EXTEND, GameEvent.PRIME_FUSE, GameEvent.PROJECTILE_LAND, GameEvent.PROJECTILE_SHOOT, GameEvent.SHEAR, GameEvent.SPLASH, GameEvent.STEP, GameEvent.SWIM, GameEvent.TELEPORT};

   /** @deprecated Forge: Use the {@linkplain #GameEventTagsProvider(PackOutput, CompletableFuture, String, net.minecraftforge.common.data.ExistingFileHelper) mod id variant} */
   @Deprecated
   public GameEventTagsProvider(PackOutput p_256060_, CompletableFuture<HolderLookup.Provider> p_255621_) {
      this(p_256060_, p_255621_, "vanilla", null);
   }
   public GameEventTagsProvider(PackOutput p_256060_, CompletableFuture<HolderLookup.Provider> p_255621_, String modId, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
      super(p_256060_, Registries.GAME_EVENT, p_255621_, (p_256368_) -> {
         return p_256368_.builtInRegistryHolder().key();
      }, modId, existingFileHelper);
   }

   protected void addTags(HolderLookup.Provider p_255981_) {
      this.tag(GameEventTags.VIBRATIONS).add(VIBRATIONS_EXCEPT_FLAP).add(GameEvent.FLAP);
      this.tag(GameEventTags.SHRIEKER_CAN_LISTEN).add(GameEvent.SCULK_SENSOR_TENDRILS_CLICKING);
      this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(VIBRATIONS_EXCEPT_FLAP).add(GameEvent.SHRIEK).addTag(GameEventTags.SHRIEKER_CAN_LISTEN);
      this.tag(GameEventTags.IGNORE_VIBRATIONS_SNEAKING).add(GameEvent.HIT_GROUND, GameEvent.PROJECTILE_SHOOT, GameEvent.STEP, GameEvent.SWIM, GameEvent.ITEM_INTERACT_START, GameEvent.ITEM_INTERACT_FINISH);
      this.tag(GameEventTags.ALLAY_CAN_LISTEN).add(GameEvent.NOTE_BLOCK_PLAY);
   }
}
