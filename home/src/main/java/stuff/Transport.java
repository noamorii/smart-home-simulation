package stuff;

import creatures.entities.people.Person;
import house.Home;

import java.io.IOException;

public interface Transport {

    void goOutFromHome(Person person) throws IOException;

    Home home = Home.getInstance();

    void comeBackHome(Person person);
}
