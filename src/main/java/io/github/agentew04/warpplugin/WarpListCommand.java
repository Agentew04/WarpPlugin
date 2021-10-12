package io.github.agentew04.warpplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class WarpListCommand implements CommandExecutor {
    private final Warpplugin main;
    public  WarpListCommand(Warpplugin main){
        this.main=main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> warps = main.getWarps();
        if(warps.size()==0){
            sender.sendMessage(ChatColor.GREEN+"Não existe nenhum warp!");
            return true;
        }
        if(warps.size()==1){
            sender.sendMessage(ChatColor.GREEN+"O único warp é: "+ ChatColor.YELLOW + warps.get(0));
            return true;
        }
        if(warps.size()==2){
            sender.sendMessage(ChatColor.GREEN+"Os únicos warps são: "+ ChatColor.YELLOW + warps.get(0)+
                    ChatColor.GREEN+" e "+ChatColor.YELLOW+warps.get(1)+ChatColor.GREEN+".");
            return true;
        }
        String message = ChatColor.GREEN+"Os warps existentes são: "+ChatColor.YELLOW+warps.get(0);
        for (int i = 1; i < warps.size()-2; i++) {
            message+=ChatColor.GREEN+", "+ChatColor.YELLOW+warps.get(i);
        }
        message+=ChatColor.GREEN+" e "+ChatColor.YELLOW+warps.get(warps.size()-1)+ChatColor.GREEN+".";
        sender.sendMessage(message);
        return true;
    }
}
