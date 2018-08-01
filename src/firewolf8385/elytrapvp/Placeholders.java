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

            switch(player.getKit()){
                case 1:
                    return "Sniper";
                case 2:
                    return "Knight";
                case 3:
                    return "Pyro";
                case 4:
                    return "Tank";
                case 5:
                    return "Chemist";
                case 6:
                    return "Stickman";
                case 7:
                    return "Bomber";
                case 8:
                    return "Healer";
                case 9:
                    return "Teleporter";
                case 10:
                    return "Spectral";
                case 11:
                    return "Puncher";
                default:
                    return "None";
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
