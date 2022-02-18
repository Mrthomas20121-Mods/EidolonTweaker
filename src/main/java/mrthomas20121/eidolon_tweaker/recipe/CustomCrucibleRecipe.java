package mrthomas20121.eidolon_tweaker.recipe;

import elucent.eidolon.recipe.CrucibleRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

// custom recipe class to work with crafttweaker
public class CustomCrucibleRecipe extends CrucibleRecipe {

    protected ItemStack output;

    public CustomCrucibleRecipe(ItemStack output) {
        super(output);
        this.output = output;
    }

    public void addCustomStep(Object[] matches) {
        this.getSteps().add(new Step(0, Arrays.asList(matches)));
    }

    public void addCustomStirringStep(int stirs, Object[] matches) {
        this.getSteps().add(new Step(stirs, Arrays.asList(matches)));
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    @Override
    public ItemStack getResult() {
        return output;
    }
}
