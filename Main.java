package org.example;

import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"Местный", "Из близлежащего города", "Из дальнего города"};
        Scanner in = new Scanner(System.in);
        PriorityQueue<Client> pq = new PriorityQueue<>(new ClientComparator());
        Client client1 = new Client("Mark",  1);
        pq.add(client1);
        Client client2 = new Client("Shelly",  2);
        pq.add(client2);
        Client client3 = new Client("Kristen", 3);
        pq.add(client3);
        Client client4 = new Client("Malcolm", 3);
        pq.add(client4);
        int choice = -1;
        String name;
        double time;
        int type;
        while (choice!=0) {
            System.out.println("""
                    Введите 1, если хотите вывести всех клиентов
                    Введите 2, если хотите добавить клиента
                    Введите 3, если хотите позвать клиента
                    Введите 0, если хотите выйти""");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    for (Client client : pq) {
                        System.out.println("Имя: " + client.getName() +
                                " Тип города: " + array[(int)client.getTownType()-1]);
                    }
                }
                case 2 -> {
                    try {
                        System.out.println("Введите имя");
                        name = in.next();
                        System.out.println("""
                                Введите тип клиента:
                                1 - местный
                                2 - из близлежащего города
                                3 - из дальнего города""");
                        type = in.nextInt();
                        if (type<1 || type>3) {
                            throw new EmptyStackException();
                        }
                        Client cl = new Client(name, type);
                        pq.add(cl);
                    } catch (Exception e) {
                        System.out.println("Вы ввели неверные данные");
                    }
                }
                case 3 -> {
                    try {
                        System.out.println(pq.poll().getName());
                    } catch (Exception e) {
                    System.out.println("Клиентов больше нет");
                    }
                }
            }
        }
    }
}
