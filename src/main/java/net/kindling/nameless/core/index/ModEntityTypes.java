package net.kindling.nameless.core.index;

import net.acoyt.acornlib.api.registrants.EntityTypeRegistrant;
import net.kindling.nameless.core.Nameless;
import net.kindling.nameless.core.entity.ThrownNamelessEntity;
import net.kindling.nameless.datagen.NamelessDataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * @author Chemthunder
 */
public interface ModEntityTypes {
    EntityTypeRegistrant rant = new EntityTypeRegistrant(Nameless.MOD_ID);

    EntityType<ThrownNamelessEntity> THROWN_NAMELESS = rant.register("thrown_nameless", EntityType.Builder.of(
            ThrownNamelessEntity::new,
            MobCategory.MISC
    ).sized(2.3F, 0.9F));

    static void init() {}
}
