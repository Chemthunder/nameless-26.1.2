package net.kindling.nameless.core;

import net.fabricmc.api.ModInitializer;

import net.kindling.nameless.core.index.ModDataComponentTypes;
import net.kindling.nameless.core.index.ModEntityTypes;
import net.kindling.nameless.core.index.ModItems;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nameless implements ModInitializer {
	public static final String MOD_ID = "nameless";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        ModItems.init();
        ModDataComponentTypes.init();
        ModEntityTypes.init();

		LOGGER.info("Nameless Initialized");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
