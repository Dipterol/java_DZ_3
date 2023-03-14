////Реализовать алгоритм сортировки слиянием
//


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task_1 {
    public static void task_1() throws IOException {
        String str = fileReader();
        String[] arrS = str.replace("[", "").replace("]", "").replace(" ", "").split(",");
        int[] arr = new int[arrS.length];
        for (int i = 0; i < arrS.length; i++) {
            arr[i] = Integer.parseInt(arrS[i]);
        }

        System.out.println("Массив до сортировки: " + str);
        mergeSort(arr);
        System.out.println("Массив после сортировки: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, mid);
        mergeSort(arr, temp, mid + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        while (left <= leftEnd) {
            temp[index] = arr[left];
            left++;
            index++;
        }

        while (right <= rightEnd) {
            temp[index] = arr[right];
            right++;
            index++;
        }

        for (int i = 0; i < size; i++) {
            arr[leftStart + i] = temp[leftStart + i];
        }
    }

    private static String fileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
        String str = br.readLine();
        return str;
    }
}
