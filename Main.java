import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arrInt = new int[]{
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100)
        };
        System.out.println(Arrays.toString(arrInt));
        Arrays.sort(arrInt);
        System.out.println(Arrays.toString(arrInt));
        System.out.println(binarySearchInt(arrInt, 30));
        System.out.println(binarySearchInt(arrInt, 40));

        // а теперт рассмотрим для объектов
        System.out.println("***");
        String[] arrString = new String[]{
                "Вася",
                "Петя",
                "Анна",
                "Соня",
                "Егор",
                "Маша",
        };
        System.out.println(Arrays.toString(arrString));
        Arrays.sort(arrString);
        System.out.println(Arrays.toString(arrString));
        System.out.println(Arrays.binarySearch(arrString, "Вася"));
        System.out.println(Arrays.binarySearch(arrString, "Соня"));
    }

    private static int binarySearchInt(int[] sortedArray, int key) {
        int left = 0;
        int right = sortedArray.length - 1;
        int resultIdx = Integer.MAX_VALUE;              // если не найдено
        while (left <= right) {                         // если левая часть меньше правой, тогда ...
            int middle = ((left + right) / 2);          // вычисляем середину массива
            if (sortedArray[middle] < key) {            // если значение в середине массива меньше ключа, тогда ...
                left = middle + 1;                      // ... левая часть смещается от предыдущей середины
            } else if (sortedArray[middle] > key) {     // если значение в середине массива больше ключа, тогда ...
                right = middle - 1;                     // ... правая часть смещается от предыдущей середины
            } else if (sortedArray[middle] == key) {    // если значение в середине массива и есть искомый ключ, тогда ...
                resultIdx = middle;                     // ... положение ключа в середине, присваиваем значение индекса
                break;
            }
        }
        return resultIdx;
    }

}
