package mrthomas20121.eidolon_tweaker.mixins;

import elucent.eidolon.recipe.WorktableRecipe;
import elucent.eidolon.recipe.WorktableRegistry;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(WorktableRegistry.class)
public interface AccessorWorktable {
    @Accessor("recipes")
    static Map<ResourceLocation, WorktableRecipe> getRecipes() {
        throw new AssertionError();
    }
}
