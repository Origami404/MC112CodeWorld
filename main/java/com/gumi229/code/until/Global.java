package com.gumi229.code.until;

import com.gumi229.code.CodeWorld;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import com.gumi229.code.ui.CodeWorldTabs;
import net.minecraftforge.fml.common.Mod.Instance;

import java.util.Random;

import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Global {
	@Instance(CodeWorld.MODID)
    public static CodeWorld ModInstance = new CodeWorld();
    public static Logger logger;
    public static Random randomer=new Random();
    
    public static void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	logger.debug("Global's preInit is Over.");
    }
    
    //输入概率（小数），返回boolean值
    public static boolean rand(double probability) {
    	return randomer.nextInt((int) (1/probability)) == 0;
    }
    
    public static void setTab(Item item) {
    	item.setCreativeTab(CodeWorldTabs.tabCodeWorld);
    }
    
    public static void setTab(Block block) {
    	block.setCreativeTab(CodeWorldTabs.tabCodeWorld);
    }
}
