package vandyke.jack;

public class Goblin extends GoblinDeezHumans {
    public Goblin() {
        super((int) ((Math.random() * 20) + 1), (int) ((Math.random() * 5) + 1));
    }

    @Override
    public GoblinDeezHumans attack(GoblinDeezHumans target) {
        ((Human) target).setHealth(((Human) target).getHealth() - damage);
        return target;
    }

    @Override
    public String toString() {
        return "Goblin - [Name : " + name + "] - [Health : " + health + "] - [Damage : " + damage + "]";
    }
}
