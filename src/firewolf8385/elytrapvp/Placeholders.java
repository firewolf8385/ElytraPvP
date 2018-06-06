package firewolf8385.elytrapvp;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.external.EZPlaceholderHook;

public class Placeholders extends EZPlaceholderHook{

    private Main main;

    public Placeholders(Main main) {
        super(main, "ep");
        this.main = main;
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        PlayerData player = new PlayerData(p.getUniqueId());
        SettingsManager settings = SettingsManager.getInstance();

        if(identifier.equals("coins")) {
            return String.valueOf(player.getCoins());
        }

        if(identifier.equals("kills")) {
            return String.valueOf(player.getKills());
        }

        if(identifier.equals("deaths")) {
            return String.valueOf(player.getDeaths());
        }

        if(identifier.equals("killstreak")) {
            return String.valueOf(player.getKillstreak());
        }

        if(identifier.equals("kit")) {
            if(player.getKit() == 1) {
                return "Sniper";
            }
            else if(player.getKit() == 2) {
                return "Knight";
            }
            else if(player.getKit() == 3) {
                return "Pyro";
            }
            else if(player.getKit() == 4) {
                return "Tank";
            }
            else if(player.getKit() == 5) {
                return "Chemist";
            }
            else if(player.getKit() == 6) {
                return "Stickman";
            }
            else if(player.getKit() == 7) {
                return "Bomber";
            }
        }

        if(identifier.equals("enabled")) {
            if(settings.getConfig().getBoolean("Enabled")) {
                return "&atrue";
            }
            else {
                return "&cfalse";
            }
        }

        return null;
    }

}
