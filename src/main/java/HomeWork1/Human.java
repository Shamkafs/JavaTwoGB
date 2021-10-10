package HomeWork1;

public class Human implements Runnable, Jumpable {

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
    }

    @Override
    public void run() {
        System.out.println("Человек бегает");
    }
}
