package com.gumi229.code.object.group;

import com.gumi229.code.until.GroupInfo;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class GroupData extends Group {

	/*
	 * 我们发现EnumHelper本身就提供了一个addToolMaterial方法，我们来分析一下这个方法的参数（此方法为所有种类工具共用）。
	 * addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency,
	 * float damage, int enchantability) name表示枚举项的名称，比如铁是IRON，石是STONE
	 * harvestLevel为挖掘等级（钻石-3，铁-2，石-1，木-0，金-0）
	 * maxUses表示的值为耐久-1（注意是耐久-1不是耐久，钻石剑耐久为1562，它的maxUses为1561）
	 * efficiency为挖掘效率（钻石-8，铁-6，石-4，木-2，金-12）
	 * damage表示攻击实体的伤害（对于剑来说表示对实体伤害-4，例如钻石剑的这个值为3） enchantability 表示物品的附魔能力
	 */
	// 调用基类的构造函数,参数分别是攻击实体(Entity)造成的伤害加成,
	// 挥动时的冷却加成(正数减小冷却,负数增加冷却,但建议不要小于或等于-4),
	// 工具材质(ToolMaterial),能被这种工具加速挖掘的砖块.
	// 其中,第四个参数是原版MC用的,使用Forge的可以无视.
	private static final ToolMaterial material = EnumHelper.addToolMaterial("DATA", 3, 500, 7.0F, 3.0F, 5);
	private static final int harvestLevel = 3;

	public static GroupData instance = null;

	public static GroupData instance() {
		if (instance == null) {
			instance = new GroupData();
		}
		return instance;
	}

	public GroupData() {
		super("data", new GroupInfo(30.0f, harvestLevel, 4.0f, 5.0f, material));
	}

}
