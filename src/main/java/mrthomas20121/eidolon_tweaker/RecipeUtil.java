package mrthomas20121.eidolon_tweaker;

import elucent.eidolon.recipe.CrucibleRecipe;
import elucent.eidolon.recipe.CrucibleRegistry;
import elucent.eidolon.recipe.WorktableRecipe;
import elucent.eidolon.recipe.WorktableRegistry;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Field;
import java.util.Map;

public class RecipeUtil {
    public static Map<ResourceLocation, CrucibleRecipe> getCrucibleRecipes() {
        Map<ResourceLocation, CrucibleRecipe> recipeMap = null;

        try {
            Field recipeMapField = CrucibleRegistry.class.getDeclaredField("recipes");

            recipeMapField.setAccessible(true);
            recipeMap = (Map<ResourceLocation, CrucibleRecipe>) recipeMapField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return recipeMap;
    }

    public static Map<ResourceLocation, WorktableRecipe> getWorktableRecipes() {
        Map<ResourceLocation, WorktableRecipe> recipeMap = null;

        try {
            Field recipeMapField = WorktableRegistry.class.getDeclaredField("recipes");

            recipeMapField.setAccessible(true);
            recipeMap = (Map<ResourceLocation, WorktableRecipe>) recipeMapField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return recipeMap;
    }
}
