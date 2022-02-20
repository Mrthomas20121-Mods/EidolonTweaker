import mods.eidolon.Crucible;
import crafttweaker.api.item.IItemStack;

 Crucible.create("test", <item:minecraft:podzol>)
 .addStep([<item:minecraft:grass_block>], (output as IItemStack, input as IItemStack[], stirs as int) => {
     return output.setDisplayName("Super Dirt 9000!");
 })
 .addStirringStep(5, [<item:minecraft:coarse_dirt>], (output as IItemStack, input as IItemStack[], stirs as int) => {
     return output;
 })
 .addStep(5)
 .register();
// removing recipes
// Crucible.remove("eidolon:recipe_name");
// Crucible.removeAll();