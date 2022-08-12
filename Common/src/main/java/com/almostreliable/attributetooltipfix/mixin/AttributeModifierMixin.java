package com.almostreliable.attributetooltipfix.mixin;

import com.almostreliable.attributetooltipfix.UUIDSwap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.UUID;

@Mixin(AttributeModifier.class)
public class AttributeModifierMixin {

    @ModifyVariable(method = "load", at = @At("STORE"), ordinal = 0)
    private static UUID load(UUID uuid) {
        return UUIDSwap.swapOrSelf(uuid);
    }
}
