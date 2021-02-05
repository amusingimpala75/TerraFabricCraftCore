package com.github.amusingimpala75.terrafabriccraftcore.client;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.block.DebugBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.registry.Registry;

public class TerraFabricCraftCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            BlockEntityRendererRegistry.INSTANCE.register(getDebugBlockEntity(), DebugBlockEntityRenderer::new);
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register(
                    (a,b) ->
                            DebugBlockEntity.getModels().forEach(
                                    p ->
                                            b.register(TerraFabricCraftCore.getId(p.getRight()))
                            )
            );
        }
    }

    @SuppressWarnings("unchecked")
    private BlockEntityType<DebugBlockEntity> getDebugBlockEntity() {
        return (BlockEntityType<DebugBlockEntity>) Registry.BLOCK_ENTITY_TYPE.get(TerraFabricCraftCore.getId("debug_block_entity"));
    }
}
