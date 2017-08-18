package com.blogspot.jabelarminecraft.foodrevamp.items;

import com.blogspot.jabelarminecraft.foodrevamp.utilities.Utilities;

import net.minecraft.item.ItemFood;

public class ItemRoot extends ItemFood
{

	public ItemRoot() 
	{
		super(2, 0.4F, false);
		Utilities.setItemName(this, "root_raw");
	}
}
