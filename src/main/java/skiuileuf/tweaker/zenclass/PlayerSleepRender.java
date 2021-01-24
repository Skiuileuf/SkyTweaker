package skiuileuf.tweaker.zenclass;

import java.util.UUID;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;



//@ZenClass("mods.skytweaker.Render")
//@ZenRegister
public class PlayerSleepRender {
	
	public static SimpleNetworkWrapper network;
	
	//@ZenMethod
	public static void setSleep(IPlayer iplayer) 
	{
		EntityPlayer player = CraftTweakerMC.getPlayer(iplayer);
		
		
	}
}
