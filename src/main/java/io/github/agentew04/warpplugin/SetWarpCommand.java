package io.github.agentew04.warpplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class SetWarpCommand implements CommandExecutor {
    private final Warpplugin main;
    public SetWarpCommand(Warpplugin main){
        this.main=main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args!=null && args.length>=1){
                Player player = (Player)sender;
                main.setCoords(args[0],new Coordinates(player.getLocation().getBlockX(),
                        player.getLocation().getBlockY(),
                        player.getLocation().getBlockZ()));
                player.sendMessage(ChatColor.GREEN +"Warp setado com sucesso!");
            }
        }
        return false;
    }
}
