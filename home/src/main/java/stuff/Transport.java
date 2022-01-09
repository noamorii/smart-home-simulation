package stuff;

import creatures.entities.people.Person;
import house.Home;

public interface Transport {

    Home home = Home.getInstance();

    void goOutFromHome(Person person);

    void comeBackHome(Person person);
}
