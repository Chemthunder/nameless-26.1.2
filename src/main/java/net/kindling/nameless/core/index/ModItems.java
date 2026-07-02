package net.kindling.nameless.core.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.kindling.nameless.core.Nameless;
import net.kindling.nameless.core.item.NamelessItem;
import net.minecraft.world.item.Item;

/**
 * @author Chemthunder
 */
public interface ModItems {
    ItemRegistrant rant = new ItemRegistrant(Nameless.MOD_ID);

    Item NAMELESS = rant.register("nameless", NamelessItem::new, new Item.Properties()
            .stacksTo(1)
            .component(ModDataComponentTypes.COVERED, false)
    );

    static void init() {}
}
