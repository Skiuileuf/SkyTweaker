package skiuileuf.tweaker.commands;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandCooldown extends CommandBase{
	@Override
	public String getName() {
		return "cooldown";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/cooldown set <targets> <item> <seconds> OR get <targets> <item>";
	}
	
	@Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 3)
        {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
        else
        {
            EntityPlayer player = (EntityPlayer)getEntity(server, sender, args[1], EntityPlayer.class); //TARGET PLAYER
            Item item = getItemByText(sender, args[2]);
           
            if ("set".equals(args[0]) && args.length == 4) // 0 - set, 1 - targets, 2 - item, 3 - seconds
            {
            	int duration = parseInt(args[3], 0, 1000000);
            	player.getCooldownTracker().setCooldown(item, duration * 20);
            	
            	ITextComponent text = new TextComponentString("Set cooldown on " + args[2] + " for " + player.getName() + " to " + duration);
            	player.sendMessage(text);
            	
            }
            else if ("get".equals(args[0]) && args.length == 3) // 0 - get, 1 - targets, 2 - item
            {
            	ITextComponent text = new TextComponentString("Cooldown on " + args[2] + " for " + player.getName() + " is " + player.getCooldownTracker().getCooldown(item, 0));
            	player.sendMessage(text);
            }
        }
	}
	
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
    	if(args.length == 1)
    	{
    		return getListOfStringsMatchingLastWord(args, new String[] {"set", "get"});
    	}
    	else if (args.length == 2)
        {
            return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        }
        else
        {
        	return args.length == 3 ? getListOfStringsMatchingLastWord(args, Item.REGISTRY.getKeys()) : Collections.emptyList();
        }
    }
}
