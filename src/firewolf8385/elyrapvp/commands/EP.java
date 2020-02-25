package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class EP implements CommandExecutor
{
    private Disable disable;
    private Enable enable;
    private Help help;
    private Info info;
    private SetSpawn setSpawn;
    private SetStartLevel setStartLevel;
    private Spawn spawn;

    public EP()
    {
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

        switch(args[0])
        {
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
