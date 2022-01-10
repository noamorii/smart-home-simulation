package util;

import creatures.entities.Creature;
import creatures.entities.animals.Pet;
import creatures.factories.CreaturesType;
import house.Floor;
import house.Home;
import stuff.UsableObject;
import stuff.devices.factory.DeviceFactory;
import stuff.observe.PositronicBrain;
import stuff.sport.factory.SportFactory;
import stuff.state.StateType;
import util.TimeRepresentation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Class representing a simulation.
 */
public class Simulation {

    private final TimeRepresentation time = new TimeRepresentation();
    
    private final int interactionsCount;
    private final String startingTime;

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
        FileWriter myWriter = new FileWriter("src/main/resources/Journal.txt");

        time.setTime(startingTime);

        for (int i = 0; i < interactionsCount; i++) {
            myWriter.write("_________________" + time.getCurrentTime() + "_________________" + "\n");


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
                    myWriter.write("creature " + creature.getType() + " with name: " + creature.getName() + " in room: " + creature.getCurrentRoom().getName()
                            + " using obj:" + creature.getCurrentObject().getType() + " object state:" + creature.getCurrentObject().getCurrentState().getType() +
                            " in room: " + creature.getCurrentObject().getCurrentRoom().getName() + " with tick " + creature.getCurrentActionProgress() +
                            " from device ticks " + creature.getCurrentObject().getTicks() + "\n");

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
            myWriter.write("_____________________________________________\n");
            myWriter.flush();
            time.increase();
            generateHomeConfigurationReport();
        }
    }

    /**
     * Generating a report with a home configuration.
     */
    private void generateHomeConfigurationReport() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/HomeConfiguration.txt");
        Home home = Home.getInstance();
        List<Floor> floors = home.getFloors();
        writer.write("In our Home by address " + home.getAddress() + " we have " + home.getFloors().size() + " floors\n");
        for (int i = 0; i < home.getFloors().size(); i++) {
            writer.write("On the " + floors.get(i).getLevel() + " floor we have " + floors.get(i).getRooms().size() + " rooms: \n");
            for (int j = 0; j < home.getFloors().get(i).getRooms().size(); j++){
                writer.write("In the " + home.getFloors().get(i).getRooms().get(j).getName() + " are: ");
                for (int p = 0; p < home.getFloors().get(i).getRooms().get(j).getStuff().size(); p++){
                    writer.write(  home.getFloors().get(i).getRooms().get(j).getStuff().get(p).getType() + " ");
                    if (p == home.getFloors().get(i).getRooms().get(j).getStuff().size() - 1){
                        writer.write("\n");
                    }
                }
            }
        }
        List<Creature> persons = Home.getCreatures().stream()
                .filter((s)->s.getMainCreatureType().equals(CreaturesType.PERSON)).collect(Collectors.toList());
        List<Creature> pets = Home.getCreatures().stream()
                .filter((s)->s.getMainCreatureType().equals(CreaturesType.PET)).collect(Collectors.toList());
        writer.write("In the house living " + persons.size() + " people, and " + pets.size() + " pets.\n");
        writer.write("People:\n");
        for (Creature person : persons) {
            writer.write(person.getName() + " " + person.getAge() + " years old.\n");

        }
        writer.write("Pets:\n");
        for (Creature pet : pets) {
            Pet animal = (Pet) pet;
            writer.write(animal.getBreed() + " " + animal.getName() + " " + animal.getAge() + " years old.\n");
        }
        writer.flush();
    }
}

