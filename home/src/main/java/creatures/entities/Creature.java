package creatures.entities;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

public interface Creature {

    void say();

    void moveTo(Room room);

    void brakeStuff(UsableObject usableObject);

    void useStuff(UsableObject usableObject);

    CreaturesType getType();

    Room getCurrentRoom();

    CreaturesType getMainCreatureType();

    int getCurrentActionProgress();

    void stopCurrentAction();

    void findActivity();
}
