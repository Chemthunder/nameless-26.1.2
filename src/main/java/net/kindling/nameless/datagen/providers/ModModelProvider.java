package net.kindling.nameless.datagen.providers;

import net.acoyt.acornlib.api.util.DataUtils;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.kindling.nameless.core.client.item.CoveredModelProperty;
import net.kindling.nameless.core.index.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;

import java.util.Arrays;

/**
 * @author Chemthunder
 */
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {}

    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        createNameless(itemModelGenerators);
    }

    private static void createNameless(ItemModelGenerators generator) {
        Item item = ModItems.NAMELESS;
        Identifier baseId = ModelLocationUtils.getModelLocation(item);

        generator.createFlatItemModel(item, ModelTemplates.FLAT_ITEM);
        generator.createFlatItemModel(item, "_covered", ModelTemplates.FLAT_ITEM);

        generator.itemModelOutput.accept(item,
                ItemModelUtils.conditional(
                        new CoveredModelProperty(),
                        ItemModelUtils.select(
                                new DisplayContext(),
                                ItemModelUtils.plainModel(baseId.withPath(st -> st + "_covered_in_hand")),
                                ItemModelUtils.when(
                                        Arrays.asList(
                                                ItemDisplayContext.GUI,
                                                ItemDisplayContext.GROUND,
                                                ItemDisplayContext.FIXED,
                                                ItemDisplayContext.ON_SHELF
                                        ),
                                        ItemModelUtils.plainModel(baseId.withPath(st -> st + "_covered"))
                                )
                        ),
                        ItemModelUtils.select(
                                new DisplayContext(),
                                ItemModelUtils.plainModel(baseId.withPath(st -> st + "_in_hand")),
                                ItemModelUtils.when(
                                        Arrays.asList(
                                                ItemDisplayContext.GUI,
                                                ItemDisplayContext.GROUND,
                                                ItemDisplayContext.FIXED,
                                                ItemDisplayContext.ON_SHELF
                                        ),
                                        ItemModelUtils.plainModel(baseId.withPath(st -> st))
                                )
                        )
                )
        );
    }
}
