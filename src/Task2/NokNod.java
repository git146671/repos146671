package Task2;

import java.util.Scanner;

public class NokNod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long first, second, nod;
        try {                                                       // проверка ввода целых чисел
            System.out.print("Введите первое число: ");
            first = Long.parseLong(in.nextLine());
            System.out.print("Введите второе число: ");
            second = Long.parseLong(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Вы не ввели целое число или число слишком большое");
            return;
        }
        nod = findNod(Math.abs(first), Math.abs(second));           // НОД отрицательных чисел равен НОД их модулей
        System.out.println("НОД = " + nod);
        System.out.println("НОК = " + findNok(first, second, nod));
        in.close();
    }

    static long findNod (long first, long second) {
        if (first % second == 0 || first == second) return second;
        if (second % first == 0) return first;
        if (first > second) return findNod(first % second, second);
        else return findNod(first, second % first);
    }

    static long findNok (long first, long second, long nod) {
        return first * second / nod;
    }
}
