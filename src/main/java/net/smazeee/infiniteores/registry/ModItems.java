package net.smazeee.infiniteores.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.smazeee.infiniteores.InfiniteOres;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfiniteOres.MODID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
