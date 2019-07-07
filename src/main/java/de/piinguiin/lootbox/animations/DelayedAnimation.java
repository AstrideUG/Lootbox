package de.piinguiin.lootbox.animations;

import org.bukkit.Location;

public abstract class DelayedAnimation {

    private final int periode;
    private int counter;
    protected int pointer;
    protected boolean allAtOnce;
    protected Location location;

    public DelayedAnimation(final Location location, final int periode, final boolean allAtOnce) {
        this.location = location;
        this.periode = periode;
        this.allAtOnce = allAtOnce;
        this.counter = 0;
        this.pointer = 0;
    }


    public void tick() {

        if (counter < periode) {
            counter++;
        } else {
            action();
            counter = 0;
        }

    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public abstract void action();

    public abstract void end();

}
