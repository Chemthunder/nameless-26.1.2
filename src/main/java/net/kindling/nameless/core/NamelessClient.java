package net.kindling.nameless.core;

import net.fabricmc.api.ClientModInitializer;
import net.kindling.nameless.core.client.item.CoveredModelProperty;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperties;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;

/**
 * @author Chemthunder
 */
public class NamelessClient implements ClientModInitializer {
    public void onInitializeClient() {
        ConditionalItemModelProperties.ID_MAPPER.put(CoveredModelProperty.IDENTIFIER, CoveredModelProperty.CODEC);
    }
}
