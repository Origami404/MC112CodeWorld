package com.gumi229.code.loader;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemsLoader {
	public static void loadItem(Item item, String registryName, String unlocalizedName) {
		ForgeRegistries.ITEMS.register(item.setRegistryName(registryName).setUnlocalizedName(unlocalizedName));
	}
	public static void loadItemRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, 
	            new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
