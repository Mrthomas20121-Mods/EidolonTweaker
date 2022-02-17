import mods.eidolon.CrucibleRecipe;
import mods.eidolon.WorktableRecipe;

new CrucibleRecipe("test", <item:minecraft:potion>.withTag({Potion: "minecraft:long_slow_falling" as string}))
.addStep(1)
.addStep(<item:minecraft:glass_bottle>)
.addStirringStep(2, <item:minecraft:potion>.withTag({Potion: "minecraft:luck" as string}))
.register();
//WorktableRecipe.register(String registryName, IItemStack[] core, IItemStack[] extra, IItemStack result);