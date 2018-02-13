package ilya_v.java2.lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    /*
	    1. Написать консольный вариант клиент\серверного приложения,
	    в котором пользователь может писать сообщения, как на клиентской стороне,
	    так и на серверной. Т.е. если на клиентской стороне написать "Привет", нажать Enter
	    то сообщение должно передаться на сервер и там отпечататься в консоли. Если сделать
	    то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается
	     у него в консоли. Есть одна особенность, которую нужно учитывать: клиент или сервер может
	      написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать

            Разобраться с кодом с занятия, он является фундаментом проекта-чата
            ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл,
             который будет ожидать второго/третьего/n-го клиентов
	     */

	    try (ServerSocket serverSocket = new ServerSocket(8181)){

	        System.out.println("Сервер запущен. Ожидание клиента...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент успешно присоединился к серверу.");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true) {
                String message = in.nextLine();
                System.out.println("Клиент: " + message);
                out.println("echo: " + message);

                if (message.equals("/end")) break;
            }

        } catch (IOException e){
	        e.printStackTrace();
        }




    }
}
