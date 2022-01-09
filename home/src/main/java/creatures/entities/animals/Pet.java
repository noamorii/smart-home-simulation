package creatures.entities.animals;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

public abstract class Pet implements Creature {

    private final String nickname, breed;
    private final int age;
    private final CreaturesType type;
    private Room room;

    private int hungerLevel = 0;
    private int currentActionProgress = 1;
    private UsableObject usingObject = null;

    public Pet(String nickname, String breed, int age, CreaturesType type, Room room) {
        this.nickname = nickname;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.room = room;
    }

    @Override
    public abstract void say();

    public void moveTo(Room room) {
        this.room = room;
    }

    @Override
    public void brakeStuff(UsableObject usableObject) {
    }

    @Override
    public void useStuff(UsableObject usableObject) {
    }

    public void stopCurrentAction() {
        currentActionProgress = 1;
    }

    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    public void increaseHungerLevel() {
        if (hungerLevel < 10) hungerLevel++;
    }

    public boolean isHungry() {
        return hungerLevel >= 8;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void resetHungerLevel() {
        hungerLevel = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public CreaturesType getType() {
        return type;
    }

    public Room getCurrentRoom() {
        return room;
    }

    @Override
    public UsableObject getCurrentObject() {
        return usingObject;
    }

    @Override
    public void increaseProgress() {
        currentActionProgress++;
    }

    @Override
    public String getName() {
        return nickname;
    }

    @Override
    public CreaturesType getMainCreatureType() {
        return CreaturesType.PET;
    }

    @Override
    public void findActivity() {
    }
}

