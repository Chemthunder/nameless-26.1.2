package net.kindling.nameless.core.client.item;

import com.mojang.serialization.MapCodec;
import net.kindling.nameless.core.Nameless;
import net.kindling.nameless.core.index.ModDataComponentTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

/**
 * @author Chemthunder
 */
public record CoveredModelProperty() implements ConditionalItemModelProperty {
    public static final Identifier IDENTIFIER = Nameless.id("covered");
    public static final MapCodec<CoveredModelProperty> CODEC = MapCodec.unit(CoveredModelProperty::new);

    public MapCodec<? extends ConditionalItemModelProperty> type() {
        return CODEC;
    }

    public boolean get(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity owner, int seed, ItemDisplayContext displayContext) {
        return itemStack.getOrDefault(ModDataComponentTypes.COVERED, false);
    }
}
