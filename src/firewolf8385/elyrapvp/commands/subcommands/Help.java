package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lElytraPvP Help &a[1/1]");
        ChatUtils.chat(sender, "  &8» &a/ep admin &8- &fElytraPvP admin commands.");
        ChatUtils.chat(sender, "  &8» &a/ep disable &8- &fDisable the plugin.");
        ChatUtils.chat(sender, "  &8» &a/ep enable &8- &fEnable the plugin.");
        ChatUtils.chat(sender, "  &8» &a/ep info &8- &fShow plugin information.");
        ChatUtils.chat(sender, "  &8» &a/ep setspawn &8- &fSet the spawn.");
        ChatUtils.chat(sender, "  &8» &a/ep setstartlevel [y-level] &8- &fSet start level.");
        ChatUtils.chat(sender, "  &8» &a/ep spawn &8- &fTeleport to spawn.");
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");

        return true;
    }

}