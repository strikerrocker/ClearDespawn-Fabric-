package io.github.strikerrocker.cleardespawn;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.world.entity.EntityType;

public class ClearDespawn implements ClientModInitializer {

    public static ModConfig config;

    static {
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityType.ITEM, new RenderItemEntityExtended.Factory());
    }
}