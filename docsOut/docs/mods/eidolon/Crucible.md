# Crucible

This class was added by a mod with mod-id `eidolon_tweaker`. So you need to have this mod installed if you want to use this feature.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.eidolon.Crucible;
```


## Static Methods

:::group{name=create}

Return Type: [Crucible](/mods/eidolon/Crucible)

```zenscript
Crucible.create(name as string, result as IItemStack) as Crucible
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| result | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |


:::

:::group{name=remove}

Return Type: void

```zenscript
Crucible.remove(resourceName as string) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| resourceName | string | No Description Provided |


:::

:::group{name=removeAll}

Return Type: void

```zenscript
// Crucible.removeAll() as void

Crucible.removeAll();
```

:::

## Constructors

No Description Provided
```zenscript
new Crucible(name as string, result as IItemStack) as Crucible
```
| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| result | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |



## Methods

:::group{name=addStep}

Return Type: [Crucible](/mods/eidolon/Crucible)

```zenscript
Crucible.addStep(stirs as int) as Crucible
```

| Parameter | Type | Description |
|-----------|------|-------------|
| stirs | int | No Description Provided |


:::

:::group{name=addStep}

Return Type: [Crucible](/mods/eidolon/Crucible)

```zenscript
Crucible.addStep(input as IItemStack[], function as CrucibleRecipeFunction) as Crucible
```

| Parameter | Type | Description |
|-----------|------|-------------|
| input | [IItemStack](/vanilla/api/items/IItemStack)[] | No Description Provided |
| function | [CrucibleRecipeFunction](/mods/eidolon/api/CrucibleRecipeFunction) | No Description Provided |


:::

:::group{name=addStep}

Return Type: [Crucible](/mods/eidolon/Crucible)

```zenscript
Crucible.addStep(stirs as int, input as IItemStack[], function as CrucibleRecipeFunction) as Crucible
```

| Parameter | Type | Description |
|-----------|------|-------------|
| stirs | int | No Description Provided |
| input | [IItemStack](/vanilla/api/items/IItemStack)[] | No Description Provided |
| function | [CrucibleRecipeFunction](/mods/eidolon/api/CrucibleRecipeFunction) | No Description Provided |


:::

:::group{name=register}

Return Type: void

```zenscript
// Crucible.register() as void

myCrucible.register();
```

:::


