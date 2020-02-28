package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetStartLevel implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if no arguments.
        if(args.length == 0)
        {
            ChatUtils.chat(sender, settings.getMessage("SetStartLevelUsage"));
            return true;
        }

        settings.setStartLevel(Integer.parseInt(args[0]));
        ChatUtils.chat(sender, settings.getMessage("StartLevelSet"));

        return true;
    }
}
