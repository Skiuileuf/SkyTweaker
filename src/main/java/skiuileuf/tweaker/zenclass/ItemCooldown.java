package skiuileuf.tweaker.zenclass;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.mc1120.player.MCPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.skytweaker.Cooldown")
@ZenRegister
public class ItemCooldown{
	@ZenMethod
	public static void setCooldown(IPlayer player, IItemStack item, float cooldownLength) 
	{
		float cooldownLengthInTicks = cooldownLength * 20;
		EntityPlayer ep = CraftTweakerMC.getPlayer(player);
		Item it = CraftTweakerMC.getItemStack(item).getItem();
		
		ep.getCooldownTracker().setCooldown(it, (int)cooldownLengthInTicks);
	}
	
	@ZenMethod
	public static float getCooldown(IPlayer player, IItemStack item)
	{
		EntityPlayer ep = CraftTweakerMC.getPlayer(player);
		Item it = CraftTweakerMC.getItemStack(item).getItem();
		return ep.getCooldownTracker().getCooldown(it, 0);
	}
}
