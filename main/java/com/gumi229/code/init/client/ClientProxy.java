package com.gumi229.code.init.client;

import com.gumi229.code.init.common.CommonProxy;
import com.gumi229.code.loader.EntitiesLoader;
import com.gumi229.code.loader.GroupLoader;
import com.gumi229.code.loader.HotkeyLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		GroupLoader.loadGroupRenders();
		EntitiesLoader.registerEntityRenders();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		HotkeyLoader.loadHotkeys();
	}
}
