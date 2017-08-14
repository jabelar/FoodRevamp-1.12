package com.blogspot.jabelarminecraft.foodrevamp.items;

import com.blogspot.jabelarminecraft.foodrevamp.utilities.Utilities;

import net.minecraft.item.ItemFood;

public class ItemMeat extends ItemFood
{

	public ItemMeat() 
	{
		super(2, 0.2F, true);
		Utilities.setItemName(this, "meat_raw");
	}
}
