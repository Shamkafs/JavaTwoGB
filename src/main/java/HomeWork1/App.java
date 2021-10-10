package HomeWork1;

public class App {
    public static void main(String[] args) {
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();

        Jumpable[] jumpables = new Jumpable[] {cat, human, robot};
        for (Jumpable jumpable : jumpables) {
            jumpable.jump();
        }
    }
}
