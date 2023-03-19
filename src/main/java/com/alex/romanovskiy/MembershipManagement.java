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
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("\nОШИБКА: Недопустимое значение, попробуйте еще.");
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("\n1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println("\nДОБРО ПОЖАЛОВАТЬ В OZONE FITNESS CENTER");
        System.out.println("=======================================");
        System.out.println("1) Добавить члена клуба");
        System.out.println("2) Удалить члена клуба");
        System.out.println("3) Вывести информацию о члене клуба");
        System.out.print("Пожалуйста выберите нужный пункт или введите -1 для выхода): ");

        int choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberId;
        Member mbr;
        Calculator<Integer> cal;

        System.out.print("Введите имя: ");
        name = reader.nextLine();

        printClubOptions();
        System.out.println("Выберите нужный клуб: ");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("ОШИБКА: Недопустимое значение, попробуйте еще.");
            club = getIntInput();
        }
        //присваивание идентификатора
        if (m.size() > 0)
            memberId = m.getLast().getMemberId() + 1;
        else
            memberId = 1;

        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberId, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATS: Новый член клуба добавлен\n");
        }
        else {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 1200;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberId, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATS: Новый член мульти-клуба добавлен\n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberId;
        System.out.println("Введите id посетителя клуба которого хотите удалить: ");
        memberId = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (memberId == m.get(i).getMemberId()) {
                m.remove(i);
                System.out.println("Посетитель с id - " + memberId + ", удален.");
                return;
            }
        }
        System.out.println("Посетитель с таким id не найден.");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberId;
        System.out.println("Введите id посетителя клуба: ");
        memberId = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (memberId == m.get(i).getMemberId()) {
                String[] memberInfo = m.get(i).toString().split(", ");
                if (memberInfo[0].equals("S")){
                    System.out.println("Member Type = " + memberInfo[0]);
                    System.out.println("Member ID = " + memberInfo[1]);
                    System.out.println("Member name = " + memberInfo[2]);
                    System.out.println("Membership Fees = " + memberInfo[3]);
                    System.out.println("Club ID = " + memberInfo[4]);
                } else {
                    System.out.println("Member Type = " + memberInfo[0]);
                    System.out.println("Member ID = " + memberInfo[1]);
                    System.out.println("Member name = " + memberInfo[2]);
                    System.out.println("Membership Fees = " + memberInfo[3]);
                    System.out.println("Membership Points = " + memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("Посетитель с таким id не найден.");
    }
}
