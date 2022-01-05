import creatures.CreatureFactory;
import creatures.CreaturesType;
import creatures.entities.Creature;
import house.*;
import stuff.DeviceFactory;
import stuff.devices.Device;
import java.util.ArrayList;
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
        CreatureFactory creatureFactory = new CreatureFactory();
        Creature papa = creatureFactory.createCreature(CreaturesType.ADULT, "Papa", 40);
        Creature mama = creatureFactory.createCreature(CreaturesType.ADULT, "Mama", 35);
        Creature child1 = creatureFactory.createCreature(CreaturesType.CHILD, "Pepa", 14);
        Creature child2 = creatureFactory.createCreature(CreaturesType.CHILD, "George", 9);
        Creature cat = creatureFactory.createCreature(CreaturesType.CAT, "Fluffy", 2);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(papa);
        creatures.add(mama);
        creatures.add(child1);
        creatures.add(child2);
        creatures.add(cat);
        String address = "Revolution 550/1";
        RoomFactory roomFactory = new RoomFactory();
        RoomImpl hallway = roomFactory.createRoom("Hallway");
        RoomImpl garage = roomFactory.createRoom("Garage");
        RoomImpl kitchen = roomFactory.createRoom("Kitchen");
        RoomImpl bedroom = roomFactory.createRoom("Children's bedroom");
        RoomImpl bedroom2 = roomFactory.createRoom("Parents' bedroom");
        RoomImpl livingRoom = roomFactory.createRoom("Living room");

        List<Room> roomsForFirstFloor = new ArrayList<>();
        roomsForFirstFloor.add(hallway);
        roomsForFirstFloor.add(kitchen);
        roomsForFirstFloor.add(garage);
        List<Room> roomsForSecondFloor = new ArrayList<>();
        roomsForSecondFloor.add(bedroom);
        roomsForSecondFloor.add(bedroom2);
        roomsForSecondFloor.add(livingRoom);

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

        List<Device> devicesForKitchen = new ArrayList<>();
        devicesForKitchen.add(fridge);
        devicesForKitchen.add(tv);
        List<Device> devicesForBedroom1 = new ArrayList<>();
        devicesForBedroom1.add(computer);
        devicesForBedroom1.add(smartPhone1);
        List<Device> devicesForBedroom2 = new ArrayList<>();
        devicesForBedroom2.add(smartPhone2);
        devicesForBedroom2.add(computer1);
        List<Device> devicesForLivingRoom = new ArrayList<>();
        devicesForLivingRoom.add(audioSystem);
        devicesForLivingRoom.add(smartPhone3);
        List<Device> devicesForGarage = new ArrayList<>();
        List<Device> devicesForHallway = new ArrayList<>();
        devicesForHallway.add(smartVacuum);
        devicesForHallway.add(petFeeder);
        devicesForHallway.add(airConditioner);

        hallway.setDevices(devicesForHallway);
        bedroom.setDevices(devicesForBedroom1);
        bedroom2.setDevices(devicesForBedroom2);
        livingRoom.setDevices(devicesForLivingRoom);
        kitchen.setDevices(devicesForKitchen);
        garage.setDevices(devicesForGarage);


        Floor firstFloor = new Floor(1, roomsForFirstFloor);
        Floor secondFloor = new Floor(2, roomsForSecondFloor);
        List<Floor> floors = new ArrayList<>();
        floors.add(firstFloor);
        floors.add(secondFloor);

        Home.HomeBuilder home = Home.newBuilder();
        Home house = home.address(address).creatures(creatures).floors(floors).build();



    }
}