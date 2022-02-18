import mods.eidolon.Crucible;
import mods.eidolon.Worktable;
import mods.eidolon.api.CrucibleRecipeFunction;
import crafttweaker.api.item.IItemStack;

Crucible.create("test", <item:minecraft:dirt>)
.addStep([<item:minecraft:potion>], (output as IItemStack, input as IItemStack[], stirs as int) => {
    if <item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}).matches(input[0]){
      return output.setDisplayName("nbt works!");
    }
    return output.setDisplayName("Super Dirt 9000!");
})
.register();


Worktable.register("test_recipe", [<item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}), <item:minecraft:dirt>, <item:minecraft:dirt>, <item:minecraft:dirt>, <item:minecraft:dirt>], [], <item:minecraft:granite>, (usualOut as IItemStack, core as IItemStack[], extra as IItemStack[]) => { 
	if <item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}).matches(core[0]){
      return usualOut.setDisplayName("nbt works!");
    }
    return usualOut.setDisplayName("Super Dirt 9000!");
 });