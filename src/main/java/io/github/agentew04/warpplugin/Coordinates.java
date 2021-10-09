package io.github.agentew04.warpplugin;

public class Coordinates {
    public final int x;
    public final int y;
    public final int z;
    public static final Coordinates zero = new Coordinates(0,62,0);
    public Coordinates(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

}
