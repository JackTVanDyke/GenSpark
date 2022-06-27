package vandyke.jack;

public class Human extends GoblinDeezHumans {
    public Human(String name) {
        super(name,50, (int) (Math.random()*10)+3);
    }

    @Override
    public GoblinDeezHumans attack(GoblinDeezHumans target) {
        ((Goblin) target).setHealth(((Goblin) target).getHealth() - damage);
        return target;
    }

    @Override
    public String toString() {
        return "Human - [Name: " + name + "] - [Health : " + health + "] - [Damage : " + damage + "]";
    }
}
