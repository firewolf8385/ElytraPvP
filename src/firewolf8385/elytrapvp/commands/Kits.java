package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.inventories.KitsGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kits implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;

        KitsGUI.view(p);

        return true;
    }

}