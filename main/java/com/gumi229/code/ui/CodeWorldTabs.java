package com.gumi229.code.ui;

import com.gumi229.code.object.group.GroupData;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CodeWorldTabs extends CreativeTabs {
    public static CodeWorldTabs tabCodeWorld = new CodeWorldTabs();

    public CodeWorldTabs() {
        super("code_world");
    }
    
    public ItemStack getTabIconItem() {
        return new ItemStack(GroupData.instance.ingot);
    }
}
