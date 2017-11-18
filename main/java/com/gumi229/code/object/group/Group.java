package com.gumi229.code.object.group;

import java.util.HashSet;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.until.Global;
import com.gumi229.code.until.GroupInfo;
import com.gumi229.code.until.ShapedRecipeJSONWritter;

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
	private final String stick = "minecraft:stick";

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

	private void wirteSR(String name, String line1, String line2) {
		ShapedRecipeJSONWritter.write(getAllRegistryName(name), line1, line2, " * ", "#", getAllRegistryName("ingot"),
				"*", "minecraft:stick");
	}

	public class Cube extends Block {
		public Cube() {
			super(Material.ROCK);
			this.setSoundType(SoundType.METAL);
			this.setHardness(groupInfo.oreHarfness);
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);
			ShapedRecipeJSONWritter.write(getAllRegistryName("cube"), "###", "###", "###", "#",
					getAllRegistryName("ingot"));
			Global.setTab(this);
		}
	}

	public class Ore extends Block {
		public Ore() {
			super(Material.ROCK);
			this.setSoundType(SoundType.STONE);
			// 纭害锛�50涓洪粦鏇滅煶
			this.setHardness(groupInfo.oreHarfness);
			// 寮�閲囩瓑绾э紝闀愶紝閾佹垨浠ヤ笂
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);
			this.setLightLevel(0.7f);
			/*
			 * setHardness鏄缃爾鍧楃殑纭害,杩欎釜纭害鏄浉瀵逛簬寰掓墜鑰岃█鐨�,娉ュ湡鏄�0.5,鐭冲ご鏄�1.5,澶ч儴鍒嗙熆鐭虫槸3.0.
			 * setResistance鏄缃鐖嗙偢鐨勬姉鎬�,鐭冲ご鏄�10.0.
			 * setLightLevel鏄缃彂鍏変寒搴�,鑼冨洿鏄�0.0~1.0,鍗楃摐鐏�,钀ょ煶鍜屽博娴嗘槸1.0,閫氬線涓嬬晫鐨勪紶閫侀棬鏄�0.75.
			 * 閲囬泦涓殑绾㈢煶鏄�0.625. setHarvestLevel鏄缃紑閲囩爾鍧楁椂闇�瑕佷娇鐢ㄧ殑宸ュ叿,鍙互鏄�"pickaxe"(闀�),
			 * "shovel"(閾插瓙)鎴�"axe"(鏂уご).鍚庨潰鐨勬暟鍊间负宸ュ叿鏉愯川瑕佹眰,-1(榛樿鍊�)涓哄彲浠ョ洿鎺ユ墜鎾�,0鏄湪璐ㄥ拰閲戣川,
			 * 1鏄煶璐�,2鏄搧璐�,3鏄捇鐭宠川.
			 * setSoundType鏄缃俯鍦ㄤ笂闈㈢殑鑴氭澹�.榛樿鍊煎氨鏄疭oundType.STONE(鐭冲ご鍦扮殑澹伴煶.)
			 * 杩欓噷鏄负浜嗘紨绀鸿繖涓柟娉曠殑鐢ㄩ��.
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
			wirteSR("sword", " # ", " # ");
			Global.setTab(this);
		}
	}

	public class Pickaxe extends ItemTool {
		public Pickaxe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel);
			wirteSR("pickaxe", "###", " * ");
			Global.setTab(this);
		}
	}

	public class Axe extends ItemTool {
		public Axe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("axe", groupInfo.harvestLevel);
			wirteSR("axe", "## ", "#  ");
			Global.setTab(this);
		}
	}

	public class Shovel extends ItemTool {
		public Shovel() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("shovel", groupInfo.harvestLevel);
			wirteSR("shovel", " # ", " * ");
			Global.setTab(this);
		}
	}

	public class Hoe extends ItemHoe {
		public Hoe() {
			super(groupInfo.toolMaterial);
			wirteSR("hoe", "## ", " * ");
			Global.setTab(this);
		}
	}
}
