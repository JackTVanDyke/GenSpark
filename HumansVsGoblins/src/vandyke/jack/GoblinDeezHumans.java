package vandyke.jack;

public abstract class GoblinDeezHumans {
    protected String name;
    protected int health;
    protected int damage;
    private int x = 0;
    private int y = 0;
    private int prevX;
    private int prevY;

    public GoblinDeezHumans(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public GoblinDeezHumans(int health, int damage) {
        name = "Raaraadaabaa";
        this.health = health;
        this.damage = damage;
    }

    public abstract GoblinDeezHumans attack(GoblinDeezHumans target);

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        prevX = this.x;
        this.x = x;
    }

    public void setY(int y) {
        prevY = this.y;
        this.y = y;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public String getName() {
        return name;
    }

}
