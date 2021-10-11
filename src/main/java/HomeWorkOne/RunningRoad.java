package HomeWorkOne;

public class RunningRoad {
    private int length;

    public RunningRoad(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    protected void running(Runnable runnable){
        runnable.run();
        if (getLength() >= runnable.getDistanceRun()) {
            System.out.println("Но дистанцию в " + this.length + " м. по беговой дорожке ему не преодолеть");
        } else {
            System.out.println("Пробежать по беговой дорожке " + this.length + " м. ему не составит труда");
        }
    }
}
