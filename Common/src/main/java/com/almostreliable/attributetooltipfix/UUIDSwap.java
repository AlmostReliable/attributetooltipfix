package com.almostreliable.attributetooltipfix;

import javax.annotation.Nullable;
import java.util.UUID;

public class UUIDSwap {

    public static UUID swapOrSelf(@Nullable UUID uuid) {
        if (ItemModifiers.damage().equals(uuid)) {
            return ItemModifiers.damage();
        }

        if (ItemModifiers.speed().equals(uuid)) {
            return ItemModifiers.speed();
        }

        return uuid;
    }
}
