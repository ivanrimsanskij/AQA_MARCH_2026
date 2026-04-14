public class Android implements IPhone {
    @Override
    public void call() {
        System.out.println("Calling from Android");
    }

    @Override
    public void unlock() {
        System.out.println("Unlocking by fingerprint");
    }
}