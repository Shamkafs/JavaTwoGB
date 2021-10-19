package HomeWorkOne;

public class RunningRoad extends Obstacle {
    private int length;

    public RunningRoad(String name, int length) {
        super(name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    void moving(Action action) {
        action.run();
        if (getLength() <= action.getDistanceRun()) {
            System.out.println("Пробежал беговую дорожку длиной " + this.length + "м.");
        } else {
            System.out.println("Не смог пробежать беговую дорожку длиной " + this.length + "м.");
        }
    }


    /*protected void running(Runnable runnable){
        runnable.run();
        if (getLength() >= runnable.getDistanceRun()) {
            System.out.println("Но дистанцию в " + this.length + " м. по беговой дорожке ему не преодолеть");
        } else {
            System.out.println("Пробежать по беговой дорожке " + this.length + " м. ему не составит труда");
        }
    }*/
}
