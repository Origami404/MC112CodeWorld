package com.gumi229.code.loader;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class HotkeyLoader {
	public static KeyBinding flash = new net.minecraft.client.settings.KeyBinding("key.code_world.flash",
			Keyboard.KEY_F, "key.categories.code_world");

	public static void loadHotkeys() {
		ClientRegistry.registerKeyBinding(flash);
	}

}
