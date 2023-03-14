import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class recFile {
    public static void recFil() {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList al = randArr(arr);
        System.out.println(arr);
        rec(arr);
    }

    private static ArrayList randArr(ArrayList arr) {
        Random random = new Random();
        int len = random.nextInt(10, 15);
        for (int i = 0; i < len; i++) {
            int num = random.nextInt(5, 20);
            arr.add(num);
        }
        return arr;
    }

    public static void rec(ArrayList arr) {
        String file_name = "rec.txt";
        File file = new File(file_name);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(arr));

            writer.close();
            System.out.println("Успешная запись файла для дз");
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }
}
