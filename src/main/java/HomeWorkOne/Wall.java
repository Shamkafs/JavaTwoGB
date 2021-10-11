package HomeWorkOne;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    protected void jumping(Jumpable jumpable){
        jumpable.jump();
        if (getHeight() >= jumpable.getJumpHeight()) {
            System.out.println("Но стену высотой " + this.height + "м. ему не преодолеть");
        } else {
            System.out.println("Перепрыгнул стену высотой " + this.height + " м.");
        }
    }
}
