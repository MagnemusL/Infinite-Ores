package net.smazeee.infiniteores.miners.hand;

import net.minecraft.resources.ResourceLocation;
import net.smazeee.infiniteores.InfiniteOres;
import software.bernie.geckolib.model.GeoModel;

public class HandDrillModel extends GeoModel<HandDrillBlockEntity> {
    @Override
    public ResourceLocation getModelResource(HandDrillBlockEntity animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "geo/hand_drill.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HandDrillBlockEntity animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "textures/block/hand_drill.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HandDrillBlockEntity animatable) {
        return new ResourceLocation(InfiniteOres.MODID, "animations/hand_drill.animation.json");
    }
}