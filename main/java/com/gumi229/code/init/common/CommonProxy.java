package com.gumi229.code.init.common;


import com.gumi229.code.event.*;
import com.gumi229.code.event.handler.*;
import com.gumi229.code.loader.EntitiesLoader;
import com.gumi229.code.loader.GroupLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    	GroupLoader.loadGroups();
    	EntitiesLoader.registerEntities(); 
    }

    public void init(FMLInitializationEvent event)
    {
    	new OreGenerate();
    }
}
