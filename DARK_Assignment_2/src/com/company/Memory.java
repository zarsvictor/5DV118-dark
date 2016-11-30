package com.company;

/**
 * Created by Victor on 2016-11-27.
 * A simulated memory class. Handles the memory for our simulator.
 */
public class Memory {

    protected long[] memory;
    protected long size;
    protected long start;
    protected long currentLocation;

    /**
     * Size in bytes (divisible by 4 so word aligned)
     */
    public Memory(int size, int start){
        memory = new long[(size/4)];
        this.size = size/4;
        this.start = start;
        this.currentLocation = start;
    }

    public long get(int loc) {
        return memory[loc];
    }
}
