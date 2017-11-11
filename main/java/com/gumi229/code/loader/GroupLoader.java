package com.gumi229.code.loader;

import com.gumi229.code.object.group.Group;
import com.gumi229.code.object.group.GroupCode;
import com.gumi229.code.object.group.GroupData;
import com.gumi229.code.until.Global;

public class GroupLoader {
	public static void loadGroups() {
		loadGroup(GroupData.instance());
		loadGroup(GroupCode.instance());
	}

	public static void loadGroupRenders() {
		loadGroupRender(GroupData.instance());
		loadGroupRender(GroupCode.instance());
	}

	public static void loadGroup(Group group) {
		ItemsLoader.loadItem(group.ingot, group.getRegistryName("ingot"), group.getUnlocalizedName("ingot"));
		ItemsLoader.loadItem(group.sword, group.getRegistryName("sword"), group.getUnlocalizedName("sword"));
		ItemsLoader.loadItem(group.pickaxe, group.getRegistryName("pickaxe"), group.getUnlocalizedName("pickaxe"));
		ItemsLoader.loadItem(group.axe, group.getRegistryName("axe"), group.getUnlocalizedName("axe"));
		ItemsLoader.loadItem(group.hoe, group.getRegistryName("hoe"), group.getUnlocalizedName("hoe"));
		ItemsLoader.loadItem(group.shovel, group.getRegistryName("shovel"), group.getUnlocalizedName("shovel"));
		BlocksLoader.loadBlock(group.ore, group.getRegistryName("ore"), group.getUnlocalizedName("ore"));
		BlocksLoader.loadBlock(group.cube, group.getRegistryName("cube"), group.getUnlocalizedName("cube"));
		Global.logger.info("Load group {} names success!", group.groupName);
	}

	public static void loadGroupRender(Group group) {
		ItemsLoader.loadItemRender(group.ingot);
		ItemsLoader.loadItemRender(group.sword);
		ItemsLoader.loadItemRender(group.pickaxe);
		ItemsLoader.loadItemRender(group.axe);
		ItemsLoader.loadItemRender(group.hoe);
		ItemsLoader.loadItemRender(group.shovel);
		BlocksLoader.loadBlockRender(group.ore);
		BlocksLoader.loadBlockRender(group.cube);
		Global.logger.info("Load group {} renders success!", group.groupName);
	}

}
