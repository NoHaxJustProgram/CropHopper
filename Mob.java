package Hopper;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;



public class Mob extends JavaPlugin implements Listener
{
	
	public void onEnable()
	{
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("mobhopper").setExecutor(new Commands());
		this.getCommand("changehopper").setExecutor(new Commands());
		this.getCommand("test").setExecutor(new Commands());
	}
	
	public void onDisable()
	{
		
	}
	
	public void onItemPlace(BlockPlaceEvent bpe)
	{
		
	}

}
