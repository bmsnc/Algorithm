package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class Boj_2870 {
    static List<BigDecimal> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            char chr;
            for (int j = 0; j < line.length(); j++) {
                chr = line.charAt(j);
                if ((chr >= 'a' && chr <= 'z')) continue;
                if (chr == '0' && (j + 1) < line.length() && line.charAt(j + 1) >= '0' && line.charAt(j + 1) <= '9') continue;
                j += find(line.substring(j));
            }
        }
        Collections.sort(list);
        for (BigDecimal i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    static int find(String s) {
        StringBuilder sub = new StringBuilder();
        int idx = 0;
        char chr;
        for (int i = 0; i < s.length(); i++) {
            chr = s.charAt(i);
            if (chr >= 'a' && chr <= 'z') break;
            idx++;
            sub.append(s.charAt(i));
        }
        list.add(new BigDecimal(sub.toString()));
        return idx;
    }
}


