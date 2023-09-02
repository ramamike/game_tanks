package org.ramamike.game.utils;

public class Time {
    public static final long SECOND = 1000_000_000L;

    public static long get() {
        return System.nanoTime();
    }
}
