package HomeWorkOne;

public class Cat implements Runnable, Jumpable {
    private String name;
    private int distanceRun;
    private int jumpHeight;

    public Cat(String name, int distanceRun, int jumpHeight) {
        this.name = name;
        this.distanceRun = distanceRun;
        this.jumpHeight = jumpHeight;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public void jump() {
        System.out.println("Кот " + this.name + " умеет прыгать на " + this.getJumpHeight() + " м. в высоту");
    }


    @Override
    public void run() {
        System.out.println("Кот " + this.name + " может пробежать " + this.getDistanceRun() + " м.");
    }
}
