package stuff;

import creatures.entities.people.Person;
import creatures.factories.CreaturesType;
import house.Home;
import house.Room;
import stuff.devices.StuffType;

public class Auto extends UsableObject implements Transport{

    private static final int USING_TICKS = 6;
    private static final int RESTING_ELECTRICITY = 15;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    public Auto(Room room) {
        super(USING_TICKS, room, StuffType.AUTO, RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public void goOutFromHome(Person person) {
        if (person.getType().equals(CreaturesType.ADULT)) {
            Home home = Home.getInstance();
            home.goOut(person);
            System.out.println(person.getName() + " goes for food");
            //какое-то время спустя
            home.comeBackHome(person);
        } else {
            System.out.println("Children can not drive a car");
        }

    }
}


