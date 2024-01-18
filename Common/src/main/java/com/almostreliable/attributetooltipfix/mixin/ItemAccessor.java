package com.almostreliable.attributetooltipfix.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.throwables.MixinException;

import java.util.UUID;

@Mixin(Item.class)
public interface ItemAccessor {

    @Accessor("BASE_ATTACK_DAMAGE_UUID")
    static UUID getBaseAttackDamageUUID() {
        throw new MixinException("Mixin was not applied correctly. Please report this issue.");
    }

    @Accessor("BASE_ATTACK_SPEED_UUID")
    static UUID getBaseAttackSpeedUUID() {
        throw new MixinException("Mixin was not applied correctly. Please report this issue.");
    }
}
