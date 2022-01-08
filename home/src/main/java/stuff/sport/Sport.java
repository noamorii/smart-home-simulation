package stuff.sport;

import house.Room;
import stuff.UsableObject;
import stuff.sport.factory.SportType;

public abstract class Sport extends UsableObject{

    SportType type;

    public Sport(int usingTicks, Room room, SportType type){
        super(usingTicks, room);
        this.type = type;
    }

}
