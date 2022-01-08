package stuff;

import creatures.entities.people.Adult;
import house.Home;
import house.Room;
import stuff.devices.StuffType;

public class Auto extends UsableObject {

    private static final int USING_TICKS = 6;
    private static final int RESTING_ELECTRICITY = 15;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    public Auto(Room room) {
        super(USING_TICKS, room, StuffType.AUTO, RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }



    public void goForFood(Adult adult){
        Home home = Home.getInstance();
        home.goOut(adult);
        System.out.println(adult.getName() + " goes for food");
        //какое-то время спустя
        home.comeBackHome(adult);

    }
}


