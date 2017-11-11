package com.gumi229.code.loader;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlocksLoader {
	public static void loadBlock(Block block, String registryName, String unlocalizedName) {
		ForgeRegistries.BLOCKS.register(block.setRegistryName(registryName).setUnlocalizedName(unlocalizedName));
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(registryName));
	}
	
	public static void loadBlockRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, 
	            new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}

