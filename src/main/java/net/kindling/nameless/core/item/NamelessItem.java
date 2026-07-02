package net.kindling.nameless.core.item;

import net.kindling.nameless.core.index.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

/**
 * @author Chemthunder
 */
@SuppressWarnings("deprecation")
public class NamelessItem extends Item {
    public static final String[] NAMES = new String[]{
            "Nameless",

            // REFERENCES
            "Black Knife",
            "Twisted Epitaph",
            "Rho's Cleaver",

            // ML WEAPONS
            "Exaltis",
            "Hyacinth",
            "Luminark",
            "Aegis",
            "Vulgar",
            "Sundown Silence",
            "Contractor's Beseech",
            "ANARCHY",

            // FIREARMS
            "Concealed Carry",
            "Gun",
            "Carbine",

            // OTHER
            "Gibo",
            "gElb",

            // NORMAL
            "Execution Cleaver",
            "Blood Root Massacre",
            "Midnight's Epistle"
    };

    private int listIterator = 0;

    public NamelessItem(Properties properties) {
        super(properties);
    }

    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if (level.getGameTime() % 16 == 0) {
            listIterator = level.getRandom().nextInt(NAMES.length);
        }
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        stack.set(ModDataComponentTypes.COVERED, !stack.getOrDefault(ModDataComponentTypes.COVERED, false));
        return super.use(level, player, hand);
    }

    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.literal(itemStack.getOrDefault(ModDataComponentTypes.COVERED, false).toString()));
    }

    public Component getName(ItemStack itemStack) {
        return itemStack.getOrDefault(ModDataComponentTypes.COVERED, false)
                ? Component.literal("Covered Blade").withColor(0xFF5e1224)
                : Component.literal(NAMES[listIterator % NAMES.length]).withColor(0xFF5e1224);
    }
}
