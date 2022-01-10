import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import creatures.factories.PeopleFactory;
import creatures.factories.PetFactory;
import house.Floor;
import house.Home;
import house.Room;
import house.RoomFactory;
import stuff.Auto;
import stuff.devices.Device;
import stuff.devices.StuffType;
import stuff.devices.factory.DeviceFactory;
import stuff.observe.PositronicBrain;
import stuff.sport.Sport;
import stuff.sport.factory.SportFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

                            /* test configuration*/

        RoomFactory roomFactory = new RoomFactory();
        Room hallway = roomFactory.create("Hallway");
        Room garage = roomFactory.create("Garage");
        Room kitchen = roomFactory.create("Kitchen");
        Room bedroom = roomFactory.create("Children's bedroom");
        Room bedroom2 = roomFactory.create("Parents' bedroom");
        Room livingRoom = roomFactory.create("Living room");

        List<Room> roomsForFirstFloor = Arrays.asList(hallway, kitchen, garage);
        List<Room> roomsForSecondFloor = Arrays.asList(bedroom, bedroom2, livingRoom);

        PetFactory petFactory = new PetFactory();
        PeopleFactory peopleFactory = new PeopleFactory();
        peopleFactory.create(CreaturesType.ADULT, "Papa", 40, bedroom);
        peopleFactory.create(CreaturesType.ADULT, "Mama", 35, bedroom2);
        peopleFactory.create(CreaturesType.CHILD, "Pepa", 14, hallway);
        peopleFactory.create(CreaturesType.CHILD, "George", 9, bedroom);
        petFactory.create(CreaturesType.CAT, "Fluffy", 2, "Persian cat", livingRoom);
        petFactory.create(CreaturesType.PARROT, "Popka", 1, "Ara parrot", livingRoom);
        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(peopleFactory.getPeople());
        creatures.addAll(petFactory.getPets());


        DeviceFactory deviceFactory = DeviceFactory.getInstance();
        Device fridge = deviceFactory.createDevice(kitchen, StuffType.FRIDGE);
        Device airConditioner = deviceFactory.createDevice(hallway,StuffType.CONDITIONER);
        Device audioSystem = deviceFactory.createDevice(livingRoom,StuffType.AUDIO_SYSTEM);
        Device computer = deviceFactory.createDevice(bedroom,StuffType.COMPUTER);
        Device computer1 = deviceFactory.createDevice(bedroom2,StuffType.COMPUTER);
        Device petFeeder = deviceFactory.createDevice(hallway,StuffType.PET_FEEDER);
        Device smartPhone1 = deviceFactory.createDevice(bedroom,StuffType.PHONE);
        Device smartPhone2 = deviceFactory.createDevice(bedroom2,StuffType.PHONE);
        Device smartPhone3 = deviceFactory.createDevice(livingRoom,StuffType.PHONE);
        Device smartVacuum = deviceFactory.createDevice(hallway,StuffType.VACUUM);
        Device pet_toy = deviceFactory.createDevice(hallway,StuffType.PET_TOY);
        Device tv = deviceFactory.createDevice(kitchen,StuffType.TV);
        Device tv2 = deviceFactory.createDevice(bedroom, StuffType.TV);


        SportFactory sportFactory = SportFactory.getInstance();
        Sport bike1 = sportFactory.createSport(garage, StuffType.BIKE);
        Sport bike2 = sportFactory.createSport(garage, StuffType.BIKE);
        Sport treadmill1 = sportFactory.createSport(garage, StuffType.TREADMILL);
        Sport treadmill2 = sportFactory.createSport(garage, StuffType.TREADMILL);
        Sport orbitek = sportFactory.createSport(garage, StuffType.ORBITREK);
        Sport stepper = sportFactory.createSport(garage, StuffType.TREADMILL);

        hallway.setStuff(Arrays.asList(smartVacuum, petFeeder, airConditioner, pet_toy));
        bedroom.setStuff(Arrays.asList(computer, smartPhone1, tv2));
        bedroom2.setStuff(Arrays.asList(smartPhone2, computer1));
        livingRoom.setStuff(Arrays.asList(audioSystem,smartPhone3));
        kitchen.setStuff(Arrays.asList(fridge, tv));
        garage.setStuff(Arrays.asList(bike1, bike2, treadmill1, treadmill2, orbitek, stepper));

        Floor firstFloor = new Floor(1, roomsForFirstFloor);
        Floor secondFloor = new Floor(2, roomsForSecondFloor);
        List<Floor> floors = new ArrayList<>();
        floors.add(firstFloor);
        floors.add(secondFloor);

        Auto auto = new Auto(garage);

        Home.HomeBuilder home = Home.newBuilder();
        Home house = home.address("Revolution 550/1")
                .addFloors(floors).addCreatures(creatures).addAuto(auto).build();

        Simulation simulation = new Simulation(1008, "8:00");
        simulation.run();
    }
}