package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1475 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int[] data = new int[9];

        char num;
        for (int i = 0; i < line.length(); i++) {
            num = line.charAt(i);
            if (num == '9') num = '6';
            data[num - '0']++;
        }
        data[6] = data[6] % 2 == 0 ? data[6] / 2 : data[6] / 2 + 1;
        int max = -1;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, data[i]);
        }
        System.out.println(max);
    }
}
