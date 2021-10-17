package HomeWork2;

import java.util.Arrays;

public class HomeWork2App {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println(Arrays.deepToString(arr));
        try {
            int result = arrayFourByFour(arr);
            System.out.println(result);
        }
        catch (MyArraySizeException e) {
            System.out.println("Неверно подан размер массива");
        }
        catch (MyArrayDataException e) {
            System.out.println("Неверные данные в ячейке массива");
            System.out.println("Ошибка в ячейке: i = " + e.i + " j = " + e.j);
        }

    }


    public static int arrayFourByFour(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException();
                }
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }

}
