package creatures.entities;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

import java.util.Random;

public interface Creature {

    Random rand = new Random();

    int MAX_HUNGRY_LEVEL = 10;
    int DEFAULT_HUNGRY_LEVEL = 0;
    int MAX_PERCENT_CHANCE = 100;
    int STARTING_ACTION_ITERATION = 1;

    void say();

    void moveTo(Room room);

    boolean chanceBrakeStuff(UsableObject usableObject);

    void useStuff(UsableObject usableObject);

    CreaturesType getType();

    Room getCurrentRoom();

    CreaturesType getMainCreatureType();

    int getCurrentActionProgress();

    void stopCurrentAction();

    void findActivity();

    UsableObject getCurrentObject();

    void increaseProgress();

    String getName();

    void waiting();

    void increaseHungerLevel();

    void resetHungerLevel();
}
