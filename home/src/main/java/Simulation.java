import creatures.entities.Creature;
import house.Home;
import stuff.observe.PositronicBrain;
import util.TimeRepresentation;

import java.util.List;

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

            List<Creature> creatures = List.copyOf(Home.getCreatures());

            for (Creature creature: creatures) {
                if (creature.getCurrentObject() == null ||
                    creature.getCurrentActionProgress() == creature.getCurrentObject().getTicks()) {
                    if (creature.getCurrentObject() != null) creature.stopCurrentAction();
                    creature.findActivity();
                } else {
                    creature.increaseProgress();
                }

                if (creature.getCurrentObject() != null) {
                    System.out.println("-------creature " + creature.getType() + " with name: " + creature.getName()
                            + " using obj:" + creature.getCurrentObject().getType() + " object state:" + creature.getCurrentObject().getCurrentState().getType() + " with tick " + creature.getCurrentActionProgress() +
                            " from device ticks " + creature.getCurrentObject().getTicks()) ;
                }
            }
            if (time.getCurrentTime().equals("Time: 00:00")){
                PositronicBrain.getInstance().generateReportAboutElectricityUsedByDay();
            }

            System.out.println("_____________________________________________");
            time.increase();
        }
    }
}

