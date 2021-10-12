package io.github.agentew04.warpplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Warpplugin extends JavaPlugin {

    public FileConfiguration config;
    @Override
    public void onEnable() {

        //commands
        this.getCommand("warp").setExecutor(new WarpCommand(this));
        this.getCommand("setwarp").setExecutor(new SetWarpCommand(this));
        this.getCommand("delwarp").setExecutor(new DelWarpCommand(this));
        this.getCommand("warplist").setExecutor(new WarpListCommand(this));

        this.config=getConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.saveConfig();
    }

    public void setWarp(String name, Location location){
        config.set("warps."+name,location);
        List<String> warps =  config.getStringList("warplist");
        if(!warps.contains(name)){
            warps.add(name);
            config.set("warplist",warps);
        }
        this.saveConfig();

    }
    public List<String> getWarps(){
        return config.getStringList("warplist");
    }
    public Location getWarp(String name){
        if(config.isSet("warps."+name)){
            //exists
            return config.getLocation("warps."+name);
        }else{
            //doesn't exist
            return null;
        }
    }
    public void delWarp(String name){
        config.set("warps."+name,null);
        List<String> list = config.getStringList("warplist");
        list.remove(name);
        config.set("warplist",list);
        this.saveConfig();

    }
}

