package com.almostreliable.attributetooltipfix;

import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.UUID;

public class UUIDSwap extends Item {
    public UUIDSwap(Properties properties) {
        super(properties);
        throw new IllegalStateException("This class should never be instantiated");
    }

    public static UUID swapOrSelf(@Nullable UUID uuid) {
        if (BASE_ATTACK_DAMAGE_UUID.equals(uuid)) {
            return BASE_ATTACK_DAMAGE_UUID;
        }

        if (BASE_ATTACK_SPEED_UUID.equals(uuid)) {
            return BASE_ATTACK_SPEED_UUID;
        }

        return uuid;
    }
}
