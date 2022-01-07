package stuff;

import creatures.entities.people.Adult;
import house.Home;
import house.Room;

public class Auto extends UsableObject {

    protected Auto(int usingTicks, Room room) {
        super(usingTicks, room);
    }

    public void goForFood(Adult adult){
        Home.getCreatures().remove(adult);
        System.out.println("go for food");
        //какое-то время спустя
    }

    private void returnAtHome(Adult adult){
        Home.getCreatures().add(adult);
    }
}
