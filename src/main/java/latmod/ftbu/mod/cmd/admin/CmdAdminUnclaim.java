package latmod.ftbu.mod.cmd.admin;

import latmod.ftbu.core.cmd.*;
import latmod.ftbu.core.util.MathHelperLM;
import latmod.ftbu.mod.player.*;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CmdAdminUnclaim extends SubCommand
{
	public String onCommand(ICommandSender ics, String[] args)
	{
		EntityPlayerMP ep = CommandLM.getCommandSenderAsPlayer(ics);
		
		ClaimedChunk c = Claims.get(ep.dimension, MathHelperLM.chunk(ep.posX), MathHelperLM.chunk(ep.posZ));
		
		if(c != null)
		{
			String s = c.toString();
			if(c.claims.unclaim(c.dim, c.posX, c.posZ, true))
				return CommandLM.FINE + "Unclaimed " + s;
			else
				return "Can't unclaim " + s + "!";
		}
		
		return "Chunk not claimed!";
	}
}