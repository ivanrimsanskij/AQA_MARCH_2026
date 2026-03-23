public class HomeWork5 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        checkInterface(apple);

        Android android = new Android();
        checkInterface(android);
    }

    public static void checkInterface(IPhone iphone) {
        iphone.call();
        iphone.unlock();
    }
}