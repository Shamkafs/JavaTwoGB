package HomeWork1;

public class Robot implements Runnable, Jumpable {

    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }

    @Override
    public void run() {
        System.out.println("Робот бегает");
    }
}
