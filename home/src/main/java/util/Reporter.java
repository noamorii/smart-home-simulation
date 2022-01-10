package util;

import creatures.entities.Creature;
import creatures.entities.animals.Pet;
import creatures.entities.people.Person;
import creatures.factories.PeopleFactory;
import creatures.factories.PetFactory;
import house.Floor;
import house.Home;
import stuff.UsableObject;
import stuff.devices.factory.DeviceFactory;
import stuff.sport.factory.SportFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reporter {

    private final FileWriter electricity_report = new FileWriter("src/main/resources/Report.txt");
    private final FileWriter journal = new FileWriter("src/main/resources/Journal.txt");
    private final FileWriter writer = new FileWriter("src/main/resources/HomeConfiguration.txt");

    public Reporter() throws IOException {
    }

    public List<UsableObject> getAllUsableObjects() {

        List<UsableObject> objects = new ArrayList<>();

        objects.addAll(DeviceFactory.getInstance().getDevices());
        objects.addAll(SportFactory.getInstance().getSports());

        return objects;
    }

    /**
     * Generates a report on the electricity used for the day
     *
     */
    public void generateReportAboutElectricityUsedByDay(int day) throws IOException {


        int allElectricity = 0;

        electricity_report.write("_________________ Report for the " + day + " day _________________\n");
        for (UsableObject obj : getAllUsableObjects()) {
            allElectricity += obj.getElectricityUsed();
            electricity_report.write(obj.getType() + " has used " + obj.getElectricityUsed() + " electricity for today. " +
                    "Was used " + obj.getUsedTimes() + " times. " +
                    "Was broken " + obj.getBrokenTimes() + " times.\n");
            obj.resetElectricity();
            obj.resetUsedTimes();
            obj.resetBrokenTimes();
        }
        electricity_report.write("On " + Home.getInstance().getAuto().getType() + " Adults go for food " + Home.getInstance().getAuto().getUsedTimes() + " times \n");
        electricity_report.write("All electricity used by day: " + allElectricity + "\n");
        electricity_report.flush();
        Home.getInstance().getAuto().setUsedTimes(0);
    }

    /**
     * Generating a report with a home configuration.
     */
    void generateHomeConfigurationReport() throws IOException {


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

        List<Person> persons = PeopleFactory.getInstance().getPeople();
        List<Pet> pets = PetFactory.getInstance().getPets();

        writer.write("In the house living " + persons.size() + " people, and " + pets.size() + " pets.\n");
        writer.write("People:\n");
        for (Person person : persons) {
            writer.write(person.getName() + " " + person.getAge() + " years old.\n");
        }
        writer.write("Pets:\n");
        for (Pet pet : pets) {
            writer.write(pet.getBreed() + " " + pet.getName() + " " + pet.getAge() + " years old.\n");
        }
        writer.flush();
    }

    void startJournal(TimeRepresentation time) throws IOException {
        journal.write("_________________" + time.getCurrentTime() + "_________________" + "\n");
    }

    void generateJournal(Creature creature) throws IOException {
        journal.write("creature " + creature.getType() + " with name: " + creature.getName() + " in room: " + creature.getCurrentRoom().getName()
                + " using obj:" + creature.getCurrentObject().getType() + " object state:" + creature.getCurrentObject().getCurrentState().getType() +
                " in room: " + creature.getCurrentObject().getCurrentRoom().getName() + " with tick " + creature.getCurrentActionProgress() +
                " from device ticks " + creature.getCurrentObject().getTicks() + "\n");
    }

    void endLifeJournal() throws IOException {
        journal.write("_____________________________________________\n");
        journal.flush();
    }
}
