package com.gumi229.code.backup;

import java.util.ArrayList;

import com.gumi229.code.registrier.ObjInfo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface Group {
	public abstract void addItemsToList(ArrayList< ObjInfo<Item> > list);
	public abstract void addBlocksToList(ArrayList< ObjInfo<Block> > list);
}
