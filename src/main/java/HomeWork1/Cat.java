package HomeWork1;

public class Cat implements Runnable, Jumpable {

    @Override
    public void jump() {
        System.out.println("Кот прыгает");
    }

    @Override
    public void run() {
        System.out.println("Кот бегает");
    }
}
