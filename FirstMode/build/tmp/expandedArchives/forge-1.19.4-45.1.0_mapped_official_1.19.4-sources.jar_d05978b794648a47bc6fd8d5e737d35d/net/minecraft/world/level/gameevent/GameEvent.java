package net.minecraft.world.level.gameevent;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class GameEvent {
   public static final GameEvent BLOCK_ACTIVATE = register("block_activate");
   public static final GameEvent BLOCK_ATTACH = register("block_attach");
   public static final GameEvent BLOCK_CHANGE = register("block_change");
   public static final GameEvent BLOCK_CLOSE = register("block_close");
   public static final GameEvent BLOCK_DEACTIVATE = register("block_deactivate");
   public static final GameEvent BLOCK_DESTROY = register("block_destroy");
   public static final GameEvent BLOCK_DETACH = register("block_detach");
   public static final GameEvent BLOCK_OPEN = register("block_open");
   public static final GameEvent BLOCK_PLACE = register("block_place");
   public static final GameEvent CONTAINER_CLOSE = register("container_close");
   public static final GameEvent CONTAINER_OPEN = register("container_open");
   public static final GameEvent DISPENSE_FAIL = register("dispense_fail");
   public static final GameEvent DRINK = register("drink");
   public static final GameEvent EAT = register("eat");
   public static final GameEvent ELYTRA_GLIDE = register("elytra_glide");
   public static final GameEvent ENTITY_DAMAGE = register("entity_damage");
   public static final GameEvent ENTITY_DIE = register("entity_die");
   public static final GameEvent ENTITY_DISMOUNT = register("entity_dismount");
   public static final GameEvent ENTITY_INTERACT = register("entity_interact");
   public static final GameEvent ENTITY_MOUNT = register("entity_mount");
   public static final GameEvent ENTITY_PLACE = register("entity_place");
   public static final GameEvent ENTITY_ROAR = register("entity_roar");
   public static final GameEvent ENTITY_SHAKE = register("entity_shake");
   public static final GameEvent EQUIP = register("equip");
   public static final GameEvent EXPLODE = register("explode");
   public static final GameEvent FLAP = register("flap");
   public static final GameEvent FLUID_PICKUP = register("fluid_pickup");
   public static final GameEvent FLUID_PLACE = register("fluid_place");
   public static final GameEvent HIT_GROUND = register("hit_ground");
   public static final GameEvent INSTRUMENT_PLAY = register("instrument_play");
   public static final GameEvent ITEM_INTERACT_FINISH = register("item_interact_finish");
   public static final GameEvent ITEM_INTERACT_START = register("item_interact_start");
   public static final GameEvent JUKEBOX_PLAY = register("jukebox_play", 10);
   public static final GameEvent JUKEBOX_STOP_PLAY = register("jukebox_stop_play", 10);
   public static final GameEvent LIGHTNING_STRIKE = register("lightning_strike");
   public static final GameEvent NOTE_BLOCK_PLAY = register("note_block_play");
   public static final GameEvent PISTON_CONTRACT = register("piston_contract");
   public static final GameEvent PISTON_EXTEND = register("piston_extend");
   public static final GameEvent PRIME_FUSE = register("prime_fuse");
   public static final GameEvent PROJECTILE_LAND = register("projectile_land");
   public static final GameEvent PROJECTILE_SHOOT = register("projectile_shoot");
   public static final GameEvent SCULK_SENSOR_TENDRILS_CLICKING = register("sculk_sensor_tendrils_clicking");
   public static final GameEvent SHEAR = register("shear");
   public static final GameEvent SHRIEK = register("shriek", 32);
   public static final GameEvent SPLASH = register("splash");
   public static final GameEvent STEP = register("step");
   public static final GameEvent SWIM = register("swim");
   public static final GameEvent TELEPORT = register("teleport");
   public static final int DEFAULT_NOTIFICATION_RADIUS = 16;
   private final String name;
   private final int notificationRadius;
   private final Holder.Reference<GameEvent> builtInRegistryHolder = BuiltInRegistries.GAME_EVENT.createIntrusiveHolder(this);

   public GameEvent(String p_157819_, int p_157820_) {
      this.name = p_157819_;
      this.notificationRadius = p_157820_;
   }

   public String getName() {
      return this.name;
   }

   public int getNotificationRadius() {
      return this.notificationRadius;
   }

   private static GameEvent register(String p_157823_) {
      return register(p_157823_, 16);
   }

   private static GameEvent register(String p_157825_, int p_157826_) {
      return Registry.register(BuiltInRegistries.GAME_EVENT, p_157825_, new GameEvent(p_157825_, p_157826_));
   }

   public String toString() {
      return "Game Event{ " + this.name + " , " + this.notificationRadius + "}";
   }

   /** @deprecated */
   @Deprecated
   public Holder.Reference<GameEvent> builtInRegistryHolder() {
      return this.builtInRegistryHolder;
   }

   public boolean is(TagKey<GameEvent> p_204529_) {
      return this.builtInRegistryHolder.is(p_204529_);
   }

   public static record Context(@Nullable Entity sourceEntity, @Nullable BlockState affectedState) {
      public static GameEvent.Context of(@Nullable Entity p_223718_) {
         return new GameEvent.Context(p_223718_, (BlockState)null);
      }

      public static GameEvent.Context of(@Nullable BlockState p_223723_) {
         return new GameEvent.Context((Entity)null, p_223723_);
      }

      public static GameEvent.Context of(@Nullable Entity p_223720_, @Nullable BlockState p_223721_) {
         return new GameEvent.Context(p_223720_, p_223721_);
      }
   }

   public static final class ListenerInfo implements Comparable<GameEvent.ListenerInfo> {
      private final GameEvent gameEvent;
      private final Vec3 source;
      private final GameEvent.Context context;
      private final GameEventListener recipient;
      private final double distanceToRecipient;

      public ListenerInfo(GameEvent p_251490_, Vec3 p_249118_, GameEvent.Context p_251196_, GameEventListener p_251701_, Vec3 p_248854_) {
         this.gameEvent = p_251490_;
         this.source = p_249118_;
         this.context = p_251196_;
         this.recipient = p_251701_;
         this.distanceToRecipient = p_249118_.distanceToSqr(p_248854_);
      }

      public int compareTo(GameEvent.ListenerInfo p_249631_) {
         return Double.compare(this.distanceToRecipient, p_249631_.distanceToRecipient);
      }

      public GameEvent gameEvent() {
         return this.gameEvent;
      }

      public Vec3 source() {
         return this.source;
      }

      public GameEvent.Context context() {
         return this.context;
      }

      public GameEventListener recipient() {
         return this.recipient;
      }
   }
}