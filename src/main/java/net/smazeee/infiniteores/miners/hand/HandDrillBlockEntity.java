package net.smazeee.infiniteores.miners.hand;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.smazeee.infiniteores.InfiniteOres;
import net.smazeee.infiniteores.miners.ModBlockEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.Objects;

public class HandDrillBlockEntity extends BlockEntity implements GeoBlockEntity {
    public static boolean isMining = false;
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public HandDrillBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HAND_DRILL_BE.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        if (isMining) {
            controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        }
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("dig", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }

    /*SYNCING*/

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        var prehistoricCraftData = new CompoundTag();
        prehistoricCraftData.putBoolean("mining", isMining);
        nbt.put(InfiniteOres.MODID, prehistoricCraftData);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag nbt) {
        CompoundTag prehistoricCraftData = nbt.getCompound(InfiniteOres.MODID);
        isMining = prehistoricCraftData.getBoolean("mining");
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        handleUpdateTag(Objects.requireNonNull(pkt.getTag()));
    }
}
