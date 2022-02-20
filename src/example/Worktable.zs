import mods.eidolon.Worktable;
import crafttweaker.api.item.IItemStack;

Worktable.register("test_recipe", [<item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}), <item:minecraft:dirt>, <item:minecraft:dirt>, <item:minecraft:dirt>, <item:minecraft:dirt>], [], <item:minecraft:granite>, (usualOut as IItemStack, core as IItemStack[], extra as IItemStack[]) => {
	if <item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}).matches(core[0]){
      return usualOut.setDisplayName("nbt works!");
    }
    return usualOut.setDisplayName("Super Dirt 9000!");
 });

 // removing recipes
 // Worktable.remove("eidolon:recipe_name");
 // worktable.removeAll();