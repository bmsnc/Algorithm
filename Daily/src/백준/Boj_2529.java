package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2529 {
    static String[] data;
    static boolean[] v;
    static int N;
    static boolean flag;
    static String max, min;
    static void upRecursive(int idx, int[] sel){
        if (flag) return;
        if (idx == N + 1){
            for (int i = 0; i < N; i++) {
                if (data[i].equals(">")){
                    if (!(sel[i] > sel[i + 1])) return;
                }else if (data[i].equals("<")){
                    if (!(sel[i] < sel[i + 1])) return;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i : sel) {
                result.append(i);
            }
            min = result.toString();
            flag = true;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (v[i]) continue;
            v[i] = true;
            sel[idx] = i;
            upRecursive(idx + 1, sel);
            v[i] = false;
        }
    }
    static void downRecursive(int idx, int[] sel){
        if (flag) return;
        if (idx == N + 1){
            for (int i = 0; i < N; i++) {
                if (data[i].equals(">")){
                    if (!(sel[i] > sel[i + 1])) return;
                }else if (data[i].equals("<")){
                    if (!(sel[i] < sel[i + 1])) return;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i : sel) {
                result.append(i);
            }
            max = result.toString();
            flag = true;
            return;
        }

        for (int i = 9; i > -1; i--) {
            if (v[i]) continue;
            v[i] = true;
            sel[idx] = i;
            downRecursive(idx + 1, sel);
            v[i] = false;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        data = new String[N];
        v = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = st.nextToken();
        }

        min = "";
        max = "";
        flag = false;
        upRecursive(0,  new int[N + 1]);
        flag = false;
        downRecursive(0, new int[N + 1]);
        sb.append(max).append("\n");
        sb.append(min).append("\n");

        System.out.println(sb);
    }
}
