import creatures.entities.Creature;
import house.Home;
import stuff.UsableObject;
import stuff.devices.factory.DeviceFactory;
import stuff.observe.PositronicBrain;
import stuff.sport.factory.SportFactory;
import stuff.state.StateType;
import util.TimeRepresentation;

import java.util.List;
import java.util.stream.Collectors;

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
                    System.out.println("-------creature " + creature.getType() + " with name: " + creature.getName() + " in room: " + creature.getCurrentRoom().getName()
                            + " using obj:" + creature.getCurrentObject().getType() + " object state:" + creature.getCurrentObject().getCurrentState().getType() +
                            " in room: " + creature.getCurrentObject().getCurrentRoom().getName() + " with tick " + creature.getCurrentActionProgress() +
                            " from device ticks " + creature.getCurrentObject().getTicks()) ;
                }
            }

            List<UsableObject> usableObjects= DeviceFactory.getInstance().getDevices().stream()
                    .filter((d) -> d.getCurrentState()
                            .getType().equals(StateType.RESTING))
                    .collect(Collectors.toList());
            usableObjects.addAll(SportFactory.getInstance().getSports().stream().filter((s)->s.getCurrentState()
                    .getType().equals(StateType.RESTING))
                    .collect(Collectors.toList()));
            for (UsableObject usableObject: usableObjects) {
                usableObject.usingElectricity();
            }

            if (time.getCurrentTime().equals("Time: 00:00")){
                PositronicBrain.getInstance().generateReportAboutElectricityUsedByDay();
            }

            System.out.println("_____________________________________________");
            time.increase();
        }
    }
}

