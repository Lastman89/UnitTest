package ru.netology;

public class PasswordChecker {
    public int leght;
    public int repeat;

    public void setMinLength(int leght) {
        if (leght < 0) {
            throw new IllegalArgumentException("Длина пароля не может быть меньше нуля");
        }
    }

    public void setMaxRepeats(int repeat) {
        if (repeat <= 0) {
            throw new IllegalArgumentException("Число повторений символа не может быть менее 1!");
        }
    }

    public PasswordChecker(int leght, int repeat) {
        this.leght = leght;
        try {
            setMinLength(leght);
        } catch (Exception e) {
            System.out.println("Введите корректное значение длины пароля! Длина пароля не может быть меньше нуля");
            System.exit(0);//Для завершения работы программы
        }
        this.repeat = repeat;
        try {
            setMaxRepeats(repeat);
        } catch (Exception e) {
            System.out.println("Введите корректное значение количества повторений символов пароля! Значение не может быть менее 1");
            System.exit(0);//Для завершения работы программы
        }
    }

    public boolean verify(String password) {
        int leghtPassword = password.length();
        int symbolRepeat = 1;
        char[] charArr = new char[leghtPassword];
        for (int i = 0; i < leghtPassword; i++) {
            charArr[i] = password.charAt(i);
        }

        if (leghtPassword >= leght) {
            if (leght == 0) {
                throw new IllegalArgumentException("Не установлено минимальное значение длины пароля!");
            }
            for (int i = 0; i < password.length(); i++) {
                if (i + 1 < password.length()) {
                    if (charArr[i] == charArr[i + 1]) {
                        symbolRepeat++;
                        if (symbolRepeat > repeat) {
                            break;
                        }
                    } else {
                        symbolRepeat = 1;
                    }
                }
            }
            System.out.println("Число повторений: " + symbolRepeat);
            System.out.println("Ограничение повториений: " + repeat);
            if (symbolRepeat <= repeat) {
                System.out.println("Подходит!");
                return true;
            } else {
                throw new IllegalArgumentException("Количество повторений символов подряд превышает " + repeat);
            }
        } else {
            return false;//throw new IllegalArgumentException("Количество символов пароля не может быть менее " + leght);
        }
    }
}
