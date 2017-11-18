package com.gumi229.code.registrier;
import net.minecraft.item.Item;

public class ObjInfo<T> {
	public final T      instance;
	public final String unlocalizedName;
	public final String registriyName;
	
	public ObjInfo(T instance, String unlocalizedName, String registriyName) {
		this.instance        = instance;
		this.unlocalizedName = unlocalizedName;
		this.registriyName   = registriyName;
	}
}