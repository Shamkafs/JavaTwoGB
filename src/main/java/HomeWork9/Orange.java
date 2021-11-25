package HomeWork9;

public class Orange extends Fruit{

    private float weight = 1.5f;

    public Orange(float weight) {
        this.weight = weight;
    }

    public Orange() {
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

