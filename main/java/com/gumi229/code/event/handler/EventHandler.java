package com.gumi229.code.event.handler;

import com.gumi229.code.object.entity.EntityShoujo;
import com.gumi229.code.object.entity.EntityShoujoJava;
import com.gumi229.code.object.item.ShoujoSword;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	@SubscribeEvent
	public void onPlayerAttackingShoujoWithShoujoSword(CriticalHitEvent event) {
		Item heldItem = event.getEntityPlayer().getHeldItemMainhand().getItem();
		Entity target = event.getTarget();
		if (heldItem instanceof ShoujoSword && target instanceof EntityShoujoJava) {
			float multiple = ((ShoujoSword) heldItem).type.getMultiple(((EntityShoujo) target).type);
			event.setDamageModifier(event.getDamageModifier() * multiple);
		}
	}

	@SubscribeEvent
	public void addShoujoSwordLevel(LivingDeathEvent event) {
		if (event.getEntity() instanceof EntityShoujo && event.getSource() instanceof EntityDamageSource) {
			if (((EntityDamageSource) event.getSource()).getTrueSource() instanceof EntityPlayer) {

			}
		}
	}
}
