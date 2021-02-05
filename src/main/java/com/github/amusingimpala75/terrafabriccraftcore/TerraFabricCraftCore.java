package com.github.amusingimpala75.terrafabriccraftcore;

import com.github.amusingimpala75.terrafabriccraftcore.block.DebugBlock;
import com.github.amusingimpala75.terrafabriccraftcore.block.DebugBlockEntity;
import com.github.amusingimpala75.terrafabriccraftcore.item.DebugItem;
import com.github.amusingimpala75.terrafabriccraftcore.item.Food;
import com.github.amusingimpala75.terrafabriccraftcore.item.Rottable;
import com.github.amusingimpala75.terrafabriccraftcore.sounds.TerraFabricCraftSounds;
import com.github.amusingimpala75.terrafabriccraftcore.util.FoodUtil;
import com.github.amusingimpala75.terrafabriccraftcore.util.TimeUtil;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

//TODO Migrate block models to json
public class TerraFabricCraftCore implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("TerraFabricCraft - Core");
    public static final String MODID = "terrafabriccraft-core";

    @Override
    public void onInitialize() {
        LOGGER.info("Survival as it should have been");
        AutoConfig.register(TerraFabricCraftCoreConfig.class, GsonConfigSerializer::new);
        TerraFabricCraftSounds.registerSounds();
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            Registry.register(Registry.BLOCK, getId("debug_block"), new DebugBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque()));
            Registry.register(Registry.BLOCK_ENTITY_TYPE, getId("debug_block_entity"), BlockEntityType.Builder.create(DebugBlockEntity::new, Registry.BLOCK.get(getId("debug_block"))).build(null));
            Registry.register(Registry.ITEM, getId("debug_item"), new DebugItem(new FabricItemSettings().group(ItemGroup.MISC)));
        }
        ServerTickEvents.END_WORLD_TICK.register(server -> {
            for (BlockEntity entity : server.blockEntities) {
                if (entity instanceof Inventory) {
                    for (int i = 0; i < ((Inventory) entity).size(); i++) {
                        ItemStack stack = ((Inventory) entity).getStack(i);
                        /*if (stack.getItem() instanceof Rottable) {
                            FoodUtil.incrementDecayTimer(stack);
                            if (FoodUtil.getDecayTimer(stack) == 24) {
                                FoodUtil.setDecayTimer(stack, 0);
                                FoodUtil.setDecay(stack, ((Rottable) stack.getItem()).getDecayRate(stack));
                            }
                        }*/
                        BlockPos pos = entity.getPos();
                        FoodUtil.tickDecay(stack, server, pos.getX(), pos.getY(), pos.getZ(), 1.0F, 1.0F);
                    }
                }
            }
            for (PlayerEntity entity : server.getPlayers()) {
                if (entity instanceof Inventory) {
                    for (int i = 0; i < ((Inventory) entity).size(); i++) {
                        ItemStack stack = ((Inventory) entity).getStack(i);
                        /*if (stack.getItem() instanceof Rottable) {
                            FoodUtil.incrementDecayTimer(stack);
                            if (FoodUtil.getDecayTimer(stack) == 24) {
                                FoodUtil.setDecayTimer(stack, 0);
                                FoodUtil.setDecay(stack, ((Rottable) stack.getItem()).getDecayRate(stack));
                            }
                        }*/
                        BlockPos pos = entity.getBlockPos();
                        FoodUtil.tickDecay(stack, server, pos.getX(), pos.getY(), pos.getZ(), 1.0F, 1.0F);
                    }
                }
            }
            TimeUtil.updateTime(server);
        });
    }

    public static Identifier getId(String name) {
        return new Identifier(MODID, name);
    }

    public static TerraFabricCraftCoreConfig getConfig() {
        return AutoConfig.getConfigHolder(TerraFabricCraftCoreConfig.class).getConfig();
    }

    public static class Constants {
        public static final int SEALEVEL = 144;
    }
}
