package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.recipe.CrucibleRecipe;
import elucent.eidolon.recipe.CrucibleRegistry;
import mrthomas20121.eidolon_tweaker.mixins.AccessorCrucible;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Document("mods/eidolon/Crucible")
@ZenCodeType.Name("mods.eidolon.Crucible")
@ZenRegister
public class CTCrucibleRecipe {
    private static final Map<ResourceLocation, CrucibleRecipe> recipeMap = AccessorCrucible.getRecipes();
    public static final List<CrucibleRecipe> allTheRecipes = new ArrayList<>(recipeMap.values());

    @ZenCodeType.Method
    public static void remove(String resourceName) {
        CraftTweakerAPI.apply(new Remove(resourceName));
    }

    @ZenCodeType.Method
    public static void removeAll() {
        CraftTweakerAPI.apply(new RemoveAll());
    }

    public static class Add implements IUndoableAction {
        CTCrucibleRecipe recipe;

        public Add(CTCrucibleRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void undo() {
            recipeMap.remove(this.recipe.recipe.getRegistryName());
        }

        @Override
        public String describeUndo() {
            return "Unregistering recipe from crucible: " + this.recipe.recipe.getRegistryName();
        }

        @Override
        public void apply() {
            CrucibleRegistry.register(this.recipe.recipe);
        }

        @Override
        public String describe() {
            return "Registering recipe to crucible: " + this.recipe.recipe.getRegistryName();
        }
    }

    public static class Remove implements IUndoableAction {
        CrucibleRecipe recipe;

        public Remove(String recipe) {
            this.recipe = recipeMap.get(new ResourceLocation(recipe));
        }

        @Override
        public void undo() {
            CrucibleRegistry.register(this.recipe);
        }

        @Override
        public String describeUndo() {
            return "Re-adding recipe to crucible: " + this.recipe.getRegistryName();
        }

        @Override
        public void apply() {
            recipeMap.remove(this.recipe.getRegistryName());
        }

        @Override
        public String describe() {
            return "Removing recipe from crucible: " + this.recipe.getRegistryName();
        }
    }

    public static class RemoveAll implements IUndoableAction {
        @Override
        public void undo() {
            allTheRecipes.forEach(CrucibleRegistry::register);
        }

        @Override
        public String describeUndo() {
            return "Removing all recipes from crucible";
        }

        @Override
        public void apply() {
            recipeMap.clear();
        }

        @Override
        public String describe() {
            return "Re-adding all recipes to crucible";
        }
    }

    private final CustomCrucibleRecipe recipe;
    private IItemStack stack;

    @ZenCodeType.Constructor
    public CTCrucibleRecipe(String name, IItemStack result) {
        this.stack = result;
        this.recipe = new CustomCrucibleRecipe(result.getInternal());
        this.recipe.setRegistryName("crafttweaker", name);
    }

    @ZenCodeType.Method
    public static CTCrucibleRecipe create(String name, IItemStack result) {
        return new CTCrucibleRecipe(name, result);
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStep(int stirs) {
        this.recipe.addStep(stirs);
        return this;
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStep(IItemStack[] input, CrucibleRecipeFunction function) {
        return this.addStep(0, input, function);
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStep(int stirs, IItemStack[] input, CrucibleRecipeFunction function) {
        this.stack = function.process(this.stack, input, stirs);
        this.recipe.addCustomStirringStep(stirs, Arrays.stream(input).map(IItemStack::getInternal).toArray());
        return this;
    }

    @ZenCodeType.Method
    public void register() {
        CraftTweakerAPI.apply(new Add(this));
    }

    @FunctionalInterface
    @ZenRegister
    @ZenCodeType.Name("mods.eidolon.api.CrucibleRecipeFunction")
    @Document("mods/eidolon/api/CrucibleRecipeFunction")
    public interface CrucibleRecipeFunction {

        @ZenCodeType.Method
        IItemStack process(IItemStack output, IItemStack[] input, int stirs);
    }

}
