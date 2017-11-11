package com.gumi229.code.object.group;

import java.util.HashSet;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.until.Global;
import com.gumi229.code.until.GroupInfo;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemTool;

public class Group {
	public final Item ingot, sword, shovel, pickaxe, axe, hoe;
	public final Block ore, cube;
	public final String groupName;
	public final GroupInfo groupInfo;

	/*
	 * public final String[] itemName = { "ingot", "sword", "shovel", "pickaxe",
	 * "axe", "hoe" }; public final String[] blockName = { "ore", "cube" };
	 */
	public String getRegistryName(String name) {
		return (new StringBuilder()).append(groupName).append("_").append(name).toString();
	}

	public String getUnlocalizedName(String name) {
		return (new StringBuilder()).append(groupName).append(Character.toUpperCase(name.charAt(0)))
				.append(name.substring(1)).toString();
	}

	public String getAllRegistryName(String name) {
		return (new StringBuilder()).append(CodeWorld.MODID).append(":").append(this.getRegistryName(name)).toString();

	}

	public Group(String groupName, GroupInfo groupInfo) {
		this.groupName = groupName;
		this.groupInfo = groupInfo;

		this.ingot = this.new Ingot();
		this.sword = this.new Sword();
		this.pickaxe = this.new Pickaxe();
		this.shovel = this.new Shovel();
		this.axe = this.new Axe();
		this.hoe = this.new Hoe();
		this.ore = this.new Ore();
		this.cube = this.new Cube();

	}

	public class Cube extends Block {
		public Cube() {
			super(Material.ROCK);
			this.setSoundType(SoundType.METAL);
			this.setHardness(groupInfo.oreHarfness);
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);
			Global.setTab(this);
		}
	}

	public class Ore extends Block {
		public Ore() {
			super(Material.ROCK);
			this.setSoundType(SoundType.STONE);
			// 硬度，50为黑曜石
			this.setHardness(groupInfo.oreHarfness);
			// 开采等级，镐，铁或以上
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);
			this.setLightLevel(0.7f);
			/*
			 * setHardness是设置砖块的硬度,这个硬度是相对于徒手而言的,泥土是0.5,石头是1.5,大部分矿石是3.0.
			 * setResistance是设置对爆炸的抗性,石头是10.0.
			 * setLightLevel是设置发光亮度,范围是0.0~1.0,南瓜灯,萤石和岩浆是1.0,通往下界的传送门是0.75.采集中的红石是0.625.
			 * setHarvestLevel是设置开采砖块时需要使用的工具,可以是"pickaxe"(镐),
			 * "shovel"(铲子)或"axe"(斧头).后面的数值为工具材质要求,-1(默认值)为可以直接手撕,0是木质和金质,1是石质,2是铁质,3是钻石质.
			 * setSoundType是设置踩在上面的脚步声.默认值就是SoundType.STONE(石头地的声音.) 这里是为了演示这个方法的用途.
			 */
			Global.setTab(this);
		}
	}

	public class Ingot extends Item {
		public Ingot() {
			super();
			Global.setTab(this);
		}
	}

	public class Sword extends ItemTool {
		public Sword() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			Global.setTab(this);
		}
	}

	public class Pickaxe extends ItemTool {
		public Pickaxe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel);
			Global.setTab(this);
		}
	}

	public class Axe extends ItemTool {
		public Axe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("axe", groupInfo.harvestLevel);
			Global.setTab(this);
		}
	}

	public class Shovel extends ItemTool {
		public Shovel() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("shovel", groupInfo.harvestLevel);
			Global.setTab(this);
		}
	}

	public class Hoe extends ItemHoe {
		public Hoe() {
			super(groupInfo.toolMaterial);
			Global.setTab(this);
		}
	}
}
