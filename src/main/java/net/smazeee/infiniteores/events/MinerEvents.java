package net.smazeee.infiniteores.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.smazeee.infiniteores.InfiniteOres;
import net.smazeee.infiniteores.miners.hand.HandDrill;

import static net.smazeee.infiniteores.miners.hand.HandDrillBlockEntity.isMining;

@Mod.EventBusSubscriber
public class MinerEvents {
    @SubscribeEvent
    public static void playerRightClick(PlayerInteractEvent.RightClickBlock event) {
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof HandDrill) {
            while (player.isShiftKeyDown()) {
                InfiniteOres.LOGGER.info("'isMining' is set to true.");
                isMining = true;
            }
        }
        isMining = false;
        level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
    }
}