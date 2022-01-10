package util;

import creatures.entities.Creature;
import house.Home;
import house.strategy.DayStrategy;
import house.strategy.NightStrategy;
import house.strategy.Strategy;
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
    private Strategy strategy;


    /**
     * Simulation constructor
     *
     * @param interactionsCount number of ten minute ticks
     * @param startingTime      simulation start time
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

            if (time.isNight()) {
                strategy = new NightStrategy();
            } else {
                strategy = new DayStrategy();
            }

            List<Creature> creatures = List.copyOf(Home.getCreatures());
            reporter.startJournal(time);
            for (Creature creature : creatures) {
                creature.setStrategy(strategy);
                if (creature.getCurrentObject() == null ||
                        creature.getCurrentActionProgress() == creature.getCurrentObject().getTicks()) {
                    if (creature.getCurrentObject() != null) creature.stopCurrentAction();
                    creature.findActivity();
                } else {
                    creature.increaseProgress();
                }
                reporter.generateJournal(creature);

            }
            reporter.endLifeJournal();

            for (UsableObject usableObject : reporter.getAllUsableObjects()) {
                usableObject.usingElectricity();
            }
            if (time.isMidNight()) reporter.generateReportAboutElectricityUsedByDay(time.getCurrentDay() - 1);
            time.increase();
        }
        reporter.generateHomeConfigurationReport();
    }
}

