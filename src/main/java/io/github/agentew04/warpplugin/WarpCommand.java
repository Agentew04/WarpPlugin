package io.github.agentew04.warpplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    private final Warpplugin main;
    public  WarpCommand(Warpplugin main){
        this.main=main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args!=null && args.length>=1){
                Player player = (Player) sender;
                Coordinates c = main.getCoords(args[0]);
                player.teleport(new Location(player.getWorld(),c.x,c.y,c.z));
                player.sendMessage(ChatColor.GREEN+"Teleportado com sucesso!");
                return true;
            }
        }
        return false;
    }
}
