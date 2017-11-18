
package com.gumi229.code.envent;

import java.util.Random;

import com.gumi229.code.object.group.GroupData;
import com.gumi229.code.until.Global;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGenerate {
	private static WorldGenerator generatorDataDebrisOre = new GenDataDebrisOre();
	private BlockPos pos;

	@SubscribeEvent
	public void generate(OreGenEvent.Post event) {
		if (!event.getPos().equals(this.pos)) {
			this.pos = event.getPos();
			generatorDataDebrisOre.generate(event.getWorld(), event.getRand(), event.getPos());
			Global.logger.debug("Gen Ores!");
		}
	}

	public OreGenerate() {
		MinecraftForge.ORE_GEN_BUS.register(this);
	}

	public static class GenDataDebrisOre extends WorldGenerator {
		private final WorldGenerator generatorData = new WorldGenMinable(GroupData.instance.ore.getDefaultState(), 16);

		@Override
		public boolean generate(World world, Random rand, BlockPos pos) {
			if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
				for (int i = 0; i < 5; ++i) {
					int posX = pos.getX() + rand.nextInt(16);
					int posY = 16 + rand.nextInt(16);
					int posZ = pos.getZ() + rand.nextInt(16);
					BlockPos blockpos = new BlockPos(posX, posY, posZ);
					generatorData.generate(world, rand, blockpos);
				}
			}
			Global.logger.debug("Gen Ores!");
			return true;
		}
	}

}
