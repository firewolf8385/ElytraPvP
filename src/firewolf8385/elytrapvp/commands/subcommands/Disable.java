package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Disable implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if already disabled.
        if(!settings.isEnabled())
        {
            ChatUtils.chat(sender, settings.getMessage("PluginAlreadyDisabled"));
            return true;
        }

        settings.setEnabled(false);
        ChatUtils.chat(sender, settings.getMessage("PluginDisabled"));

        return true;
    }

}
