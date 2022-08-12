package com.almostreliable.attributetooltipfix.mixin;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @ModifyVariable(method = "getAttributeModifiers", at = @At("STORE"), ordinal = 0)
    private Multimap<Attribute, AttributeModifier> load(Multimap<Attribute, AttributeModifier> attributes) {
        LinkedHashMultimap<Attribute, AttributeModifier> result = LinkedHashMultimap.create();
        result.putAll(attributes);
        return result;
    }
}
