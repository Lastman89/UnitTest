package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите мин. длину пароля: ");
            int leght = scanner.nextInt();
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int repeatSymbol = scanner.nextInt();
            PasswordChecker passwordChecker = new PasswordChecker(leght, repeatSymbol);

            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Введите пароль или end: ");
            String word = scanner2.nextLine();
            if ("end".equals(word)) {
                System.out.println("Программа завершена");
                break;
            }
            passwordChecker.verify(word);

        }
    }
}