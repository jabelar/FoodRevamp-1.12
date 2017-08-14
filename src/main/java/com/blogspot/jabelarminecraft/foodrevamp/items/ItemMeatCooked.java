package com.blogspot.jabelarminecraft.foodrevamp.items;

import com.blogspot.jabelarminecraft.foodrevamp.utilities.Utilities;

import net.minecraft.item.ItemFood;

public class ItemMeatCooked extends ItemFood
{

	public ItemMeatCooked() 
	{
		super(4, 0.4F, true);
		Utilities.setItemName(this, "meat_cooked");
	}
}
