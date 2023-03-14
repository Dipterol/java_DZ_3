//Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task_2 {
    public static void task_2() throws IOException {
        String str = fileReader().replace(" ", "")
                .replace("[", "").replace("]", "");
        String[] res = str.split(",");
        ArrayList result = removeS(res);
        System.out.printf("Список без четных чисел : " + result);
    }
    private static ArrayList removeS(String[] res) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : res) {
            list.add(Integer.parseInt(s));
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        return list;
    }

    private static String fileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
        String str = br.readLine();
        return str;
    }
}
