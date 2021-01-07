package Task4;

import java.util.Scanner;

public class WordsCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        System.out.print("Введите предложение: ");
        String sentence = in.nextLine().toLowerCase();                      // считываем в line строку и все символы переводим в нижний регистр, чтобы организовать правильный поиск
        sentence = sentence.replaceAll("\\p{Punct}", "");   // удаляем точки и запятые
        while (sentence.contains("  ")) {                                   // избавляемся от лишних пробелов между слов
            sentence = sentence.replaceAll("  ", " ");
        }
        String[] words = sentence.trim().split(" ");                  // words - это массив слов предложения
        System.out.print("Введите слово: ");
        String word = in.nextLine().toLowerCase();
        word = word.trim();
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) count++;
        }
        System.out.println("Количество повторений слова " + word + " в тексте: " + count);
        in.close();
    }
}
