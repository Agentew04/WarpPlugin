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
            if(args!=null && args.length==1){
                Player player = (Player) sender;
                Location loc = main.getWarp(args[0]);
                if(loc==null){
                    sender.sendMessage(ChatColor.RED+"Esse warp não existe!");
                    return true;
                }
                player.teleport(loc);
                player.sendMessage(ChatColor.GREEN+"Você foi teleportado com sucesso para: "+ChatColor.YELLOW+args[0]);
                return true;
            }else{
                sender.sendMessage(ChatColor.RED+"Poucos ou argumentos demais!");
                return false;
            }
        }else{
            sender.sendMessage(ChatColor.RED+"Apenas players ingame podem usar esse comando!");
            return true;
        }
    }
}
