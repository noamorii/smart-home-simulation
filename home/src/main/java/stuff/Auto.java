package stuff;

import creatures.entities.people.Person;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.devices.StuffType;
import stuff.state.UsingState;

/**
 * Class representing an auto.
 */
public class Auto extends UsableObject implements Transport{

    private static final int USING_TICKS = 6;
    private static final int RESTING_ELECTRICITY = 15;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    /**
     * Instantiates a new Auto.
     *
     * @param room   The room in which the auto is located
     */
    public Auto(Room room) {
        super(USING_TICKS, room, StuffType.AUTO, RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public void goOutFromHome(Person person) {

        if (person.getType().equals(CreaturesType.ADULT)) {
            setUsedTimes(getUsedTimes() + 1);
            setState(new UsingState(this));
            person.setUsingObject(this);
            home.goOut(person);
            System.out.println(person.getName() + " goes for food");
        } else {
            System.out.println("Children can not drive a car");
        }
    }

    @Override
    public void comeBackHome(Person person) {
        home.comeBackHome(person);
        System.out.println("I'm home!");
    }
}


