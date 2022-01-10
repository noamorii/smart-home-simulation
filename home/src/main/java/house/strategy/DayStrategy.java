package house.strategy;

import creatures.entities.animals.Pet;
import creatures.entities.people.Person;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.observe.PositronicBrain;

public class DayStrategy implements Strategy {

    @Override
    public void findActivity(Person person) {

        UsableObject stuff;

        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        boolean doSport = person.flipCoin(); //choose sport or devices

        if (!doSport) {
            stuff = positronicBrain.adviceDeviceFor(person); // ask smart home for free device
        } else {
            stuff = PositronicBrain.getInstance().getRandomFreeSport(); // ask smart home for free sport staff
        }
        person.useStuff(stuff);
    }

    @Override
    public void findActivity(Pet pet) {
        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        Device device = positronicBrain.adviceDeviceFor(pet);
        pet.useStuff(device);
        pet.increaseHungerLevel();
    }
}
