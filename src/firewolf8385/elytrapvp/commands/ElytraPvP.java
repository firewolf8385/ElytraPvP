package firewolf8385.elytrapvp.commands;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.elytrapvp.commands.subcommands.Disable;
import firewolf8385.elytrapvp.commands.subcommands.Enable;
import firewolf8385.elytrapvp.commands.subcommands.Help;
import firewolf8385.elytrapvp.commands.subcommands.Info;
import firewolf8385.elytrapvp.commands.subcommands.Givecoins;
import firewolf8385.elytrapvp.commands.subcommands.Setspawn;
import firewolf8385.elytrapvp.commands.subcommands.Setstartlevel;

public class ElytraPvP implements CommandExecutor{

    private Disable disable;
    private Enable enable;
    private Help help;
    private Info info;
    private Givecoins givecoins;
    private Setspawn setspawn;
    private Setstartlevel setstartlevel;

    public ElytraPvP() {
        this.disable = new Disable();
        this.enable = new Enable();
        this.help = new Help();
        this.info = new Info();
        this.givecoins = new Givecoins();
        this.setspawn = new Setspawn();
        this.setstartlevel = new Setstartlevel();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length >= 1) {

            switch (args[0].toLowerCase()) {
                case "disable":
                    this.disable.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "enable":
                    this.enable.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "givecoins":
                    this.givecoins.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "help":
                    this.help.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "info":
                    this.info.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "setspawn":
                    this.setspawn.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "setstartlevel":
                    this.setstartlevel.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
                default:
                    this.info.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
                    break;
            }

        }
        else {

        }


        return true;
    }

}
