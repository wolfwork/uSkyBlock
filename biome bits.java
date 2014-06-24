

  HashMap<String, Long> biomeCooldown = new HashMap();


  public boolean checkCurrentBiome(Player p, String biome)
  {
   return false;
  }



     if (((split[0].equals("biome")) || (split[0].equals("b"))) && (pi.getIslandLocation() != null))
     {
       if (uSkyBlock.getInstance().getIslandConfig(iName).getBoolean("party.members." + player.getName() + ".canChangeBiome"))
       {
         if ((!uSkyBlock.getInstance().onBiomeCooldown(player)) || (Settings.general_biomeChange == 0))
         {
           if (uSkyBlock.getInstance().playerIsOnIsland(player))
           {
             if (uSkyBlock.getInstance().changePlayerBiome(player, split[1]))
             {
               player.sendMessage(ChatColor.GREEN + "You have changed your island's biome to " + split[1].toUpperCase());
               player.sendMessage(ChatColor.GREEN + "You may need to relog to see the changes.");
               uSkyBlock.getInstance().sendMessageToIslandGroup(iName, player.getName() + " changed the island biome to " + split[1].toUpperCase());
               uSkyBlock.getInstance().setBiomeCooldown(player);
             }
             else
             {
               player.sendMessage(ChatColor.GREEN + "Unknown biome name, changing your biome to OCEAN");
               player.sendMessage(ChatColor.GREEN + "You may need to relog to see the changes.");
               uSkyBlock.getInstance().sendMessageToIslandGroup(iName, player.getName() + " changed the island biome to OCEAN");
             }
           }
           else {
             player.sendMessage(ChatColor.YELLOW + "You must be on your island to change the biome!");
           }
         }
         else
         {
           player.sendMessage(ChatColor.YELLOW + "You can change your biome again in " + uSkyBlock.getInstance().getBiomeCooldownTime(player) / 1000L / 60L + " minutes.");
           return true;
         }
       }
       else {
         player.sendMessage(ChatColor.RED + "You do not have permission to change the biome of this island!");
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


       setConfigBiome(player, bName);
  public void setConfigBiome(Player p, String biome)
  {
   getInstance().getIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(p.getName())).locationForParty()).set("general.biome", biome);
   getInstance().saveIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(p.getName())).locationForParty());
  }


       return true;
     }
     return false;
   }
   return false;
  }



  public void listBiomes(Player player)
  {
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


  public boolean onBiomeCooldown(Player player)
  {
   if (this.biomeCooldown.containsKey(player.getName()))
   {
     if (((Long)this.biomeCooldown.get(player.getName())).longValue() > Calendar.getInstance().getTimeInMillis()) {
       return true;
     }
     return false;
   }
   return false;
  }


  public long getBiomeCooldownTime(Player player)
  {
   if (this.biomeCooldown.containsKey(player.getName()))
   {
     if (((Long)this.biomeCooldown.get(player.getName())).longValue() > Calendar.getInstance().getTimeInMillis()) {
       return ((Long)this.biomeCooldown.get(player.getName())).longValue() - Calendar.getInstance().getTimeInMillis();
     }
     return 0L;
   }
   return 0L;
  }


  public void setBiomeCooldown(Player player)
  {
   this.biomeCooldown.put(player.getName(), Long.valueOf(Calendar.getInstance().getTimeInMillis() + Settings.general_biomeChange * 1000));
  }


  public String getCurrentBiome(Player player)
  {
   return getInstance().getIslandConfig(((PlayerInfo)getInstance().getActivePlayers().get(player.getName())).locationForParty()).getString("general.biome");
  }


       else if ((split[0].equals("setbiome")) && ((VaultHandler.checkPerk(player.getName(), "usb.mod.setbiome", player.getWorld())) || (player.isOp()))) {
         if (!uSkyBlock.getInstance().getActivePlayers().containsKey(split[1]))
         {
           PlayerInfo pi = new PlayerInfo(split[1]);
           if (!pi.getHasIsland())
           {
             player.sendMessage(ChatColor.RED + "Error: Invalid Player (check spelling)");
             return true;
           }
           uSkyBlock.getInstance().setBiome(pi.getIslandLocation(), "OCEAN");
           pi.savePlayerConfig(split[1]);
           player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to OCEAN.");
         }
         else
         {
           uSkyBlock.getInstance().setBiome(((PlayerInfo)uSkyBlock.getInstance().getActivePlayers().get(split[1])).getIslandLocation(), "OCEAN");
           player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to OCEAN.");
         }
       }


     else if ((split[0].equals("setbiome")) && ((VaultHandler.checkPerk(player.getName(), "usb.mod.setbiome", player.getWorld())) || (player.isOp()))) {
       if (!uSkyBlock.getInstance().getActivePlayers().containsKey(split[1]))
       {
         PlayerInfo pi = new PlayerInfo(split[1]);
         if (!pi.getHasIsland())
         {
           player.sendMessage(ChatColor.RED + "Error: Invalid Player (check spelling)");
           return true;
         }
         if (uSkyBlock.getInstance().setBiome(pi.getIslandLocation(), split[2])) {
           player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to " + split[2].toUpperCase() + ".");
         } else {
           player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to OCEAN.");
         }
         pi.savePlayerConfig(split[1]);
       }
       else if (uSkyBlock.getInstance().setBiome(((PlayerInfo)uSkyBlock.getInstance().getActivePlayers().get(split[1])).getIslandLocation(), split[2]))
       {
         player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to " + split[2].toUpperCase() + ".");
       }
       else
       {
         player.sendMessage(ChatColor.YELLOW + split[1] + " has had their biome changed to OCEAN.");
       }
     }


   try
   {
     Settings.general_biomeChange = getConfig().getInt("options.general.biomeChange");
     if (Settings.general_biomeChange < 0) {
       Settings.general_biomeChange = 0;
     }
   }
   catch (Exception e)
   {
     Settings.general_biomeChange = 3600;
   }

