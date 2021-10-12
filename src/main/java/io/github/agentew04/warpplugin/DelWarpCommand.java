package io.github.agentew04.warpplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelWarpCommand implements CommandExecutor {

    private final Warpplugin main;
    public DelWarpCommand(Warpplugin main){
        this.main=main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args!=null && args.length==1){
            main.delWarp(args[0]);
            sender.sendMessage(ChatColor.GREEN+"O warp "+ChatColor.YELLOW+args[0]+ChatColor.GREEN+" foi removido com sucesso!");
            return true;
        }else{
            sender.sendMessage(ChatColor.RED+"Poucos ou argumentos demais!");
            return false;
        }
    }
}
