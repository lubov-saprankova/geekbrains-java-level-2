package ilya_v.java2.lesson_2;

import java.util.Arrays;

public class Main {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     *
     * @param arr Строковый массив 4x4
     */
    private static void twoStringArr(String[][] arr) {

        if ((arr.length != 4) || (arr[0].length != 4)) throw new MyArraySizeException("Необходим массив размером 4х4");

        System.out.println(Arrays.deepToString(arr));
    }

    /**
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
     * и просуммировать. Если в каком-то элементе массива преобразование не удалось (например,
     * в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
     * с детализацией в какой именно ячейке лежат неверные данные.
     */
    private static int sumAllStrings(String[][] arr) {
        int sum = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                try {
                    sum += parseInt(arr[i][j]);
                } catch (MyArrayDataException e) {
                    System.out.println("Исключение для i = " + i + " и j = " + j + ": " + e);
                }
            }
        }

        return sum;
    }

    private static int parseInt(String str) throws MyArrayDataException {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new MyArrayDataException(e.toString());
        }
    }

    public static void main(String[] args) {
        String[][] t = new String[4][4];
        String[][] t1 = {{"0", "1", "2", "3kjhjjj"}, {"0", "1", "2", "3"}, {"0", "1", "2", "3"}, {"0", "1", "2", "3"}};
        twoStringArr(t1);
        System.out.println(sumAllStrings(t1));

        /*


        3. В методе main() вызвать полученный метод, обработать возможные
             исключения MySizeArrayException и MyArrayDataException,
              и вывести результат расчета.  */
    }
}
