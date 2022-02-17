package mrthomas20121.eidolon_tweaker.recipe;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import elucent.eidolon.recipe.WorktableRecipe;
import elucent.eidolon.recipe.WorktableRegistry;
import net.minecraft.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@Document("Mods/Eidolon/WorktableRecipe")
@ZenCodeType.Name("mods.eidolon.WorktableRecipe")
@ZenRegister
public class CTWorktableRecipe {

    @ZenCodeType.Method
    public static void register(String name, IItemStack[] core, IItemStack[] extra, IItemStack result) {

        ItemStack[] coreItems = Arrays.stream(core).map(IItemStack::getInternal).collect(Collectors.toList()).toArray(new ItemStack[] {});
        ItemStack[] extraItems = Arrays.stream(extra).map(IItemStack::getInternal).collect(Collectors.toList()).toArray(new ItemStack[] {});

        WorktableRecipe recipe = new WorktableRecipe(coreItems, extraItems, result.getInternal());
        recipe.setRegistryName("crafttweaker", name);
        WorktableRegistry.register(recipe);
    }
}
