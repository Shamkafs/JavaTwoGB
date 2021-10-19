package HomeWorkOne;

public abstract class Obstacle {

    private String name;

    public Obstacle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void moving(Action action);
}
