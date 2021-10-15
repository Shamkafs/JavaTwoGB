package HomeWorkOne;

public class Wall extends Obstacle {
    private int height;

    public Wall(String name, int height) {
        super(name);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    void moving(Action action) {
        action.jump();
        if (getHeight() <= action.getJumpHeight()) {
            System.out.println("Перепрыгнул стену высотой " + this.height + "м.");
        } else {
            System.out.println("Не перепрыгнул стену высотой " + this.height + "м.");
        }
    }



    /*protected void jumping(Jumpable jumpable){
        jumpable.jump();
        if (getHeight() >= jumpable.getJumpHeight()) {
            System.out.println("Но стену высотой " + this.height + "м. ему не преодолеть");
        } else {
            System.out.println("Перепрыгнул стену высотой " + this.height + " м.");
        }
    }*/
}
