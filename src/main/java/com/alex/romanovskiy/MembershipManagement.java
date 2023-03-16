package com.alex.romanovskiy;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
public class MembershipManagement {
    private final Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                System.out.println("Введите целое число: ");
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException("ОШИБКА: Недопустимое значение, попробуйте еще.");
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println(e);
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }


}
