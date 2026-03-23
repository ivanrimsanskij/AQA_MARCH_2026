public class Phone {
    public String brand;
    public String color;

    public Phone() {

    }

    public Phone(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void ring() {
        System.out.println("This phone is " + brand);
        System.out.println("The color of this phone is " + color);
    }
}



