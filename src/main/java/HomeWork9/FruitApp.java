package HomeWork9;

public class FruitApp {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        System.out.println("Вес одного яблока: " + apple1.getWeight());

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        System.out.println("Вес одного апельсина: " + orange1.getWeight());

        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);
        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());

        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());

        System.out.println("Сравнение первой коробки с яблоками и первой коробки с апельсинами: " + appleBox1.compare(orangeBox1));

        System.out.println("Пересыпаем фрукты в другие коробки");
        appleBox1.replaceTheFruitBox(appleBox2);
        System.out.println("Вес первой коробки с яблоками стал: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками стал: " + appleBox2.getWeight());
        orangeBox1.replaceTheFruitBox(orangeBox2);
        System.out.println("Вес первой коробки с апельсинами стал: " + orangeBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами стал: " + orangeBox2.getWeight());

    }
}
