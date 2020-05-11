package com.crazyores.item;

import net.minecraft.util.IStringSerializable;

public enum LuminiteColor implements IStringSerializable {
    WHITE(0, "white"),
    RED(1, "red"),
    ORANGE(2, "orange"),
    YELLOW(3, "yellow"),
    GREEN(4, "green"),
    CYAN(5, "cyan"),
    BLUE(6, "blue"),
    PURPLE(7, "purple"),
    PINK(8, "pink"),
    BLACK(9, "black");

    private final int id;
    private final String name;

    private LuminiteColor(int id, String key) {
        this.id = id;
        this.name = key;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
