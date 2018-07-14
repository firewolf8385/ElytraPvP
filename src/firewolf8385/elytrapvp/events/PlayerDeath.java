package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.PlayerData;
import firewolf8385.elytrapvp.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;



public class PlayerDeath implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        // Checks if the plugin is enabled
        if(settings.getConfig().getBoolean("Enabled")) {

            // Cancels the death message so that we can have custom ones.
            e.setDeathMessage(null);

            Player p = e.getEntity().getPlayer();
            PlayerData player = new PlayerData(p.getUniqueId());

            player.addDeaths(1);  // Adds A Death
            player.setKillstreak(0); // Resets The Player's Killstreak
            player.savePlayerConfig();

            //Makes Sure that the killer is a player
            if(e.getEntity().getPlayer().getKiller() instanceof Player) {
                Player k = e.getEntity().getPlayer().getKiller();
                PlayerData killer = new PlayerData(k.getUniqueId());

                String dm5 = settings.getConfig().getString("DeathMessages.Player");
                String dm6 = dm5.replace("%player%", p.getName()).replace("%killer%", k.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', dm6));

                killer.addKills(1);
                killer.addKillstreak(1);
                killer.addCoins(settings.getConfig().getInt("CoinsPerKill"));
                killer.savePlayerConfig();

                // Checks if the killer is on a killstreak of 3 or more
                if(killer.getKillstreak() >= 3) {
                    // Announces that they are on a killstreak
                    String ksMessage = settings.getConfig().getString("Messages.Killstreak");
                    String ksmessage = ksMessage.replace("%player%", k.getName()).replace("%killstreak%", killer.getKillstreak() + "");
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ksmessage));

                    // Gives them bonus coins for their killstreak
                    int ksBonus = (int) (killer.getKillstreak() / 3); // casting and int to a double rounds it down
                    killer.addCoins(settings.getConfig().getInt("CoinsPerKill") + ksBonus);
                    killer.savePlayerConfig();
                }

            }

        }

    }

}
