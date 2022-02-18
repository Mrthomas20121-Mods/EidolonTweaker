package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.recipe.CrucibleRegistry;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@Document("mods/eidolon/Crucible")
@ZenCodeType.Name("mods.eidolon.Crucible")
@ZenRegister
public class CTCrucibleRecipe {

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
        return this.addStirringStep(0, input, function);
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStirringStep(int stirs, IItemStack[] input, CrucibleRecipeFunction function) {
        this.stack = function.process(this.stack, input, stirs);
        this.recipe.addCustomStirringStep(stirs, Arrays.stream(input).map(IItemStack::getInternal).toArray());
        return this;
    }

    @ZenCodeType.Method
    public void register() {
        this.recipe.setOutput(this.stack.getInternal());
        CrucibleRegistry.register(this.recipe);
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
