package com.gumi229.code.object.entity.render;

import com.gumi229.code.CodeWorld;
import com.gumi229.code.object.entity.EntityShoujoJava;
import com.gumi229.code.until.Global;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderEntityShoujo<T extends EntityLiving> extends  RenderLiving<T>{
	protected final String entityName;
	public RenderEntityShoujo(RenderManager rendermanagerIn, ModelBase modelbaseIn, String entityName) {
		super(rendermanagerIn, modelbaseIn, 0.5f);
		this.entityName = entityName;
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		//Global.logger.info(CodeWorld.MODID + ":" + "textures/entity" + entityName + ".png");
	        return new ResourceLocation(
	                CodeWorld.MODID + ":" + "textures/entity/" + entityName + ".png");
	}
	
	public String getEntityName() {
		return entityName;
	}

}
