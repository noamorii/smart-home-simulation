package creatures.entities.people;
import creatures.CreaturesType;
import creatures.entities.Creature;

public class Adult extends Creature {

    public Adult(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void moveTo() {
    }

    @Override
    public void brakeStuff() {

    }
}
