package com.gumi229.code.loader;

import java.util.ArrayList;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.object.entity.EntityShoujoJava;
import com.gumi229.code.object.entity.render.EntityRenderFactory;
import com.gumi229.code.object.entity.render.RenderEntityShoujoJava;
import com.gumi229.code.until.Global;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitiesLoader {
	private static int id = 0;
	//private static Biome[] allBiome = null;
	/*
	 private static void registerEntity(Class<? extends Entity> entityClass, String name) {
		 ForgeRegistries.ENTITIES.register(new EntityEntry(entityClass, name).setRegistryName(name));
	 }
	 */
	public static void registerEntities() {
		registerEntity(EntityShoujoJava.class, "ShoujoJava", 64, 3, true);
		registerEntityEgg("ShoujoJava", 0xFFA3DC, 0xFF0000);
		registerEntitySpawn(EntityShoujoJava.class, 100, 4, 8, EnumCreatureType.MONSTER, Biomes.PLAINS);
		
	}
	public static void registerEntityRenders() {
		registerEntityRender(EntityShoujoJava.class, RenderEntityShoujoJava.class);
	}
	
	
	public static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
	           int updateFrequency, boolean sendsVelocityUpdates){
	    EntityRegistry.registerModEntity(new ResourceLocation(CodeWorld.MODID, name), entityClass, name, id++, Global.ModInstance, trackingRange, updateFrequency,
	               sendsVelocityUpdates);
	}
	public static void registerEntityEgg(String name, int eggPrimary, int eggSecondary){
	     EntityRegistry.registerEgg(new ResourceLocation(CodeWorld.MODID, name), eggPrimary, eggSecondary);
	}
	
	@SideOnly(Side.CLIENT)
	public static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render) {
	    RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
	}
	
	  public static void registerEntitySpawn(Class<? extends Entity> entityClass, int spawnWeight, int min,
	            int max, EnumCreatureType typeOfCreature, Biome... biomes)
	    {
	        if (EntityLiving.class.isAssignableFrom(entityClass))
	        {
	            Class<? extends EntityLiving> entityLivingClass = entityClass.asSubclass(EntityLiving.class);
	            EntityRegistry.addSpawn(entityLivingClass, spawnWeight, min, max, typeOfCreature, biomes);
	        }
	    }
}
