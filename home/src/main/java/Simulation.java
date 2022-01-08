import creatures.entities.Creature;
import house.Home;
import util.TimeRepresentation;

public class Simulation {
    
    private final Home home = Home.getInstance();
    private final TimeRepresentation time = new TimeRepresentation();
    
    private final int interactionsCount;
    private final String startingTime;

    public Simulation(int interactionsCount, String startingTime) {
        this.interactionsCount = interactionsCount;
        this.startingTime = startingTime;
    }

    public void run() {

        time.setTime(startingTime);

        for (int i = 0; i < interactionsCount; i++) {
            System.out.println("_________________" + time.getCurrentTime() + "_________________");

            for (Creature creature: Home.getCreatures()) {
                if (creature.getCurrentActionProgress() == 0) {
                    creature.findActivity();
                }
            }

            System.out.println("_____________________________________________");
            time.increase();
        }
    }
}

