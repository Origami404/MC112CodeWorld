package com.gumi229.code.object.group;

import java.util.HashSet;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.exception.CannotWriteJSONFile;
import com.gumi229.code.json.object.BlockItemModel;
import com.gumi229.code.json.object.BlockModel;
import com.gumi229.code.json.object.Blockstates;
import com.gumi229.code.json.object.ItemModel;
import com.gumi229.code.json.object.JSONObject;
import com.gumi229.code.json.object.ShapedRecipe;
import com.gumi229.code.json.writer.JSONWriter;
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
	static private final String stick = "minecraft:stick";

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

	/*
	 * Some method to get kinds of name
	 */

	// like "code_sword"
	public String getRegistryName(String name) {
		return (new StringBuilder()).append(groupName).append("_").append(name).toString();
	}

	// like "codeSword"
	public String getUnlocalizedName(String name) {
		return (new StringBuilder()).append(groupName).append(Character.toUpperCase(name.charAt(0)))
				.append(name.substring(1)).toString();
	}

	// like "code_world:code_sword"
	public String getAllRegistryName(String name) {
		return (new StringBuilder()).append(CodeWorld.MODID).append(":").append(this.getRegistryName(name)).toString();

	}

	/*
	 * All of the methods likes writeXXX, the arg called "name" should like
	 * "pickaxe" and "axe"
	 */
	private void writeRecipe(String name, String line1, String line2) {
		JSONObject recipe = (new ShapedRecipe.Builder()).RecipePattern(line1, line2, " * ")
				.RecipeKey("#", getAllRegistryName("ingot"), "*", "minecraft:stick")
				.RecipeResult(getAllRegistryName(name)).toJSONObject();
		try {
			JSONWriter.ShapedRecipe.write(recipe);
		} catch (CannotWriteJSONFile e) {
			e.printStackTrace();
		}
	}

	private void writeCubeRecipe() {
		JSONObject recipe = (new ShapedRecipe.Builder()).RecipePattern("###", "###", "###")
				.RecipeKey("#", getAllRegistryName("ingot")).RecipeResult(getAllRegistryName("cube")).toJSONObject();
		try {
			JSONWriter.ShapedRecipe.write(recipe);
		} catch (CannotWriteJSONFile e) {
			e.printStackTrace();
		}
	}

	private void writeItemModel(String name) {
		JSONObject model = new ItemModel("item/generated", getRegistryName(name));
		try {
			JSONWriter.ItemModel.write(model);
		} catch (CannotWriteJSONFile e) {
			e.printStackTrace();
		}
	}

	private void writeBlockModel(String name) {
		JSONObject itemModel = new BlockItemModel(getRegistryName(name));
		JSONObject blockModel = new BlockModel(getRegistryName(name));
		JSONObject blockstates = new Blockstates(getRegistryName(name));
		try {
			JSONWriter.ItemModel.write(itemModel);
			JSONWriter.BlockModel.write(blockModel);
			JSONWriter.Blockstates.write(blockstates);
		} catch (CannotWriteJSONFile e) {
			e.printStackTrace();
		}
	}

	/*
	 * Some class for item
	 */
	public class Cube extends Block {
		public Cube() {
			super(Material.ROCK);
			this.setSoundType(SoundType.METAL);
			this.setHardness(groupInfo.oreHarfness);
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);

			writeCubeRecipe();
			writeBlockModel("cube");
			Global.setTab(this);
		}
	}

	public class Ore extends Block {
		public Ore() {
			super(Material.ROCK);
			this.setSoundType(SoundType.STONE);
			this.setHardness(groupInfo.oreHarfness);
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel - 1);
			this.setLightLevel(0.7f);
			writeBlockModel("ore");
			Global.setTab(this);
		}
	}

	public class Ingot extends Item {
		public Ingot() {
			super();
			writeItemModel("ingot");
			Global.setTab(this);
		}
	}

	public class Sword extends ItemTool {
		public Sword() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			writeRecipe("sword", " # ", " # ");
			writeItemModel("sword");
			Global.setTab(this);
		}
	}

	public class Pickaxe extends ItemTool {
		public Pickaxe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("pickaxe", groupInfo.harvestLevel);
			writeRecipe("pickaxe", "###", " * ");
			writeItemModel("pickaxe");
			Global.setTab(this);
		}
	}

	public class Axe extends ItemTool {
		public Axe() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("axe", groupInfo.harvestLevel);
			writeRecipe("axe", "## ", "#* ");
			writeItemModel("axe");
			Global.setTab(this);
		}
	}

	public class Shovel extends ItemTool {
		public Shovel() {
			super(groupInfo.toolAttack, groupInfo.toolAttackSpeed, groupInfo.toolMaterial, new HashSet());
			this.setHarvestLevel("shovel", groupInfo.harvestLevel);
			writeRecipe("shovel", " # ", " * ");
			writeItemModel("shovel");
			Global.setTab(this);
		}
	}

	public class Hoe extends ItemHoe {
		public Hoe() {
			super(groupInfo.toolMaterial);
			writeRecipe("hoe", "## ", " * ");
			writeItemModel("hoe");
			Global.setTab(this);
		}
	}
}
