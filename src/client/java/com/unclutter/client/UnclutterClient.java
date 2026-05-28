package com.unclutter.client;

import com.mojang.blaze3d.platform.InputConstants;
import com.unclutter.Unclutter;
import com.unclutter.network.ShapeChangePayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;


public class UnclutterClient implements ClientModInitializer {

	KeyMapping.Category CATEGORY = KeyMapping.Category.register(
		Identifier.fromNamespaceAndPath(Unclutter.MOD_ID, "unclutter")
	);

	KeyMapping itemCycle = KeyMappingHelper.registerKeyMapping(
			new KeyMapping(
					"key.unclutter.item_cycle",
					InputConstants.Type.KEYSYM,
					GLFW.GLFW_KEY_LEFT_ALT,
					KeyMapping.Category.INVENTORY
			));



	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (this.itemCycle.consumeClick()) {
				if (client.player != null) {
					client.player.sendSystemMessage(Component.literal("Key Pressed!"));
					ClientPlayNetworking.send(new ShapeChangePayload());
				}
			}
		});
	}
}