package net.smazeee.infiniteores.miners;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.infiniteores.InfiniteOres;
import net.smazeee.infiniteores.miners.hand.HandDrillBlockEntity;
import net.smazeee.infiniteores.registry.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, InfiniteOres.MODID);

    public static final RegistryObject<BlockEntityType<HandDrillBlockEntity>> HAND_DRILL_BE = BLOCK_ENTITIES.register("hand_drill_block_entity", () -> BlockEntityType.Builder.of(HandDrillBlockEntity::new, ModBlocks.HAND_DRILL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
