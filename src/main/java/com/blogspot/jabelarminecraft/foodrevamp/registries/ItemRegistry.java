package com.blogspot.jabelarminecraft.foodrevamp.registries;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.jabelarminecraft.foodrevamp.MainMod;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemMeat;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemMeatCooked;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemRoot;
import com.blogspot.jabelarminecraft.foodrevamp.items.ItemRootBaked;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.client.model.ModelLoader;
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
		FurnaceRecipes.instance().addSmeltingRecipe(
				new ItemStack(ItemRegistry.MEAT), 
				new ItemStack(ItemRegistry.MEAT_COOKED), 
				0.35F
				);
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
			
			registerItemModels();

			initialize();
		}
	}
	
    public static void registerItemModels()
    {
        // DEBUG
        System.out.println("Registering item renderers");
        
        registerItemModel(ItemRegistry.MEAT);
        registerItemModel(ItemRegistry.MEAT_COOKED);
        registerItemModel(ItemRegistry.ROOT);
        registerItemModel(ItemRegistry.ROOT_BAKED);
    }
    
    public static void registerItemModel(Item parItem)
    {
    	registerItemModel(parItem, 0);
    }
    
    public static void registerItemModel(Item parItem, int parMetaData)
    {
        ModelLoader.setCustomModelResourceLocation(parItem, parMetaData, new ModelResourceLocation(MainMod.MODID + ":" + parItem.getUnlocalizedName().substring(5), "inventory"));
    }

	//	public static class ArmorMaterials {
	//		public static final ItemArmor.ArmorMaterial ARMOUR_MATERIAL_REPLACEMENT = EnumHelper.addArmorMaterial(Constants.RESOURCE_PREFIX + "replacement", Constants.RESOURCE_PREFIX + "replacement", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, (float) 0);
	//	}
	//
	//	public static class ToolMaterials {
	//		public static final Item.ToolMaterial TOOL_MATERIAL_GLOWSTONE = EnumHelper.addToolMaterial("glowstone", 1, 5, 0.5f, 1.0f, 10);
	//	}

}
