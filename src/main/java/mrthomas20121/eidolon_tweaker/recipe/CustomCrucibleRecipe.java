package mrthomas20121.eidolon_tweaker.recipe;

import elucent.eidolon.recipe.CrucibleRecipe;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

// custom recipe class to work with crafttweaker
public class CustomCrucibleRecipe extends CrucibleRecipe {

    public CustomCrucibleRecipe(ItemStack result) {
        super(result);
    }

    public CrucibleRecipe addCustomStep(Object[] matches) {
        this.getSteps().add(new Step(0, Arrays.asList(matches)));
        return this;
    }

    public CrucibleRecipe addCustomStirringStep(int stirs, Object[] matches) {
        this.getSteps().add(new Step(stirs, Arrays.asList(matches)));
        return this;
    }
}
