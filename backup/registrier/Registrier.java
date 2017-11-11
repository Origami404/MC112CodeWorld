package com.gumi229.code.registrier;

import java.util.Iterator;

import javax.annotation.Nullable;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.object.entity.EntityJavaShoujo;
import com.gumi229.code.until.Global;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class Registrier {
	public static void EntitiesNames() {
		EntitiesNames.registerEntity(EntityJavaShoujo.class, "JavaShoujo", 64, 3, true);
		EntitiesNames.registerEntityEgg("JavaShoujo", 0xFFA3DC, 0xFF0000);
	}
	
	@SideOnly(Side.CLIENT)
	public static void EntitiesRenders() {
		
	}
	public static void ItemsNames() {
		Iterator<ObjInfo<Item>> iterator = ObjectsLists.Items.InfoList.iterator();
		while (iterator.hasNext()) {
			ObjInfo<Item> obj = iterator.next();
			ForgeRegistries.ITEMS.register(obj.instance.setRegistryName(obj.registriyName).setUnlocalizedName(obj.unlocalizedName));
			Global.logger.info("RN:{}, UN:{}", obj.registriyName, obj.unlocalizedName);
		}
		
		Global.logger.info("Register items over!");
	}
	
	@SideOnly(Side.CLIENT)
	public static void ItemsRenders() {
		Iterator<ObjInfo<Item>> iterator = ObjectsLists.Items.InfoList.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next().instance;
			ModelLoader.setCustomModelResourceLocation(item, 0, 
		            new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
		
		Global.logger.info("Register items' renders over!");
	}
	
	public static void BlocksNames() {
		Iterator<ObjInfo<Block>> iterator = ObjectsLists.Blocks.InfoList.iterator();
		while (iterator.hasNext()) {
			ObjInfo<Block> obj = iterator.next();
			ForgeRegistries.BLOCKS.register(obj.instance.setRegistryName(obj.registriyName).setUnlocalizedName(obj.unlocalizedName));
			ForgeRegistries.ITEMS.register(new ItemBlock(obj.instance).setRegistryName(obj.instance.getRegistryName()));
		}
		
		Global.logger.info("Register blocks over!");
	}
	
	@SideOnly(Side.CLIENT)
	public static void BlocksRenders() {
		Iterator<ObjInfo<Block>> iterator = ObjectsLists.Blocks.InfoList.iterator();
		while (iterator.hasNext()) {
			ObjInfo<Block> obj = iterator.next();
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(obj.instance), 0, 
		            new ModelResourceLocation(obj.instance.getRegistryName(), "inventory"));
		}
		
		Global.logger.info("Register blocks' renders over!");
	}
	public static class EntitiesNames{
		private static int id = 0;
		/*
		 private static void registerEntity(Class<? extends Entity> entityClass, String name) {
			 ForgeRegistries.ENTITIES.register(new EntityEntry(entityClass, name).setRegistryName(name));
		 }
		 */
		 private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
		            int updateFrequency, boolean sendsVelocityUpdates){
		     EntityRegistry.registerModEntity(new ResourceLocation(CodeWorld.MODID, name), entityClass, name, id++, Global.ModInstance, trackingRange, updateFrequency,
		                sendsVelocityUpdates);
		 }
		 private static void registerEntityEgg(String name, int eggPrimary, int eggSecondary){
		     EntityRegistry.registerEgg(new ResourceLocation(CodeWorld.MODID, name), eggPrimary, eggSecondary);
		 }
		 @SideOnly(Side.CLIENT)
		 private static <T extends Entity> void registerEntityRender(Class<T> entityClass, IRenderFactory<T> render) {
		     RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
		 }
	}
	
	
	public static void registerOres() {
		//OreDictionary.registerOre("ingotDataDebris", GroupData.ingot);
		//OreDictionary.registerOre("oreDataDebris", GroupData.ore);
	}
	
	@Nullable
	public static Item find(Item item) {
		for (int i = 0;i<ObjectsLists.Items.InfoList.size();++i) {
			if (ObjectsLists.Items.InfoList.get(i).instance.equals(item))
				return ObjectsLists.Items.InfoList.get(i).instance;
		}
		return null;
	}
	
	@Nullable
	public static Block find(Block block) {
		for (int i = 0;i<ObjectsLists.Blocks.InfoList.size();++i) {
			if (ObjectsLists.Blocks.InfoList.get(i).instance.equals(block))
				return ObjectsLists.Blocks.InfoList.get(i).instance;
		}
		return null;
	}
	
	
}
