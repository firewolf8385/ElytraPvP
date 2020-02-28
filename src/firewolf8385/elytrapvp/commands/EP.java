package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.commands.subcommands.*;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class EP implements CommandExecutor
{
    private Settings settings = Settings.getInstance();
    private Admin admin;
    private Disable disable;
    private Enable enable;
    private Help help;
    private Info info;
    private SetSpawn setSpawn;
    private SetStartLevel setStartLevel;
    private Spawn spawn;

    public EP()
    {
        this.admin = new Admin();
        this.disable = new Disable();
        this.enable = new Enable();
        this.help = new Help();
        this.info = new Info();
        this.setSpawn = new SetSpawn();
        this.setStartLevel = new SetStartLevel();
        this.spawn = new Spawn();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if no arguments.
        if(args.length == 0)
        {
            info.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
            return true;
        }

        // Exit if no permission.
        if(!sender.hasPermission("ep.admin"))
        {
            ChatUtils.chat(sender, settings.getMessage("NoPermission"));
            return true;
        }

        switch(args[0])
        {
            case "admin":
                admin.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                break;
            case "disable":
                disable.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
                break;

            case "enable":
                enable.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
                break;

            case "info":
                info.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
                break;

            case "setspawn":
                setSpawn.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                break;

            case "setstartlevel":
                setStartLevel.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                break;

            case "spawn":
                spawn.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
                break;

            default:
                help.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
                break;
        }

        return true;
    }

}
