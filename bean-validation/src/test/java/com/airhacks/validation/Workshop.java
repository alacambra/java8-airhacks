package com.airhacks.validation;

/**
 *
 * @author airhacks.com
 */
@Prerequisites("(workshop.getNumberOfAttendees() == workshop.getCoffeeVolume())\n"
        + "                && (workshop.getNumberOfAttendees() < workshop.getRoomSize())\n"
        + "                && workshop.isBeamerExist()")
public class Workshop {

    private int numberOfAttendees;
    private int coffeeVolume;
    private boolean beamerExist;
    private int roomSize;

    public Workshop(int numberOfAttendees, int coffeeVolume, boolean beamerExist, int roomSize) {
        this.numberOfAttendees = numberOfAttendees;
        this.coffeeVolume = coffeeVolume;
        this.beamerExist = beamerExist;
        this.roomSize = roomSize;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public int getCoffeeVolume() {
        return coffeeVolume;
    }

    public boolean isBeamerExist() {
        return beamerExist;
    }

    public int getRoomSize() {
        return roomSize;
    }

}
