package net.smazeee.infiniteores.miners.hand;

import net.minecraft.resources.ResourceLocation;
import net.smazeee.infiniteores.InfiniteOres;
import software.bernie.geckolib.model.GeoModel;

public class HandDrillBlockItemModel extends GeoModel<HandDrillBlockItem> {
    @Override
    public ResourceLocation getModelResource(HandDrillBlockItem animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "geo/hand_drill.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HandDrillBlockItem animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "textures/block/hand_drill.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HandDrillBlockItem animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "animations/hand_drill.animation.json");
    }
}
