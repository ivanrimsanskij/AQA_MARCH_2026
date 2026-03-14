import java.util.Arrays;

public class HomeWorkIvan3 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 1, 3, 6};

        System.out.println("arr: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j]  = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("arr: " + Arrays.toString(arr));
    }
}











