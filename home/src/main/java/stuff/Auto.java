package stuff;

import creatures.entities.people.Adult;
import house.Home;
import house.Room;
import stuff.devices.StuffType;

public class Auto extends UsableObject {

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 15;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    protected Auto(int usingTicks, Room room) {
        super(usingTicks, room, StuffType.AUTO, RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    public void goForFood(Adult adult){
        Home.getCreatures().remove(adult);
        System.out.println("go for food");
        returnAtHome(adult);
        //какое-то время спустя
    }

    private void returnAtHome(Adult adult){
        Home.getCreatures().add(adult);
    }
}


