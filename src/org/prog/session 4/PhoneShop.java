public class PhoneShop {
    public static Phone buyPhone (String brand, String color ) {
        if (!brand.equalsIgnoreCase("iphone") && !color.equalsIgnoreCase("black")) {
            System.out.println("Enjoy your new phone!");
            return new Phone(brand, color);
        } else {
            System.out.println("We don't have this phone");
            return null;
        }
    }
}