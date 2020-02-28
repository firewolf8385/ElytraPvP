package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Enable implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if already enabled.
        if(settings.isEnabled())
        {
            ChatUtils.chat(sender, settings.getMessage("PluginAlreadyEnabled"));
            return true;
        }

        // Exit if spawn not set.
        if(!settings.isSpawnSet())
        {
            ChatUtils.chat(sender, settings.getMessage("SpawnNotSet"));
            return true;
        }

        // Exit if start level not set.
        if(settings.getStartLevel() == 0)
        {
            ChatUtils.chat(sender, settings.getMessage("StartLevelNotSet"));
            return true;
        }

        settings.setEnabled(true);
        ChatUtils.chat(sender, settings.getMessage("PluginEnabled"));

        return true;
    }

}
