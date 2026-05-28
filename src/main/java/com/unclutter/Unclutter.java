package com.unclutter;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unclutter implements ModInitializer {

	public static final String MOD_ID = "unclutter";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Shared init (server-safe). Nothing needed here yet.
	}
}