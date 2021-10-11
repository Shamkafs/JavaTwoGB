package HomeWorkOne;

public class App {
    public static void main(String[] args) {
        Human human = new Human("Maks", 2000, 2);
        Cat cat = new Cat("Barsik", 500, 1);
        Robot robot = new Robot("Terminator", 100, 4);
        Wall wall = new Wall( 3);
        RunningRoad runningRoad = new RunningRoad(1000);

        Jumpable[] jumpables = new Jumpable[] {cat, human, robot};
        for (Jumpable jumpable : jumpables) {
            wall.jumping(jumpable);
        }
        System.out.println();

        Runnable[] runnables = new Runnable[] {cat, human, robot};
        for (Runnable runnable : runnables) {
            runningRoad.running(runnable);
        }


    }
}
