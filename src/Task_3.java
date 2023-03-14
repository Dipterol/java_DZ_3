//   Задан целочисленный список ArrayList.
//   Найти минимальное, максимальное и среднее ариф. из этого списка.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task_3 {
    public static void task_3() throws IOException {
        String str = fileReader().replace(" ", "")
                .replace("[", "").replace("]", "");
//        System.out.println(str);
        String[] res = str.split(",");
        ArrayList<Integer> list = new ArrayList<>();

        for (String s : res) {
            list.add(Integer.parseInt(s));
        }

        int min = list.get(0);
        int max = list.get(0);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        System.out.println("Минимальное число : " + min);
        System.out.println("Максимальное число : " + max);
        System.out.println("Среднее арифметическое : " + sum / list.size());
    }

    private static String fileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
        String str = br.readLine();
        return str;
    }

    private static void getNum(String[] res) {


    }
}