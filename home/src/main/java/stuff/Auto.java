package stuff;

import creatures.entities.people.Adult;
import house.Home;

public class Auto {
    public void goForFood(Adult adult){
        Home.getCreatures().remove(adult);
        System.out.println("go for food");
        //какое-то время спустя
    }

    private void returnAtHome(Adult adult){
        Home.getCreatures().add(adult);
    }
}
