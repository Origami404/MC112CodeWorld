package com.gumi229.code.init.client;


import com.gumi229.code.init.common.CommonProxy;
import com.gumi229.code.loader.EntitiesLoader;
import com.gumi229.code.loader.GroupLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
       super.preInit(event);

       GroupLoader.loadGroupRenders();
       EntitiesLoader.registerEntityRenders();
    }

    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }
}
