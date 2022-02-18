package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.recipe.WorktableRecipe;
import elucent.eidolon.recipe.WorktableRegistry;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@Document("mods/eidolon/Worktable")
@ZenCodeType.Name("mods.eidolon.Worktable")
@ZenRegister
public class CTWorktableRecipe {

    @ZenCodeType.Method
    public static void register(String name, IItemStack[] core, IItemStack[] extra, IItemStack result, CTWorktableRecipe.WorktableRecipeFunction matrix) {

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
        WorktableRegistry.register(recipe);
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
