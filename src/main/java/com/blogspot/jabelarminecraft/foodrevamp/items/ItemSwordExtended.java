/**
 * 
 */
package com.blogspot.jabelarminecraft.foodrevamp.items;

import com.blogspot.jabelarminecraft.foodrevamp.utilities.Utilities;

import net.minecraft.item.ItemSword;

/**
 * @author jabelar
 *
 */
public class ItemSwordExtended extends ItemSword implements IExtendedReach
{
	public ItemSwordExtended(ToolMaterial parMaterial) 
	{
		super(parMaterial);
		Utilities.setItemName(this, "swordExtended");
		setCreativeTab(null);
	}

	@Override
	public float getReach() 
	{
		return 30.0F;
	}

}
