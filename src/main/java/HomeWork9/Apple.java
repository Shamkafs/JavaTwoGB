package HomeWork9;

public class Apple extends Fruit{

    private float weight = 1.0f;

    public Apple(float weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    @Override
    public float getWeight() {
        return weight;
    }

}
