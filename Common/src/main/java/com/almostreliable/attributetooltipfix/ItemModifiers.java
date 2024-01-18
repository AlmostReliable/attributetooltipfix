package com.almostreliable.attributetooltipfix;

import com.almostreliable.attributetooltipfix.mixin.ItemAccessor;

import java.util.UUID;

public class ItemModifiers {

    public static UUID damage() {
        return ItemAccessor.getBaseAttackDamageUUID();
    }

    public static UUID speed() {
        return ItemAccessor.getBaseAttackSpeedUUID();
    }
}
