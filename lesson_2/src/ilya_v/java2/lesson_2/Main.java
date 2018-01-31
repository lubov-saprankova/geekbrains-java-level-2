package ilya_v.java2.lesson_2;

import java.util.Arrays;

public class Main {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     *
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
     * и просуммировать. Если в каком-то элементе массива преобразование не удалось (например,
     * в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
     * с детализацией в какой именно ячейке лежат неверные данные.
     *
     * @param arr Строковый массив 4x4
     * @return boolean
     */
    private static int sumAllStrings(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException();

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j <= arr[i].length - 1; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        /* 3. В методе main() вызвать полученный метод, обработать возможные
        исключения MySizeArrayException и MyArrayDataException,
        и вывести результат расчета.  */
        String[][] t1 = {{"0", "1", "2", "3"}, {"0", "1", "2", "3"}, {"0", "1", "2", "3"}, {"0", "1", "2", "3"}};

        int sumFin = 0;
        try{
            try {
                sumFin =  sumAllStrings(t1);
            } catch (MyArraySizeException e){
                System.out.println(e.toString());
            }
        } catch (MyArrayDataException e1){
            System.out.println(e1.toString());
        }

        System.out.println("Сумма элементов равна " + sumFin);
    }
}
