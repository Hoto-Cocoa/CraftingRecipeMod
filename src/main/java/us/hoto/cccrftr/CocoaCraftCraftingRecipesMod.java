package us.hoto.cccrftr;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(modid = CocoaCraftCraftingRecipesMod.MODID, name = CocoaCraftCraftingRecipesMod.NAME, version = CocoaCraftCraftingRecipesMod.VERSION)
public class CocoaCraftCraftingRecipesMod  {
	public static final String MODID = "cccrftr";
	public static final String NAME = "CocoaCraft CRM";
	public static final String VERSION = "5.0";

	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		ModItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("FML Init");
	}
}

@Mod.EventBusSubscriber(modid=CocoaCraftCraftingRecipesMod.MODID)
class ModItems {
	static Item base;

	public static void init() {
		base = new ItemBase("base");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(base);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(base);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
	}
}

class ItemBase extends Item {
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxDamage(0);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.MISC);
	}
}
