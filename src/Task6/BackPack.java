package Task6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/Task6/input"));
        Scanner console = new Scanner(System.in);
        List<Thing> things = new ArrayList<>();
        System.out.print("Введите грузоподъемность рюкзака: ");
        int weight;
        if (console.hasNextInt()) weight = console.nextInt();
        else {
            System.out.println("Вы не ввели целое число, перезапустите программу и попробуйте еще раз.");
            return;
        }
        if (weight < 0) weight *= -1;                               // если ошиблись и ввели минусовую грузоподъемность, делаем ее положительной
        while (file.hasNextLine()) {
            String[] line = file.nextLine().split(" ");
            things.add(new Thing(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        int[][] cost = new int[things.size() + 1][weight + 1];      // массив хранит сумарные стоимости вещей для рюкзака вместимостью от 0 до заданного веса
        for (int i = 0; i <= things.size() ; i++)                   // максимальную ценность ищем с помощью динамического программирования
            for (int j = 0; j <= weight; j++) {
                if (i == 0 || j == 0)
                    cost[i][j] = 0;                                 //первый столбец и строка массива будут нулями т.к. стоимость нулевой вещи 0 и при вместимости 0 никакую вещь положить нельзя
                    else if (j < things.get(i - 1).weight || cost[i - 1][j] >= cost[i - 1][j - things.get(i - 1).weight] + things.get(i - 1).price)
                        cost[i][j] = cost[i - 1][j];
                            else cost[i][j] = cost[i - 1][j - things.get(i - 1).weight] + things.get(i - 1).price;
            }
        System.out.println("В Ваш рюкзак можно поместить вещи с максимальной ценностью " + cost[things.size()][weight]);
        file.close();
        console.close();
    }

    static class Thing {
        int weight;
        int price;

        public Thing(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
