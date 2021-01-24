package skiuileuf.tweaker;

import crafttweaker.mc1120.commands.Commands;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import skiuileuf.tweaker.client.EventHandlerClient;
import skiuileuf.tweaker.commands.CommandCooldown;
import skiuileuf.tweaker.util.Reference;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class SkyTweaker {
	
	@Instance
	public static SkyTweaker instance;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) 
	{
		//MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event) 
	{
		event.registerServerCommand(new CommandCooldown());
	}
	
}
