package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_12933 {
    static HashMap<Integer, String> map;
    static final String[] data = {"q", "u", "a", "c", "k"};
    static boolean[] v;
    static int count = 0;
    static String line;
    static void dfs (int idx, int d) {
        if (d >= 5) d = 0;
        String find = map.get(d);
        for (int i = idx; i < line.length(); i++) {
            if (v[i]) continue;
            if (!line.substring(i, i + 1).equals(find)) continue;
            v[i] = true;
            count++;
            dfs(i + 1, d + 1);
            break;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        line = br.readLine();
        v = new boolean[line.length()];
        if (line.charAt(0) != 'q' || line.length() < 5) {
            System.out.println(-1);
            return;
        }

        map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(i, data[i]);
        }

        char chr;
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            chr = line.charAt(i);
            if (!(v[i]) && chr == 'q') {
                dfs(i, 0);
                sum++;
                if (count % 5 != 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count != line.length() ? -1 : sum);
    }
}



