package com.blogspot.jabelarminecraft.foodrevamp.registries;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.jabelarminecraft.foodrevamp.MainMod;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemMeat;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemMeatCooked;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemRoot;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemRootBaked;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(MainMod.MODID)
public class ItemRegistry {
//	public static class ArmorMaterials {
//		public static final ItemArmor.ArmorMaterial ARMOUR_MATERIAL_REPLACEMENT = EnumHelper.addArmorMaterial(Constants.RESOURCE_PREFIX + "replacement", Constants.RESOURCE_PREFIX + "replacement", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, (float) 0);
//	}
//
//	public static class ToolMaterials {
//		public static final Item.ToolMaterial TOOL_MATERIAL_GLOWSTONE = EnumHelper.addToolMaterial("glowstone", 1, 5, 0.5f, 1.0f, 10);
//	}

    // instantiate items
	public final static ItemMeat MEAT = new ItemMeat();
	public final static ItemMeatCooked MEAT_COOKED = new ItemMeatCooked();
	public final static ItemRoot ROOT = new ItemRoot();
	public final static ItemRootBaked ROOT_BAKED = new ItemRootBaked();

	/**
	 * Initialize this mod's {@link Item}s with any post-registration data.
	 */
	private static void initialize() 
	{
	}

	@Mod.EventBusSubscriber(modid = MainMod.MODID)
	public static class RegistrationHandler 
	{
		public static final Set<Item> SET_ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<Item> event) 
		{
			final Item[] arrayItems = {MEAT, MEAT_COOKED, ROOT, ROOT_BAKED};

			final IForgeRegistry<Item> registry = event.getRegistry();

	        System.out.println("Registering items");

			for (final Item item : arrayItems) {
				registry.register(item);
				SET_ITEMS.add(item);
				// DEBUG
				System.out.println("Registering item: "+item.getRegistryName());
			}

			initialize();
		}
	}

	//	public static class ArmorMaterials {
	//		public static final ItemArmor.ArmorMaterial ARMOUR_MATERIAL_REPLACEMENT = EnumHelper.addArmorMaterial(Constants.RESOURCE_PREFIX + "replacement", Constants.RESOURCE_PREFIX + "replacement", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, (float) 0);
	//	}
	//
	//	public static class ToolMaterials {
	//		public static final Item.ToolMaterial TOOL_MATERIAL_GLOWSTONE = EnumHelper.addToolMaterial("glowstone", 1, 5, 0.5f, 1.0f, 10);
	//	}

}
