
import house.Home;
import house.Room;
import util.Config;
import util.Simulation;

public class Main {

    public static void main(String[] args) throws Exception {

        Config config = new Config();
        config.configureHouse("configuration2.json");
        Simulation simulation = config.getSimulation();
        simulation.run();
    }
}