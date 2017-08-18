package com.blogspot.jabelarminecraft.foodrevamp.items;

import com.blogspot.jabelarminecraft.foodrevamp.utilities.Utilities;

import net.minecraft.item.ItemFood;

public class ItemRootBaked extends ItemFood
{

	public ItemRootBaked() 
	{
		super(4, 0.8F, false);
		Utilities.setItemName(this, "root_baked");
	}
}
