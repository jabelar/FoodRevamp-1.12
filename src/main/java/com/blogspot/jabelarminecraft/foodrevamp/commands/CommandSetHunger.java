package com.blogspot.jabelarminecraft.foodrevamp.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.FoodStats;

public class CommandSetHunger extends CommandBase
{
	@Override
	public String getName() 
	{
		return "sh";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "sh <text>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		Entity theEntity = sender.getCommandSenderEntity();
		EntityPlayer thePlayer = null;
		if (theEntity instanceof EntityPlayer)
		{
			thePlayer = (EntityPlayer)theEntity;
			FoodStats theFoodStats = thePlayer.getFoodStats();
			
			int foodLevel = thePlayer.getFoodStats().getFoodLevel() - 10;
			if (foodLevel < 1)
			{
				foodLevel = 1;
			}
			
			theFoodStats.setFoodLevel(foodLevel);
		}
	}
}
