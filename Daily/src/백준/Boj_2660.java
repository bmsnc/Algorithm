package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2660 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int VALUE = 1000001;
        int[][] data = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                data[i][j] = VALUE;
            }
        }

        int a, b;
        while (true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            data[a][b] = 1;
            data[b][a] = 1;
        }
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                if (k == i) continue;
                for (int j = 1; j < N + 1; j++) {
                    if (i == j) continue;
                    if (data[i][j] > data[i][k] + data[k][j]){
                        data[i][j] = data[i][k] + data[k][j];
                    }
                    if (data[i][j] == VALUE) continue;
                }
            }
        }
        int min, max = Integer.MAX_VALUE;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            min = Integer.MIN_VALUE;
            for (int j = 1; j < N + 1; j++) {
                if (data[i][j] == VALUE) continue;
                min = Math.max(min, data[i][j]);
            }
            if (max > min){
                max = min;
                list.clear();
                list.add(i);
                count = 1;
            }else if(max == min){
                list.add(i);
                count++;
            }
        }
        sb.append(max).append(" ").append(count).append("\n");
        for (Integer idx : list) {
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}
