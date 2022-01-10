package creatures.entities;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

import java.io.IOException;
import java.util.Random;

public interface Creature {

    Random rand = new Random();

    /**
     * constant variables for creatures
     */
    int MAX_HUNGRY_LEVEL = 10;
    int DEFAULT_HUNGRY_LEVEL = 0;
    int MAX_PERCENT_CHANCE = 100;
    int STARTING_ACTION_ITERATION = 1;

    void say();

    /**
     * The creature moves to the room specified in the parameter.
     *
     * @param room                 the room the creature will go to
     */
    void moveTo(Room room);

    /**
     * Method that realizes the chance of object breakage.
     *
     * @param usableObject             the object that can be broken
     *
     * @return returns boolean if the object was broken
     */
    boolean chanceBrakeStuff(UsableObject usableObject) throws IOException;

    /**
     * Method that implements the use of the object by the creature.
     *
     * @param usableObject             the object to be used by the creature
     */
    void useStuff(UsableObject usableObject) throws IOException;

    /**
     *   Returns a specific type of creature.
     *
     * @return CreaturesType
     */
    CreaturesType getType();

    /**
     *   Returns the age of the creature.
     *
     * @return CreaturesType
     */
    int getAge();

    /**
     *   Returns the name of the creature.
     *
     * @return String
     */
    String getName();

    /**
     *   Returns the room the creature is currently in.
     *
     * @return Room
     */
    Room getCurrentRoom();

    /**
     *   Returns the main type of the creature. Could be PET or PERSON.
     *
     * @return CreaturesType
     */
    CreaturesType getMainCreatureType();

    /**
     *   Returns the progress stage of an action on an object.
     *
     * @return int
     */
    int getCurrentActionProgress();

    /**
     *   Returns the object the creature is currently using.
     *
     * @return UsableObject
     */
    UsableObject getCurrentObject();

    /**
     *   Method interrupts the current use of the object.
     */
    void stopCurrentAction();

    /**
     *  Method that helps a creature find something to do.
     */
    void findActivity() throws IOException;

    /**
     *   The creature performs the action for a certain number of ticks (time),
     *   the method increases the progress by one tick.
     */
    void increaseProgress();

    /**
     *  If there are no free objects for the creature to use, it waits for one iteration.
     */
    void waiting();

    /**
     *   Increases the starvation level of the creature.
     */
    void increaseHungerLevel();

    /**
     *   After eating, restores the level of hunger to the maximum.
     */
    void resetHungerLevel();
}
