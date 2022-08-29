package mrthomas20121.eidolon_tweaker.mixins;

import elucent.eidolon.recipe.CrucibleRecipe;
import elucent.eidolon.recipe.CrucibleRegistry;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(CrucibleRegistry.class)
public interface AccessorCrucible {
    @Accessor("recipes")
    static Map<ResourceLocation, CrucibleRecipe> getRecipes() {
        throw new AssertionError();
    }
}
