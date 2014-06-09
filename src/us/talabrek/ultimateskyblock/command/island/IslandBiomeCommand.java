package us.talabrek.ultimateskyblock.command.island;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.talabrek.ultimateskyblock.*;
import us.talabrek.ultimateskyblock.InviteHandler.Invite;

public class IslandPartyCommand implements ICommand
{

	@Override
	public String getName()
	{
		return "party";
	}

	@Override
	public String[] getAliases()
	{
		return null;
	}

	@Override
	public String getPermission()
	{
		return "usb.party.create";
	}

	@Override
	public String getUsageString( String label, CommandSender sender )
	{
		if(sender instanceof Player)
			return label;
		else
			return label + ChatColor.GOLD + " <player>";
	}

	@Override
	public String getDescription()
	{
		return "Views party information.";
	}

	@Override
	public boolean canBeConsole()
	{
		return true;
	}

	@Override
	public boolean canBeCommandBlock()
	{
		return false;
	}

	@Override
	public boolean onCommand( CommandSender sender, String label, String[] args )
	{
    if(sender instanceof Player)
		{
			if(args.length != 0)
				return false;
		}
		else
		{
			if(args.length != 1)
				return false;
		}
		
		UUIDPlayerInfo info = null;
		
		if(args.length == 1)
		{
			info = Misc.getPlayerInfo(args[0]);

  
  



  if (args[0]==ignoreCase("list")) {
    String biomeList = ", ";
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.ocean", getSkyBlockWorld())) {
    biomeList = "OCEAN, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.forest", getSkyBlockWorld())) {
    biomeList = biomeList + "FOREST, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.jungle", getSkyBlockWorld())) {
    biomeList = biomeList + "JUNGLE, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.desert", getSkyBlockWorld())) {
    biomeList = biomeList + "DESERT, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.taiga", getSkyBlockWorld())) {
    biomeList = biomeList + "TAIGA, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.swampland", getSkyBlockWorld())) {
    biomeList = biomeList + "SWAMPLAND, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.mushroom", getSkyBlockWorld())) {
    biomeList = biomeList + "MUSHROOM, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.hell", getSkyBlockWorld())) {
    biomeList = biomeList + "HELL, ";
    }
    if (VaultHandler.checkPerk(player.getName(), "usb.biome.sky", getSkyBlockWorld())) {
    biomeList = biomeList + "SKY, ";
    }
    player.sendMessage(ChatColor.YELLOW + "You have access to the following Biomes:");
    player.sendMessage(ChatColor.GREEN + biomeList.substring(0, biomeList.length() - 2));
    player.sendMessage(ChatColor.YELLOW + "Use /island biome <biomename> to change your biome. You must wait " + Settings.general_biomeChange / 60 + " minutes between each biome change.");
  }










  System.out.println("[uSkyBlock] Preparing to set initial player biome...");
  getInstance().changePlayerBiome(player, "OCEAN");






  public boolean setBiome(Location loc, String bName)
  {
  int px = loc.getBlockX();
  int pz = loc.getBlockZ();
  Biome bType = Biome.OCEAN;
  if (bName.equalsIgnoreCase("jungle")) {
  bType = Biome.JUNGLE;
  } else if (bName.equalsIgnoreCase("hell")) {
  bType = Biome.HELL;
  } else if (bName.equalsIgnoreCase("sky")) {
  bType = Biome.SKY;
  } else if (bName.equalsIgnoreCase("mushroom")) {
  bType = Biome.MUSHROOM_ISLAND;
  } else if (bName.equalsIgnoreCase("ocean")) {
  bType = Biome.OCEAN;
  } else if (bName.equalsIgnoreCase("swampland")) {
  bType = Biome.SWAMPLAND;
  } else if (bName.equalsIgnoreCase("taiga")) {
  bType = Biome.TAIGA;
  } else if (bName.equalsIgnoreCase("desert")) {
  bType = Biome.DESERT;
  } else if (bName.equalsIgnoreCase("forest")) {
  bType = Biome.FOREST;
  } else {
  bType = Biome.OCEAN;
  }
  for (int x = Settings.island_protectionRange / 2 * -1 - 16; x <= Settings.island_protectionRange / 2 + 16; x += 16) {
  for (int z = Settings.island_protectionRange / 2 * -1 - 16; z <= Settings.island_protectionRange / 2 + 16; z += 16) {
  getSkyBlockWorld().loadChunk((px + x) / 16, (pz + z) / 16);
  }
  }
  for (int x = Settings.island_protectionRange / 2 * -1; x <= Settings.island_protectionRange / 2; x++) {
  for (int z = Settings.island_protectionRange / 2 * -1; z <= Settings.island_protectionRange / 2; z++) {
  getSkyBlockWorld().setBiome(px + x, pz + z, bType);
  }
  }
  for (int x = Settings.island_protectionRange / 2 * -1 - 16; x <= Settings.island_protectionRange / 2 + 16; x += 16) {
  for (int z = Settings.island_protectionRange / 2 * -1 - 16; z <= Settings.island_protectionRange / 2 + 16; z += 16) {
  getSkyBlockWorld().refreshChunk((px + x) / 16, (pz + z) / 16);
  }
  }
  if (bType == Biome.OCEAN) {
  return false;
  }
  return true;
  }

  public boolean changePlayerBiome(Player player, String bName)
  {
  if (VaultHandler.checkPerk(player.getName(), "usb.biome." + bName, player.getWorld()))
  {
  if (getInstance().getIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(player.getName())).locationForParty()).getBoolean("party.members." + player.getName() + ".canChangeBiome"))
  {
  setBiome(((PlayerInfo)getInstance().getActivePlayers().get(player.getName())).getIslandLocation(), bName);
  setConfigBiome(player, bName);
  return true;
  }
  return false;
  }
  return false;
  }

  public void listBiomes(Player player)

  public boolean checkCurrentBiome(Player p, String biome)
  {
  if (getInstance().getIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(p.getName())).locationForParty()).getString("general.biome").equalsIgnoreCase(biome)) {
  return true;
  }
  return false;
  }

  public void setConfigBiome(Player player, String biome)
  {
  getInstance().getIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(player.getUniqueId())).locationForParty()).set("general.biome", biome);
  getInstance().saveIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(player.getUniqueId())).locationForParty());
  }
  (PlayerInfo)getInstance().getPlayer(player.getUniqueId())


































  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    if(sender instanceof Player)
		{
			if(args.length != 0)
				return false;
		}
		else
		{
			if(args.length != 1)
				return false;
		}
		
		UUIDPlayerInfo info = null;
		
		if(args.length == 1)
		{
			info = Misc.getPlayerInfo(args[0]);
			
			if(info == null)
			{
				sender.sendMessage("No player by name " + args[0]);
				return true;
			}
		}
		else
		{
			info = uSkyBlock.getInstance().getPlayer(((Player)sender).getUniqueId());
			
			if(info == null)
			{
				sender.sendMessage(ChatColor.RED + "You have not started skyblock. Please use " + ChatColor.YELLOW + "/island" + ChatColor.RED + " to begin");
				return true;
			}
		}
		
        if (info.getHasParty())
        {
        	if (sender instanceof Player && VaultHandler.hasPerm(sender, "usb.party.create"))
    			sender.sendMessage(ChatColor.WHITE + "/island invite <playername>" + ChatColor.YELLOW + " to invite a player to join your island.");
        	
            sender.sendMessage(ChatColor.WHITE + "/island leave" + ChatColor.YELLOW + " leave your current island and return to spawn");
            if (info.getPartyLeader().equals(sender.getName()))
            {
            	if (VaultHandler.hasPerm(sender, "usb.party.kick"))
            		sender.sendMessage(ChatColor.WHITE + "/island remove <playername>" + ChatColor.YELLOW + " remove <playername> from your island");
            	if (VaultHandler.hasPerm(sender, "usb.party.makeleader"))
            		sender.sendMessage(ChatColor.WHITE + "/island makeleader <playername>" + ChatColor.YELLOW + " give ownership of the island to <playername>");
            	
            	int maxSize = Settings.general_maxPartySize;
            	
            	if (VaultHandler.hasPerm(sender, "usb.extra.partysize"))
            		maxSize *= 2;
            	
            	if (info.getMembers().size() < maxSize)
            		sender.sendMessage(ChatColor.GREEN + "You can invite " + (maxSize - info.getMembers().size()) + " more players.");
                else 
                	sender.sendMessage(ChatColor.RED + "You can't invite any more players.");
            }

            sender.sendMessage(ChatColor.YELLOW + "Listing your island members:");
            UUIDPlayerInfo leader = uSkyBlock.getInstance().getPlayerNoStore(info.getPartyLeader());
            ArrayList<String> memberStrings = new ArrayList<String>();
            for (UUID member : leader.getMembers())
                memberStrings.add(Bukkit.getOfflinePlayer(member).getName());
            sender.sendMessage(ChatColor.WHITE + memberStrings.toString());
        } 
        else if (sender instanceof Player && InviteHandler.hasInvite((Player)sender))
        {
        	Invite invite = InviteHandler.getInvite((Player)sender);
        	
        	switch(invite.type)
        	{
        	case JoinIsland:
        		sender.sendMessage(ChatColor.YELLOW + invite.from.getName() + " has invited you to join their island.");
                sender.sendMessage(ChatColor.WHITE + "/island [accept/reject]" + ChatColor.YELLOW + " to accept or reject the invite.");
        		break;
        	case Transfer:
        		sender.sendMessage(ChatColor.YELLOW + invite.from.getName() + " has requested to transfer their island to you.");
                sender.sendMessage(ChatColor.WHITE + "/island [accept/reject]" + ChatColor.YELLOW + " to accept or reject the transfer.");
        		break;
        	}
        }
        else
        {
        	sender.sendMessage(ChatColor.RED + "Nothing to display.");
        }
        
		return true;
	}

	@Override
	public List<String> onTabComplete( CommandSender sender, String label, String[] args )
	{
		if(args.length == 1 && !(sender instanceof Player))
		{
			ArrayList<String> players = new ArrayList<String>();
			for(Player player : Bukkit.getOnlinePlayers())
			{
				if(player.getName().toLowerCase().startsWith(args[0].toLowerCase()))
				{
					if(sender instanceof Player && ((Player)sender).canSee(player))
						players.add(player.getName());
				}
			}
			
			return players;
		}
		
		return null;
	}

}
