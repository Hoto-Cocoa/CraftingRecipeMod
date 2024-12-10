package us.hoto.cccrftr;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(modid = CocoaCraftCraftingRecipesMod.MODID, name = CocoaCraftCraftingRecipesMod.NAME, version = CocoaCraftCraftingRecipesMod.VERSION)
public class CocoaCraftCraftingRecipesMod  {
	public static final String MODID = "cccrftr";
	public static final String NAME = "CocoaCraft CRM";
	public static final String VERSION = "13.1";

	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("FML Init");
	}
}
