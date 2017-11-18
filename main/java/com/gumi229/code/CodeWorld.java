package com.gumi229.code;

import com.gumi229.code.init.common.CommonProxy;
import com.gumi229.code.until.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CodeWorld.MODID, name = CodeWorld.NAME, version = CodeWorld.VERSION)
public class CodeWorld {
	public static final String MODID = "code_world";
	public static final String NAME = "Code World";
	public static final String VERSION = "0.1";
	
	@SidedProxy(clientSide = "com.gumi229.code.init.client.ClientProxy", 
				serverSide = "com.gumi229.code.init.common.CommandProxy")
	public static CommonProxy proxy;
	
	@Instance(MODID)
	public static CodeWorld instance;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Global.preInit(event);
        proxy.preInit(event);
        Global.logger.info("Main Class PreInit is Over.");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        Global.logger.info("Main Class Init is Over.");
    }
}
