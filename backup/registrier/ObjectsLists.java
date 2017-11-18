package com.gumi229.code.registrier;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import com.gumi229.code.object.item.*;

import java.util.ArrayList;

import com.gumi229.code.object.block.*;
import com.gumi229.code.until.*;

public class ObjectsLists {
	public static void InitObjInfos() {
		Items.AddInfos();
		Blocks.AddInfos();
	}
	
	//Items Info, including a instance, unlocalized name, and a registry name
	public static class Items {
		public static ArrayList< ObjInfo<Item> > InfoList = new ArrayList< ObjInfo<Item> >();
		
		public static void AddInfos() {
			//You should add a new item likes that:
		    //this.ItemsInfoList.add( new ObjInfo(instance, unloaclizedName, registry_name)  );
			//GroupData.instance.addItemsToList(InfoList);
			//GroupCode.instance.addItemsToList(InfoList);
		}
		
		
	}
	
	public static class Blocks {
		public static ArrayList< ObjInfo<Block> > InfoList = new ArrayList< ObjInfo<Block> >();
		
		public static void AddInfos() {
			//GroupData.instance.addBlocksToList(InfoList);
			//GroupCode.instance.addBlocksToList(InfoList);
		}
	}
	
}
