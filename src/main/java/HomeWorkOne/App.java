package HomeWorkOne;

public class App {
    public static void main(String[] args) {

        Action[] actions = new Action[] {new Robot("Terminator", 100, 4), new Human("Макс", 2000, 2), new Cat("Барсик", 500, 1)};
        Obstacle[] obstacles = new Obstacle[] {new RunningRoad("Беговая дорожка", 1000), new Wall("Стена", 4)};
        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < obstacles.length; j++){
                obstacles[j].moving(actions[i]);
                System.out.println();
            }
        }
    }
}
