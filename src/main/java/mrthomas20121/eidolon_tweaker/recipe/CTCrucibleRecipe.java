package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.Eidolon;
import elucent.eidolon.recipe.CrucibleRecipe;
import elucent.eidolon.recipe.CrucibleRegistry;
import net.minecraft.item.crafting.Ingredient;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Document("Mods/Eidolon/CrucibleRecipe")
@ZenCodeType.Name("mods.eidolon.CrucibleRecipe")
@ZenRegister
public class CTCrucibleRecipe {

    private final CustomCrucibleRecipe recipe;

    @ZenCodeType.Constructor
    public CTCrucibleRecipe(String name, IItemStack output) {
        this.recipe = new CustomCrucibleRecipe(output.getInternal());
        this.recipe.setRegistryName("crafttweaker", name);
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStep(int stirs) {
        this.recipe.addStep(stirs);
        return this;
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStep(IItemStack... ct_ingredient) {
        return this.addStirringStep(0, ct_ingredient);
    }

    @ZenCodeType.Method
    public CTCrucibleRecipe addStirringStep(int stirs, IItemStack... ct_ingredient) {
        this.recipe.addCustomStirringStep(stirs, Arrays.stream(ct_ingredient).map(IItemStack::getInternal).toArray());
        return this;
    }

    @ZenCodeType.Method
    public void register() {
        CrucibleRegistry.register(this.recipe);
    }

}
