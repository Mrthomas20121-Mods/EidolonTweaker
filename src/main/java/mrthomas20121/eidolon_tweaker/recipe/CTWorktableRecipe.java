package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.recipe.WorktableRecipe;
import elucent.eidolon.recipe.WorktableRegistry;
import mrthomas20121.eidolon_tweaker.mixins.AccessorWorktable;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Document("mods/eidolon/Worktable")
@ZenCodeType.Name("mods.eidolon.Worktable")
@ZenRegister
public class CTWorktableRecipe {
    private static final Map<ResourceLocation, WorktableRecipe> recipeMap = AccessorWorktable.getRecipes();

    private static final List<WorktableRecipe> allRecipes = new ArrayList<>(recipeMap.values());

    @ZenCodeType.Method
    public static void register(String name, IItemStack[] core, IItemStack[] extra, IItemStack result, CTWorktableRecipe.WorktableRecipeFunction matrix) {
        CraftTweakerAPI.apply(new Add(name, core, extra, result, matrix));
    }

    @ZenCodeType.Method
    public static void remove(String name) {
        CraftTweakerAPI.apply(new Remove(name));
    }

    @ZenCodeType.Method
    public static void removeAll() {
        CraftTweakerAPI.apply(new RemoveAll());
    }

    public static class Add implements IUndoableAction {
        WorktableRecipe recipe;

        public Add(String name, IItemStack[] core, IItemStack[] extra, IItemStack result, CTWorktableRecipe.WorktableRecipeFunction matrix) {
            Object[] coreItems = Arrays.stream(core).map(IItemStack::getInternal).toArray();
            Object[] extraItems = Arrays.stream(extra).map(IItemStack::getInternal).toArray();

            WorktableRecipe recipe;
            if(matrix != null) {
                IItemStack output = matrix.process(result, core, extra);
                recipe = new WorktableRecipe(coreItems, extraItems, output.getInternal());
            }
            else {
                recipe = new WorktableRecipe(coreItems, extraItems, result.getInternal());
            }
            recipe.setRegistryName("crafttweaker", name);

            this.recipe = recipe;
        }

        @Override
        public void undo() {
            recipeMap.remove(this.recipe.getRegistryName());
        }

        @Override
        public String describeUndo() {
            return "Unregistering recipe from worktable: " + this.recipe.getRegistryName();
        }

        @Override
        public void apply() {
            WorktableRegistry.register(this.recipe);
        }

        @Override
        public String describe() {
            return "Registering recipe to worktable: " + this.recipe.getRegistryName();
        }
    }

    public static class Remove implements IUndoableAction {
        WorktableRecipe recipe;

        public Remove(String resourceName) {
            this.recipe = recipeMap.get(new ResourceLocation(resourceName));
        }

        @Override
        public void undo() {
            WorktableRegistry.register(this.recipe);
        }

        @Override
        public String describeUndo() {
            return "Re-adding recipe to Worktable: " + this.recipe.getRegistryName();
        }

        @Override
        public void apply() {
            recipeMap.remove(this.recipe.getRegistryName());
        }

        @Override
        public String describe() {
            return "Removing recipe from worktable: " + this.recipe.getRegistryName();
        }
    }

    public static class RemoveAll implements IUndoableAction {

        @Override
        public void undo() {
            allRecipes.forEach(WorktableRegistry::register);
        }

        @Override
        public String describeUndo() {
            return "Re-adding all recipes to worktable";
        }

        @Override
        public void apply() {
            recipeMap.clear();
        }

        @Override
        public String describe() {
            return "Removing all recipes from worktable";
        }
    }

    @FunctionalInterface
    @ZenRegister
    @ZenCodeType.Name("mods.eidolon.api.WorktableRecipeFunction")
    @Document("mods/eidolon/api/WorktableRecipeFunction")
    public interface WorktableRecipeFunction {

        @ZenCodeType.Method
        IItemStack process(IItemStack usualOut, IItemStack[] core, IItemStack[] extra);
    }
}
