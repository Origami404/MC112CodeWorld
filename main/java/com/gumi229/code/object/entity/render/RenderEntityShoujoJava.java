package com.gumi229.code.object.entity.render;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.object.entity.EntityShoujoJava;
import com.gumi229.code.object.entity.model.ModelEntityShoujo;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderEntityShoujoJava extends RenderEntityShoujo<EntityShoujoJava> {

	public RenderEntityShoujoJava(RenderManager renderManager) {
		//第三个参数表示的是阴影大小，这里用默认的0.5就可以了
		super(renderManager, new ModelEntityShoujo(), "shoujo_java");
	}
	
	
    @Override
    public void doRender(EntityShoujoJava entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
