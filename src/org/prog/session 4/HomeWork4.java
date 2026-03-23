public class HomeWork4 {
    public static void main(String[] args) {
        Phone phone1 = PhoneShop.buyPhone("xiomi","black");
        Phone phone2 = PhoneShop.buyPhone("iphone", "white");
        Phone phone3 = PhoneShop.buyPhone("samsung", "blue");

        if (phone1 != null) {
            phone1.ring();
        }

        if (phone2 != null) {
            phone2.ring();
        }

        if (phone3 != null) {
            phone3.ring();
        }
    }
}