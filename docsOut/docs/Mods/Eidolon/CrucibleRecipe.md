# CrucibleRecipe

This class was added by a mod with mod-id `eidolon_tweaker`. So you need to have this mod installed if you want to use this feature.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.eidolon.CrucibleRecipe;
```


## Constructors

No Description Provided
```zenscript
new CrucibleRecipe(name as string, output as IItemStack) as CrucibleRecipe
```
| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| output | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |



## Methods

:::group{name=addStep}

Return Type: [CrucibleRecipe](/Mods/Eidolon/CrucibleRecipe)

```zenscript
CrucibleRecipe.addStep(ct_ingredient as IItemStack[]) as CrucibleRecipe
```

| Parameter | Type | Description |
|-----------|------|-------------|
| ct_ingredient | [IItemStack](/vanilla/api/items/IItemStack)[] | No Description Provided |


:::

:::group{name=addStep}

Return Type: [CrucibleRecipe](/Mods/Eidolon/CrucibleRecipe)

```zenscript
CrucibleRecipe.addStep(stirs as int) as CrucibleRecipe
```

| Parameter | Type | Description |
|-----------|------|-------------|
| stirs | int | No Description Provided |


:::

:::group{name=addStirringStep}

Return Type: [CrucibleRecipe](/Mods/Eidolon/CrucibleRecipe)

```zenscript
CrucibleRecipe.addStirringStep(stirs as int, ct_ingredient as IItemStack[]) as CrucibleRecipe
```

| Parameter | Type | Description |
|-----------|------|-------------|
| stirs | int | No Description Provided |
| ct_ingredient | [IItemStack](/vanilla/api/items/IItemStack)[] | No Description Provided |


:::

:::group{name=register}

Return Type: void

```zenscript
// CrucibleRecipe.register() as void

myCrucibleRecipe.register();
```

:::


