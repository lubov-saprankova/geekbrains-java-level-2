package ilya_v.java2.lesson_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static float[] createArr(int size){

        // 1. Создают одномерный длинный массив, например:
        float[] arr = new float[size];

        // 2. Заполняют этот массив единицами.
        for (int i = 0; i < arr.length; i++){
                arr[0] = 1;
        }

        return arr;
    }

    static long reSetArr(float[] arr) {

        // 3) Засекают время выполнения:

        long a = System.currentTimeMillis();

        // 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        /*
        5) Проверяется время окончания метода System.currentTimeMillis().
        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).*/
        return (System.currentTimeMillis() - a);
    }

    static long reSetArrInTwoThread(float[] arr) {

    }

    public static void main(String[] args) {

        float[] arr = createArr(10_000_000);
        System.out.println(reSetArr(arr));

        /* Отличие первого метода от второго:
            ● Первый просто бежит по массиву и вычисляет значения.
            ● Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
            потом склеивает эти массивы обратно в один. */




        /* 1. Необходимо написать два метода, которые делают следующее:
        1) Создают одномерный длинный массив, например:

        static final int size = 10000000;
        static final int h = size / 2;
        float[] arr = new float[size];*/





       /* MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        Thread t3 = new Thread(new MyRunnable() {
            @Override
            public void run() {
                super.run();
            }
        });

        t3.start();

        ExecutorService service = Executors.newFixedThreadPool(55);

        for (int i = 0; i < 55; i++) {
            int x = i;
            service.execute(() -> System.out.println("A" + i));
        }

        service.shutdown();

        new Thread(() -> { System.out.println("yo");}).start();*/


    }
}
