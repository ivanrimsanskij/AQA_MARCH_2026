package org.prog.session6;

public class HomeWorkIvan6 {

    public static void main(String[] args) {
        Ph ios = new Ph();
        Ph android = new Ph();
        ios.color = "red";
        ios.brand = null;
        android.color = "red";
        android.brand = "fly";

        try {
            ios.equals(android);
        } catch (RuntimeException e) {
            System.out.println("oops, phone has no brand or color!");
        }
    }

}
