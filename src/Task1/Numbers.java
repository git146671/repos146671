package Task1;

import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number;
        boolean even = false;                           // четность / нечетность
        String simple = "Простое";                      // простое / составное / не простое не составное
        System.out.print("Введите челое число: ");
        try {                                           // проверка ввода целого числа
            number = Long.parseLong(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Вы не ввели целое число или число слишком большое");
            return;
        }
        if (number % 2 == 0) even = true;
        if (number < 2) simple = "Не простое, не составное";
        else if (even) simple = "Составное";            // если число больше 1 и четное, то оно точно составное
            else {                                      // если число больше 1 и нечетное, определяем, простое ли оно
            int i = 3;
            while (Math.pow(i, 2) <= number) {
                if (number % i == 0) {
                    simple = "Составное";
                    break;
                } else i += 2;
            }
        }
        if (even) System.out.print("Четное\n" + simple);
        else System.out.print("Нечетное\n" + simple);
        in.close();
    }
}
