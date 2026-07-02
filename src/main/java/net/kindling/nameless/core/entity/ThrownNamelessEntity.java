package net.kindling.nameless.core.entity;

import net.kindling.nameless.core.index.ModItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * @author Chemthunder
 */
public class ThrownNamelessEntity extends AbstractArrow {
    public static final EntityDataAccessor<ItemStack> ITEM = SynchedEntityData.defineId(ThrownNamelessEntity.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Boolean> RETURNING = SynchedEntityData.defineId(ThrownNamelessEntity.class, EntityDataSerializers.BOOLEAN);

    public ThrownNamelessEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.NAMELESS);
    }

    public void tick() {
        super.tick();
    }
}
