package io.github.agentew04.warpplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Warpplugin extends JavaPlugin {

    public FileConfiguration config;
    @Override
    public void onEnable() {

        //commands
        this.getCommand("warp").setExecutor(new WarpCommand(this));

        //default values
        config = this.getConfig();
        config.addDefault("warps.zero.x",0);
        config.addDefault("warps.zero.y",62);
        config.addDefault("warps.zero.z",0);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setCoords(String name, Coordinates coord){
        config.set("warps."+name+"x",coord.x);
        config.set("warps."+name+"y",coord.y);
        config.set("warps."+name+"z",coord.z);
    }
    public Coordinates getCoords(String name){
        if(config.isSet("warps."+name+"x")){
            int x = config.getInt("warps."+name+"x");
            int y = config.getInt("warps."+name+"y");
            int z = config.getInt("warps."+name+"z");
            return new Coordinates(x,y,z);
        }else{
            return Coordinates.zero;
        }
    }
}

