package com.gumi229.code.event.handler;

import com.gumi229.code.object.entity.EntityShoujo;
import com.gumi229.code.object.entity.EntityShoujoJava;
import com.gumi229.code.object.item.ShoujoSword;
import com.gumi229.code.until.Global;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

public class EventHandler {
	/*
	 * WARNING: It will make MC throws exception:
	 * 
	 * [12:39:28] [pool-2-thread-1/WARN]: Couldn't look up profile properties for
	 * com.mojang.authlib.GameProfile
	 * 
	 * com.mojang.authlib.exceptions.AuthenticationException: The client has sent
	 * too many requests within a certain amount of time
	 */
	// @SubscribeEvent
	public void onPlayerAttackingShoujoWithShoujoSword(CriticalHitEvent event) {
		Item heldItem = event.getEntityPlayer().getHeldItemMainhand().getItem();
		Entity target = event.getTarget();
		if (heldItem instanceof ShoujoSword && target instanceof EntityShoujoJava) {
			float multiple = ((ShoujoSword) heldItem).type.getMultiple(((EntityShoujo) target).getType());
			event.setDamageModifier(event.getDamageModifier() * multiple);
		}
	}

	// @SubscribeEvent
	public void addShoujoSwordLevel(LivingDeathEvent event) {
		if (event.getSource() instanceof EntityDamageSource) {
			if (((EntityDamageSource) event.getSource()).getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = ((EntityPlayer) event.getSource().getTrueSource());
				if (player.getHeldItemMainhand().getItem() instanceof ShoujoSword) {
					ShoujoSword sword = (ShoujoSword) player.getHeldItemMainhand().getItem();
					if (event.getEntity() instanceof EntityShoujo) {
						sword.addLevel(Global.rand(2, 5));
					} else {
						sword.addLevel(Global.rand(0, 3));
					}
				}
			}
		}
	}

	// @SubscribeEvent
	public void logForKilling(LivingDeathEvent event) {
		if (event.getSource() instanceof EntityDamageSource) {
			if (((EntityDamageSource) event.getSource()).getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = ((EntityPlayer) event.getSource().getTrueSource());
				ShoujoSword sword = (ShoujoSword) player.getHeldItemMainhand().getItem();

				Global.logger.info("!!!!!!!!!!!!!!!Player kill!!!!!!!!!");
				Global.logger.info("By {} , target is {}", sword.getClass().getName(),
						event.getEntity().getClass().getName());

			}
		}
	}
}
