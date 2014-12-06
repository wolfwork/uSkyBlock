package us.talabrek.ultimateskyblock.command.island;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;

import us.talabrek.ultimateskyblock.*;

public class IslandBiomeCommand implements ICommand {

    @Override
    public String getName() {
        return "biome";
    }

    @Override
    public String[] getAliases() {
        return null;
    }

    @Override
    public String getPermission() {
        return "usb.biome.*";
    }

    @Override
    public String getUsageString(String label, CommandSender sender) {
        if (sender instanceof Player)
            return label;
        else
            return label + ChatColor.GOLD + " <biome>";
    }

    @Override
    public String getDescription() {
        return "Changes the island's biome.";
    }

    @Override
    public boolean canBeConsole() {
        return false;
    }

    @Override
    public boolean canBeCommandBlock() {
        return false;
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        return false;
        /*
        Player player = (Player) sender;
        UUIDPlayerInfo info = uSkyBlock.getInstance().getPlayer(player.getUniqueId());

        if (!uSkyBlock.isSkyBlockWorld(event.getPlayer().getWorld()) || !uSkyBlock.getInstance().playerIsOnIsland(player)) {
            sender.sendMessage(ChatColor.RED + "You need to be on your island to change your biome.");
            return false;
        }

        if (sender instanceof Player) {
            if (args.length == 0) {
                if (player.getIslandBiome(true)) {
                    sender.sendMessage(ChatColor.GREEN + "Your island's biome is " + player.getIslandBiome());
                }

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
                player.sendMessage(ChatColor.YELLOW + "Use /island biome <biomename> to change your biome.");
                return true;

            } else if (args.length == 1) {
                if (!VaultHandler.checkPerk(player.getName(), "usb.biome." + args[0], player.getWorld())) {
                    return false;
                }
                if (args[0] == ignoreCase("jungle")) {
                    newBiome = Biome.JUNGLE;

                } else if (args[0] == ignoreCase("hell")) {
                    newBiome = Biome.HELL;

                } else if (args[0] == ignoreCase("sky")) {
                    newBiome = Biome.SKY;

                } else if (args[0] == ignoreCase("mushroom")) {
                    newBiome = Biome.MUSHROOM_ISLAND;

                } else if (args[0] == ignoreCase("ocean")) {
                    newBiome = Biome.OCEAN;

                } else if (args[0] == ignoreCase("swampland")) {
                    newBiome = Biome.SWAMPLAND;

                } else if (args[0] == ignoreCase("taiga")) {
                    newBiome = Biome.TAIGA;

                } else if (args[0] == ignoreCase("desert")) {
                    newBiome = Biome.DESERT;

                } else if (args[0] == ignoreCase("forest")) {
                    newBiome = Biome.FOREST;

                } else {
                    newBiome = Biome.OCEAN;

                }

                Location loc = player.getIslandLocation();
                int px = loc.getBlockX();
                int pz = loc.getBlockZ();

                for (int x = Settings.island_protectionRange / 2 * -1 - 16; x <= Settings.island_protectionRange / 2 + 16; x += 16) {
                    for (int z = Settings.island_protectionRange / 2 * -1 - 16; z <= Settings.island_protectionRange / 2 + 16; z += 16) {
                        getSkyBlockWorld().loadChunk((px + x) / 16, (pz + z) / 16);
                    }
                }

                for (int x = Settings.island_protectionRange / 2 * -1; x <= Settings.island_protectionRange / 2; x++) {
                    for (int z = Settings.island_protectionRange / 2 * -1; z <= Settings.island_protectionRange / 2; z++) {
                        getSkyBlockWorld().setBiome(px + x, pz + z, newBiome);
                    }
                }

                for (int x = Settings.island_protectionRange / 2 * -1 - 16; x <= Settings.island_protectionRange / 2 + 16; x += 16) {
                    for (int z = Settings.island_protectionRange / 2 * -1 - 16; z <= Settings.island_protectionRange / 2 + 16; z += 16) {
                        getSkyBlockWorld().refreshChunk((px + x) / 16, (pz + z) / 16);
                    }
                }

                player.setIslandBiome(newBiome);
                sender.sendMessage(ChatColor.GREEN + "Your island's biome has been changed to " + newBiome);
                return true;

            } else {
                sender.sendMessage(ChatColor.RED + "Invalid command parameters.");
                return false;
            }
        }
        */
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
        if (args.length == 1 && !(sender instanceof Player)) {
            ArrayList<String> players = new ArrayList<String>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                    if (sender instanceof Player && ((Player) sender).canSee(player))
                        players.add(player.getName());
                }
            }

            return players;
        }

        return null;
    }

}
