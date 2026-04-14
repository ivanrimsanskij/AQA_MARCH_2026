public class Apple implements IPhone {
    @Override
    public void call() {
        System.out.println("Calling from Apple");
    }

    @Override
    public void unlock() {
        System.out.println("Unlocking by faceID");
    }
}