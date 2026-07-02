package net.kindling.nameless.core.index;

import com.mojang.serialization.Codec;
import net.acoyt.acornlib.api.registrants.DataComponentTypeRegistrant;
import net.kindling.nameless.core.Nameless;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

/**
 * @author Chemthunder
 */
public interface ModDataComponentTypes {
    DataComponentTypeRegistrant rant = new DataComponentTypeRegistrant(Nameless.MOD_ID);

    DataComponentType<Boolean> COVERED = rant.register("covered", Codec.BOOL, ByteBufCodecs.BOOL);

    static void init() {}
}
