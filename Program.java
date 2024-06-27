package arrays;

public class Program {
    public static void main(String[] args) {
        int[] numbers = {3, -1, 8, 4};
        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int lowerLimit = fromWhere;
        int higherLimit = toWhere;
        if (fromWhere < 0) {
            lowerLimit = 0;
        }
        if (toWhere > array.length) {
            higherLimit = array.length;
        }
        int sum = 0;
        for (int i=lowerLimit; i<higherLimit; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            }
        }

        return sum;
    }


}
