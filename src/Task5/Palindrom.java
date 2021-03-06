package Task5;

import java.util.Scanner;

// по условию задачи максимальное число последовательности это 100. В диапазоне от 0 до 100 палиндромы -
// это все числа от 0 до 9, а также 11, 22, 33, 44, 55, 66, 77, 88 и 99. Поэтому в программе реализован
// простой перебор от 0 до N с поиском вышеуказанных чисел. Данная реализация выбрана из-за маленького диапазона
// значений, хотя для бОльшего диапазона был бы применен один из алгоритмов проверки чисел на зеркальность.

public class Palindrom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину последовательности от 1 до 100: ");
        int n;
        if (in.hasNextInt()) n = in.nextInt();
        else {
            System.out.println("Вы не ввели целое число, перезапустите программу и попробуйте еще раз.");
            return;
        }
        if (n < 0 || n > 100) {
            System.out.println("Число не в диапазоне от 0 до 100, перезапустите программу и попробуйте еще раз.");
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (i < 10 || i % 11 == 0) System.out.print(i + " ");
        }
        in.close();
    }
}
