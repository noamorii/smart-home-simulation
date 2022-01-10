package util;

import creatures.entities.Creature;
import house.Home;
import stuff.UsableObject;

import java.io.IOException;
import java.util.List;
/**
 * Class representing a simulation.
 */
public class Simulation {

    private final TimeRepresentation time = new TimeRepresentation();
    
    private final int interactionsCount;
    private final String startingTime;
    private final Reporter reporter = new Reporter();


    /**
     * Simulation constructor
     *
     * @param interactionsCount             number of ten minute ticks
     * @param startingTime                  simulation start time
     */
    public Simulation(int interactionsCount, String startingTime) throws IOException {
        this.interactionsCount = interactionsCount;
        this.startingTime = startingTime;
    }

    /**
     * Simulation start method and creating an action journal.
     */
    public void run() throws IOException {

        time.setTime(startingTime);

        for (int i = 0; i < interactionsCount; i++) {

            List<Creature> creatures = List.copyOf(Home.getCreatures());

            reporter.startJournal(time);
            for (Creature creature: creatures) {
                if (creature.getCurrentObject() == null ||
                    creature.getCurrentActionProgress() == creature.getCurrentObject().getTicks()) {
                    if (creature.getCurrentObject() != null) creature.stopCurrentAction();
                    creature.findActivity();
                } else {
                    creature.increaseProgress();
                } if (creature.getCurrentObject() != null) reporter.generateJournal(creature);
            }
            reporter.endLifeJournal();

            for (UsableObject usableObject: reporter.getAllUsableObjects()) {
                usableObject.usingElectricity();
            }

            if (time.isMidNight()) reporter.generateReportAboutElectricityUsedByDay(time.getCurrentDay() - 1);
            time.increase();
        } reporter.generateHomeConfigurationReport();
    }
}

