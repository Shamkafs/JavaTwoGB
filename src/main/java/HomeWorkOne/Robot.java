package HomeWorkOne;

public class Robot implements Action {
    private String name;
    private int distanceRun;
    private int jumpHeight;

    public Robot(String name, int distanceRun, int jumpHeight) {
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
        System.out.println("Робот " + this.name + " умеет прыгать на " + this.getJumpHeight() + " м. в высоту");
    }

    @Override
    public void run() {
        System.out.println("Робот " + this.name + " может пробежать " + this.getDistanceRun() + " м.");
    }
}
