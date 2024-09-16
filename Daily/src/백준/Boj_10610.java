package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10610 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line.indexOf('0') == -1 ) {
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0, temp;
        for (int i = 0; i < line.length(); i++) {
            temp = line.charAt(i) - '0';
            sum += temp;
            list.add(temp);
        }
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        list.sort(Collections.reverseOrder());
        for (Integer i : list) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}

