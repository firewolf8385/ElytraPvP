package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Return if sender is not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, settings.getMessage("MustBePlayer"));
            return true;
        }

        // Return if spawn is not set.
        if(!settings.isSpawnSet())
        {
            ChatUtils.chat(sender,settings.getMessage("SpawnNotSet"));
            return true;
        }

        Player p = (Player) sender;
        p.teleport(settings.getSpawn());

        return true;
    }

}