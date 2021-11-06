package HomeWork3;

import java.util.HashMap;
import java.util.Map;

public class Array {
    public static void main(String[] args) {
        String[] animals = {"Cat", "Dog", "Cat", "Duck", "Chicken", "Cow" , "Cat", "Chicken", "Dog", "Pig", "Cow", "Cat"};
        Map<String, Integer> map = new HashMap<>();
        for (String animal : animals) {
            if (map.containsKey(animal)) {
                map.put(animal, map.get(animal) + 1);
            } else {
                map.put(animal, 1);
            }
        }
        System.out.println(map);
    }
}
