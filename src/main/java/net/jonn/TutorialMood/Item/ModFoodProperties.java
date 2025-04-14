package net.jonn.TutorialMood.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 400),100)
            .build();
}
