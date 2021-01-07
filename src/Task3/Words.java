package Task3;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String line = in.nextLine().toLowerCase();                  // считываем в line строку и все символы переводим в нижний регистр, чтобы была правильная сортировка
        line = line.replaceAll("\\p{Punct}", "");   // удаляем точки и запятые
        while (line.contains("  ")) {                               // избавляемся от лишних пробелов между слов
            line = line.replaceAll("  ", " ");
        }
        String[] words = line.trim().split(" ");              // words - это массив слов предложения
        Arrays.sort(words);
        System.out.println("Количество слов: " + words.length);
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i].substring(0, 1).toUpperCase() + words[i].substring(1) + " ");
        }
        in.close();
    }
}