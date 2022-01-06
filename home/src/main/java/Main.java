import creatures.PeopleFactory;
import creatures.PetFactory;
import creatures.CreaturesType;
import creatures.entities.Creature;
import house.*;
import stuff.DeviceFactory;
import stuff.devices.Device;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {



//        for (int i = 0; i < 100; i++) {
//            papa.useStuff(fridge);
//            System.out.println(fridge.toString());
//        }


//        List<Device> devices = new ArrayList<>();
//        Room room = new Kitchen();
//        Device device1 = new Computer(room);
//        devices.add(device1);
//
//        CreatureFactory creatureFactory = new CreatureFactory();
//        Creature man = creatureFactory.createCreature(CreaturesType.ADULT, "Name1", 23);
//


                            /* test configuration*/

        RoomFactory roomFactory = new RoomFactory();
        RoomImpl hallway = roomFactory.create("Hallway");
        RoomImpl garage = roomFactory.create("Garage");
        RoomImpl kitchen = roomFactory.create("Kitchen");
        RoomImpl bedroom = roomFactory.create("Children's bedroom");
        RoomImpl bedroom2 = roomFactory.create("Parents' bedroom");
        RoomImpl livingRoom = roomFactory.create("Living room");

        List<Room> roomsForFirstFloor = Arrays.asList(hallway, kitchen, garage);
        List<Room> roomsForSecondFloor = Arrays.asList(bedroom, bedroom2, livingRoom);

        PetFactory petFactory = new PetFactory();
        PeopleFactory peopleFactory = new PeopleFactory();
        peopleFactory.create(CreaturesType.ADULT, "Papa", 40, bedroom);
        peopleFactory.create(CreaturesType.ADULT, "Mama", 35, bedroom2);
        peopleFactory.create(CreaturesType.CHILD, "Pepa", 14, hallway);
        peopleFactory.create(CreaturesType.CHILD, "George", 9, bedroom);
        petFactory.create(CreaturesType.CAT, "Fluffy", 2, "White", livingRoom);
        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(peopleFactory.getPeople());
        creatures.addAll(petFactory.getPets());


        DeviceFactory deviceFactory = new DeviceFactory();
        Device fridge = deviceFactory.createDevice(kitchen,"Fridge");
        Device airConditioner = deviceFactory.createDevice(hallway,"Air Conditioner");
        Device audioSystem = deviceFactory.createDevice(livingRoom,"Audio System");
        Device computer = deviceFactory.createDevice(bedroom,"Computer");
        Device computer1 = deviceFactory.createDevice(bedroom2,"Computer");
        Device petFeeder = deviceFactory.createDevice(hallway,"Pet Feeder");
        Device smartPhone1 = deviceFactory.createDevice(bedroom,"Smart Phone");
        Device smartPhone2 = deviceFactory.createDevice(bedroom2,"Smart Phone");
        Device smartPhone3 = deviceFactory.createDevice(livingRoom,"Smart Phone");
        Device smartVacuum = deviceFactory.createDevice(hallway,"Smart Vacuum");
        Device tv = deviceFactory.createDevice(kitchen,"TV");

        hallway.setDevices(Arrays.asList(smartVacuum, petFeeder, airConditioner));
        bedroom.setDevices(Arrays.asList(computer, smartPhone1));
        bedroom2.setDevices(Arrays.asList(smartPhone2, computer1));
        livingRoom.setDevices(Arrays.asList(audioSystem,smartPhone3));
        kitchen.setDevices(Arrays.asList(fridge, tv));
        garage.setDevices(new ArrayList<>());

        Floor firstFloor = new Floor(1, roomsForFirstFloor);
        Floor secondFloor = new Floor(2, roomsForSecondFloor);
        List<Floor> floors = new ArrayList<>();
        floors.add(firstFloor);
        floors.add(secondFloor);

        Home.HomeBuilder home = Home.newBuilder();
        Home house = home.address("Revolution 550/1").creatures(creatures).floors(floors).build();



    }
}