package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.ElytraPvP;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Info implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lElytraPvP");
        ChatUtils.chat(sender, "  &8» &aVersion &8- &f" + ElytraPvP.getPlugin().getDescription().getVersion());
        ChatUtils.chat(sender, "  &8» &aAuthor &8- &fpartykid4");
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        return true;
    }
}