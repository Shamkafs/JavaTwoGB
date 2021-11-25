package HomeWork9;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(){
        fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public void replaceTheFruitBox(Box<T> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public void addFruit(T fruitAdd) {
        fruits.add(fruitAdd);
    }
}
