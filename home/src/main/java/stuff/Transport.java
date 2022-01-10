package stuff;

import creatures.entities.people.Person;
import house.Home;

import java.io.IOException;

/**
 * Interface for objects capable of leaving the house.
 */
public interface Transport {

    /**
     * Method to leave home.
     *
     * @param person            The person who leaves the house in transport
     */
    void goOutFromHome(Person person) throws IOException;

    Home home = Home.getInstance();

    /**
     * Method to returning at home.
     *
     * @param person               The person who will return home by transport
     */
    void comeBackHome(Person person);
}
