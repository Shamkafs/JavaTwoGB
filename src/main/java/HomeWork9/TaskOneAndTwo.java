package HomeWork9;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskOneAndTwo {

    public static void main(String[] args) {

        Integer[] arr = new Integer[] {1,2,3,4,5,6};
        System.out.println("Массив после конвертации в ArrayList: " + convertArrayInArrayList(arr));

        System.out.println("Массив до замены элементов: " + Arrays.toString(arr));
        System.out.println("Массив после замены элементов: " + Arrays.toString(swapTwoElementArray(arr)));


        String[] str = new String[] {"Маша","Саша","Даша","Паша"};
        System.out.println("Массив после конвертации в ArrayList: " + convertArrayInArrayList(str));

        System.out.println("Массив до замены элементов: " + Arrays.toString(str));
        System.out.println("Массив после замены элементов: " + Arrays.toString(swapTwoElementArray(str)));

    }

    public static <T> T[] swapTwoElementArray(T[] array) {
            T t = array[1];
            array[1] = array[2];
            array[2] = t;
            return array;
    }

    public static <T> ArrayList<T> convertArrayInArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}
