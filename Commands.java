package Hopper;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;


public class Commands implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		String mobName = "PIG";
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("mobhopper"))
		{
			if (player.getItemInHand().getType() == Material.HOPPER)
			{
				int amount = Integer.valueOf(args[0]);
				ItemStack hopper = new ItemStack(Material.HOPPER);
				ItemStack mobHopper = new ItemStack(Material.HOPPER, amount);
				ItemMeta mobMeta = mobHopper.getItemMeta();
				ArrayList<String> mobArrayList = new ArrayList<String>();
				mobMeta.setDisplayName(ChatColor.RED + "Mob Hopper");
				mobArrayList.add(ChatColor.BLUE + "A " + mobName + " mob hopper.");
				mobMeta.setLore(mobArrayList);
				mobHopper.setItemMeta(mobMeta);
				
				for (int i = 0; i < player.getInventory().getSize(); i++)
				{
					ItemStack itemInIndex = player.getInventory().getItem(i);
					
					if (itemInIndex != null && itemInIndex.getType().equals(Material.HOPPER))
					{
						int amt = itemInIndex.getAmount() - amount;
						if (amount > player.getItemInHand().getAmount())
						{
							player.sendMessage(ChatColor.RED +"You only have " + player.getItemInHand().getAmount() +
								" " + player.getItemInHand().getType() + "'s");
							break;
						}
						itemInIndex.setAmount(amt);
						player.getInventory().setItem(i, amt > 0 ? itemInIndex : null);
						player.updateInventory();
						player.getInventory().addItem(new ItemStack(mobHopper));
						break;
					}
				}
			
			}
			else
			{
				player.sendMessage(ChatColor.RED + "Please hold a hopper in your hand!");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("test"))
		{
			player.sendMessage("Works!");
		}
		
		return true;
	}
}
