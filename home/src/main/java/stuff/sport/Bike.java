package stuff.sport;

import creatures.entities.people.Person;
import house.Room;
import stuff.Transport;
import stuff.devices.StuffType;
import stuff.state.BrokenState;
import stuff.state.UsingState;

import java.io.IOException;
import java.util.Random;

public class Bike extends Sport implements Transport{

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 6;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    /**
     * Instantiates a Bike.
     *
     * @param room          the location
     */
    public Bike(Room room) {
        super(USING_TICKS, room, StuffType.BIKE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public void goOutFromHome(Person person) throws IOException {
        setState(new UsingState(this));
        home.goOut(person);
        System.out.println(person.getName() + " is going to ride a bike");
        int breakChance = new Random().nextInt(5);
        if(breakChance > 2){
            System.out.println("Bike is broken");
            setState(new BrokenState(this));
            notifyObserver();
        }
    }

    @Override
    public void comeBackHome(Person person) {
        home.comeBackHome(person);
        System.out.println("I'm home!");
    }
}
